package com.yomance.web.bean.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yomance
 * @version 1.0
 * @date 2022-12-03 20:22:41
 */
public class PageData<T> implements Serializable {
    /**
     * 数据
     */
    private List<T> data;
    /**
     * 数据总数
     */
    private int total;
    /**
     * 当前页码
     */
    private int current;
    /**
     * 一页的数据数量
     */
    private int size;
    /**
     * 总页数
     */
    private int totalPage = 0;

    public PageData() {
    }

    public static <T> PageData<T> of(PageQuery<?> query) {
        return new PageData<T>()
                .setCurrent(query.getCurrent())
                .setSize(query.getSize());
    }

    public static <T> PageData<T> of(PageQuery<?> query, int total) {
        return new PageData<T>()
                .setCurrent(query.getCurrent())
                .setSize(query.getSize())
                .setTotal(total);
    }

    public static <T> PageData<T> of(PageQuery<?> query, int total, List<T> data) {
        return new PageData<T>()
                .setCurrent(query.getCurrent())
                .setSize(query.getSize())
                .setTotal(total)
                .setData(data);
    }

    public Boolean finished() {
        return data.size() < size;
    }

    public int getTotalPage() {
        if (totalPage == 0) {
            this.totalPage = (int) Math.ceil(total / (size * 1.0));
        }
        return totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public PageData<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public PageData<T> setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getCurrent() {
        return current;
    }

    public PageData<T> setCurrent(int current) {
        this.current = current;
        return this;
    }

    public int getSize() {
        return size;
    }

    public PageData<T> setSize(int size) {
        this.size = size;
        return this;
    }
}
