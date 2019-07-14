package com.alibaba.medical.util;


import com.alibaba.medical.enums.CodeEnum;

public class EnumUtil {

    /**
     * create by: luguy
     * description: TODO
     * create time: 2019/7/14 11:29
     * @params  * @Param: code
     * @Param: enumClass
     * @return T
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(

                    each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
