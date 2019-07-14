package com.alibaba.medical.pageUtil;

import com.github.pagehelper.PageInfo;


/**
 * @author luguy
 * @date 2019/7/14 - 18:34
 * @Description:
 * @Version:
 */
public class PageUtils {


    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }

}
