package com.alibaba.medical.controller;

import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.pageUtil.PageRequest;
import com.alibaba.medical.pageUtil.PageResult;
import com.alibaba.medical.pojo.Drug;
import com.alibaba.medical.service.IDrugService;
import com.alibaba.medical.util.DataUtil;
import com.alibaba.medical.vo.DrugVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luguy
 * @date 2019/7/13 - 21:12
 */
@RestController
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    IDrugService iDrugService;



    /**
     * create by: luguy
     * description: 药品查询
     * create time: 2019/7/14 11:31
     * @params  * @Param: drugCategory
     * @Param: recipeType
     * @return com.alibaba.medical.common.ServerResponse
     */
    @GetMapping("/list")
    public ServerResponse list(@RequestParam(value = "Category", defaultValue = "全部") String drugCategory,
                               @RequestParam(value = "recipe", defaultValue = "全部") String recipeType,
                               @RequestParam(value = "recipe", defaultValue = "") String drugName,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageRequest pageRequest=new PageRequest(page,size);
        ServerResponse response=iDrugService.list(drugCategory,recipeType,drugName,pageRequest);
        if(response.isSuccess()){
            PageResult pageResult=(PageResult) response.getData();
            List<Drug> list=(List<Drug>) pageResult.getContent();
            List<DrugVO> listVO=new ArrayList<>();
            for (Drug drug : list) {
                DrugVO drugVO=new DrugVO();
                BeanUtils.copyProperties(drug,drugVO);
                if(drug.getDrugStock()<=30){
                    drugVO.setStockWarning("库存不足");
                }
                if(DataUtil.daysBetween(drug.getDrugValidity())<=30){
                    drugVO.setStockWarning("即将过期");
                }
                listVO.add(drugVO);
            }
            pageResult.setContent(listVO);
            return ServerResponse.createBySuccess(pageResult);
        }
        return response;
    }


}
