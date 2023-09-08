package com.sports.community.entity;
// encapsulate multiple-pages information
public class Page {
    private int current = 1;
    private int limit = 10;
    //calculate total pages
    private int rows;
    // 查询路径（用于复用分页链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOffset() {
        return (current - 1) * limit;
    }

    // get total pages
    public int getTotal() {
        if (rows % limit == 0) {
            return rows/limit;
        }
        return rows/limit + 1;
    }
    // get starting page number
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }
    // get ending page number
    public int getTo() {
        int end = current + 2;
        int total = getTotal();
        return end > total ? total : end;
    }
}
