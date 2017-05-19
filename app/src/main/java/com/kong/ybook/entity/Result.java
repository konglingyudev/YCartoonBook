package com.kong.ybook.entity;

import java.util.List;

/**
 * Created by konglingyu on 2017/2/22.
 */

public class Result {
    private int total;

    private int limit;

    private List<Book> bookList ;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
