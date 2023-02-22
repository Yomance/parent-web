package com.yomance.web.bean;

/**
 * sql枚举字段对应实体类的父接口
 *
 * @author Yomance
 * @version 1.0
 * @date 2023-01-02 11:05:28
 */
public interface SqlStatus {
    /**
     * 值
     */
    int value();

    /**
     * 标签名称
     */
    String label();

    /**
     * 解释描述
     */
    String desc();
}