package com.itmd.cart.pojo;

import lombok.Data;

@Data
public class Cart {
    private Long bookId;// 商品id
    private String title;// 标题
    private String image;// 图片
    private Float price;// 加入购物车时的价格
    private Integer num;// 购买数量
}
