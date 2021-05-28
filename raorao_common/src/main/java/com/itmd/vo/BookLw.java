package com.itmd.vo;

import com.itmd.pojo.Book;


public class BookLw extends Book {

    private String classificationName;
    private String pressName;

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }
}
