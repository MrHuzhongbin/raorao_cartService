package com.itmd.vo;

import com.itmd.enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int state;
    private String msg;
    private Long timestamp;
    private int status = 1; //执行成功只是没有获取都结果

    public ExceptionResult(ExceptionEnum en) {
        this.state = en.getCode();
        this.msg = en.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
