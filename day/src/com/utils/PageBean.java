package com.utils;

import com.entity.Student;

import java.util.List;

public class PageBean {
    private int currentPage;
    private int totalPage;
    private int totalCount;
    private int pageSize;
    private List<Student> list;

    public PageBean(int currentPage, int totalPage, int totalCount, int pageSize, List<Student> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.list = list;
    }

    public PageBean() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
