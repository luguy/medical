package com.alibaba.medical.service;

import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.pageUtil.PageRequest;

/**
 * @author luguy
 * @date 2019/7/13 - 21:23
 */
public interface IDrugService {

    ServerResponse list(String drugCategory, String recipeType, String drugName, PageRequest pageRequest);

}
