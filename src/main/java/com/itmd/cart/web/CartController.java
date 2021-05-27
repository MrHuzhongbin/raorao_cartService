package com.itmd.cart.web;

import com.itmd.cart.pojo.Cart;
import com.itmd.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("one")
    public ResponseEntity<Void> addCart(Cart cart){
        cartService.addCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("list")
    public ResponseEntity<List<Cart>> queryCartList(){
        return  ResponseEntity.ok((cartService.queryCartList()));
    }
    @PutMapping("one")
    public ResponseEntity<Void> updateCartNumber(@RequestParam("bid")Long bid,@RequestParam("num")Integer num){
        cartService.updateCartNumber(bid,num);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("{bid}")
    public ResponseEntity<Void> deleteCartNumber(@PathVariable("bid")Long bid){
        cartService.deleteCartNumber(bid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
