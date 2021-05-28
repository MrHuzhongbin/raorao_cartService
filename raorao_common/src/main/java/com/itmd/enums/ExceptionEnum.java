package com.itmd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum  ExceptionEnum {


    CLASSIFICATION_NOT_FOUND(202,"分类未找到"),
    CLASSIFICATION_SAVE_ERROR(202,"分类添加失败"),
    CLASSIFICATION_DELETE_ERROR(202,"分类删除失败"),
    CLASSIFICATION_UPDATE_ERROR(202,"分类修改失败"),
    PRESS_UPDATE_ERROR(202,"出版社修改失败"),
    PRESS_DELETE_ERROR(202,"出版社删除失败"),
    PRESS_SAVE_ERROR(202,"出版社添加失败"),
    PRESS_NOT_FOUND(202,"出版社未查询到数据"),
    BOOK_NOT_FOUND(202,"图书未查询到数据"),
    BOOK_SAVE_ERROR(202,"图书添加失败"),
    BOOK_UPDATE_ERROR(202,"图书修改失败"),
    BOOK_DELETE_ERROR(202,"图书删除失败"),
    BOOK_MID_SAVE_ERROR(202,"中间表添加失败"),
    BOOK_MID_DELETE_ERROR(202,"中间表删除失败"),
    USER_NOT_FOUND_ERROR(202,"用户未找到"),
    USER_SAVE_ERROR(202,"用户保存失败"),
    USER_UPDATE_ERROR(202,"用户修改失败"),
    USER_DELETE_ERROR(202,"用户删除失败"),
    PATH_ERROR(202,"参数有误"),
    TOKEN_ERROR(500,"token生成失败"),
    CART_NOT_FOUND(400,"购物车为空"),
    ADDRESS_NOT_FOUND(400,"地址栏为空"),
    ADDRESS_SAVE_FOUND(400,"地址保存失败"),
    ADDRESS_DELETE_FOUND(400,"地址删除失败"),
    ADDRESS_UPDATE_FOUND(400,"地址修改失败"),
    ORDER_CREATE_ERROR(400,"订单创建失败"),
    ORDER_FOUND_ERROR(400,"未查询到订单"),
    STOCK_ERROR(400,"库存不足"),
    STOCK_UPDATE_ERROR(400,"库存修改失败"),
    ORDER_UPDATE_STATUS_ERROR(400,"订单状态修改失败"),
    URL_CREATE_ERROR(400,"支付连接生成失败"),
    URL_FOUND_STATUS_ERROR(400,"支付状态查询失败"),
    URL_ERROR(400,"媒体文件上传失败"),
            ;
    private int code;
    private String msg;
}
