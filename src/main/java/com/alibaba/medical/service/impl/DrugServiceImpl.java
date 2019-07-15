package com.alibaba.medical.service.impl;

import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.dao.DrugMapper;
import com.alibaba.medical.pageUtil.PageRequest;
import com.alibaba.medical.pageUtil.PageResult;
import com.alibaba.medical.pageUtil.PageUtils;
import com.alibaba.medical.pojo.Drug;
import com.alibaba.medical.service.IDrugService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author luguy
 * @date 2019/7/13 - 21:23
 */
@Service
public class DrugServiceImpl implements IDrugService {

    @Autowired
    DrugMapper drugMapper;


    /**
     * create by: luguy
     * description: 查询药品
     * create time: 2019/7/15 12:01
     * @params  * @Param: drugCategory
     * @Param: recipeType
     * @Param: drugName
     * @Param: pageRequest
     * @return com.alibaba.medical.common.ServerResponse
     */
    @Override
    public ServerResponse list(String drugCategory, String recipeType,String drugName,PageRequest pageRequest) {
        StringBuffer subSql=new StringBuffer("where ");
        int counter=0;
        if(!"全部".equals(drugCategory)){
            subSql.append("drug_category="+drugCategory);
            counter++;
        }
        if(!"全部".equals(recipeType)){
            if(counter>0){
                subSql.append(" and ");
            }
            subSql.append("recipe_type="+recipeType);
            counter++;
        }
        if(StringUtils.isNotBlank(drugName)){
            if(counter>0){
                subSql.append(" and ");
            }
            subSql.append("drug_name like '%"+drugName+"%'");
            counter++;
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if(counter==0){
            hashMap.put("subSql","");
        }else {
            hashMap.put("subSql", subSql.toString());
        }
        PageResult pageResult=selectListPage(hashMap,pageRequest);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * create by: luguy
     * description: 根据分页请求获取药品列表数据
     * create time: 2019/7/15 12:00
     * @params  * @Param: hashMap
     * @Param: pageRequest
     * @return com.alibaba.medical.pageUtil.PageResult
     */
    private PageResult selectListPage(HashMap<Object, Object> hashMap,PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());//分页插件拦截mybitis的查询请求
        List<Drug> list=drugMapper.selectList(hashMap);
        PageResult pageResult= PageUtils.getPageResult(new PageInfo<>(list));
        return pageResult;
    }



}
