package com.itmd.cart.service;

import com.itmd.auth.entiy.UserInfo;
import com.itmd.cart.filter.LoginInterceptor;
import com.itmd.cart.pojo.Cart;
import com.itmd.cart.utils.JsonUtils;
import com.itmd.enums.ExceptionEnum;
import com.itmd.exception.RaoraoBookShopException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String key_prefix = "cart:uid:";

    public void addCart(Cart cart) {
        //获取用户
        UserInfo user = LoginInterceptor.getUser();
        //key (用户ID）
        String key = key_prefix + user.getId();
        // hashkey (图书ID)
        String hashkey = cart.getBookId().toString();
        //记录num
        Integer num = cart.getNum();

        //判断购物车是否存在此图书
        BoundHashOperations<String, Object, Object> oper = redisTemplate.boundHashOps(key);
       if(oper.hasKey(hashkey)){
           //修改数量
           String json = oper.get(hashkey).toString();
           cart  = JsonUtils.parse(json, Cart.class);
           cart.setNum(num + cart.getNum());
       }
        oper.put(hashkey, JsonUtils.serialize(cart));
    }

    public List<Cart> queryCartList() {
        //获取用户
        UserInfo user = LoginInterceptor.getUser();
        //key (用户ID）
        String key = key_prefix + user.getId();
        if(!redisTemplate.hasKey(key)){
            //key 不存在
            throw new RaoraoBookShopException(ExceptionEnum.CART_NOT_FOUND);
        }
        BoundHashOperations<String, Object, Object> oper = redisTemplate.boundHashOps(key);
        List<Object> values = oper.values();
        List<Cart> carts = oper.values().stream()
                .map(o -> JsonUtils.parse(o.toString(), Cart.class))
                .collect(Collectors.toList());
        return carts;
    }

    public void updateCartNumber(Long bid, Integer num) {
        //获取用户
        UserInfo user = LoginInterceptor.getUser();
        //key (用户ID）
        String key = key_prefix + user.getId();
        //hashKey (图书ID）
        String hashKey = bid.toString();

        BoundHashOperations<String, Object, Object> oper = redisTemplate.boundHashOps(key);
        if(!oper.hasKey(hashKey)){
            throw new RaoraoBookShopException(ExceptionEnum.CART_NOT_FOUND);
        }
        Cart cart = JsonUtils.parse(oper.get(hashKey).toString(), Cart.class);
        if(num < 1 ){
            throw new RaoraoBookShopException(ExceptionEnum.CART_NOT_FOUND);
        }
        cart.setNum(num);
        oper.put(hashKey, JsonUtils.serialize(cart));
    }

    public void deleteCartNumber(Long bid) {
        //获取用户
        UserInfo user = LoginInterceptor.getUser();
        //key (用户ID）
        String key = key_prefix + user.getId();
        //hashKey (图书ID）
        String hashKey = bid.toString();
        //删除
        redisTemplate.opsForHash().delete(key, hashKey);
    }
}
