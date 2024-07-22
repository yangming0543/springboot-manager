package com.company.project.common.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.company.project.common.exception.BusinessException;

/**
 * 断言工具类
 */
public class AssertUtil {
    /**
     * 服务调用异常
     * @param expression
     * @param message
     */
    public static void isTrueServiceInvoke(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(message);
        }
    }

    /**
     * string 不能为空
     * @param s
     * @param message
     */
    public static void isStringBlankMsg(String s, String message) {
        if (StringUtils.isBlank(s)) {
            throw new BusinessException(message);
        }
    }

    /**
     * 必传参数不能为空
     *
     * @param params
     */
    public static void isStringBlankDefault(String... params) {
        for (String param : params) {
            if (StringUtils.isBlank(param)) {
                throw new BusinessException("必传参数不能为空");
            }
        }
    }


}