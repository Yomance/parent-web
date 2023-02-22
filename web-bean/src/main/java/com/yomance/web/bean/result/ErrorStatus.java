package com.yomance.web.bean.result;

/**
 * 描述错误的通用父接口状态
 *
 * @author Yomance
 * @version 1.0
 * @date 2023-01-02 11:05:28
 */
public interface ErrorStatus {

    int getCode();

    /**
     * @return 用于描述错误的信息
     */
    String getMessage();
}
