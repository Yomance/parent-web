package com.yomance.web.bean.page;

import java.io.Serializable;


/**
 * @param <Where> 查询条件，在需要条件进行查询时指定
 * @author Yomance
 * @version 1.0
 * @date 2023-01-02 12:05:36
 */
public class PageQuery<Where> implements Serializable {

    // 默认一页最大数量
    public static int MAX_SIZE = 100;
    // 默认一页数量
    public static int DEFAULT_SIZE = 10;

    /**
     * 当前页码 默认第一页
     */
    private int current = 1;
    /**
     * 数据量
     */
    private int size = DEFAULT_SIZE;
    /**
     * 查询条件
     */
    private Where where;

    public PageQuery() {
    }

    public static <W extends Serializable> PageQuery<W> of(int current, int size, W where) {
        return new PageQuery<W>().setCurrent(current).setSize(size).setWhere(where);
    }

    public static <W extends Serializable> PageQuery<W> of(int current, int size) {
        return new PageQuery<W>().setCurrent(current).setSize(size);
    }

    public static <W extends Serializable> PageQuery<W> of(int current) {
        return new PageQuery<W>().setCurrent(current);
    }

    public Where getWhere() {
        return where;
    }

    public PageQuery<Where> setWhere(Where where) {
        this.where = where;
        return this;
    }

    @Override
    public String toString() {
        return "current: "
                + current
                + ",size: "
                + size + ";";
    }

    public int getCurrent() {
        return current;
    }

    public PageQuery<Where> setCurrent(int current) {
        if (current < 1) current = 1;
        this.current = current;
        return this;
    }

    public int getSize() {
        return size;
    }

    public PageQuery<Where> setSize(int size) {
        if (size < 0) size = 0;
        if (size > MAX_SIZE) size = MAX_SIZE;
        this.size = size;
        return this;
    }
}
