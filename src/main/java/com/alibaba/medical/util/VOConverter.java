package com.alibaba.medical.util;

import com.alibaba.medical.enums.PackingUnitEnum;
import com.alibaba.medical.enums.RecipeTypeEnum;
import com.alibaba.medical.enums.TargetDeptEnum;
import com.alibaba.medical.pojo.Drug;
import com.alibaba.medical.vo.DrugVO;
import org.springframework.beans.BeanUtils;

/**
 * @author luguy
 * @date 2019/7/15 - 12:24
 * @Description:
 * @Version:
 */
public class VOConverter {

    public static void drugToVO(Drug drug, DrugVO drugVO){
        BeanUtils.copyProperties(drug,drugVO);
        drugVO.setRecipeType(EnumUtil.getByCode(drug.getRecipeType(), RecipeTypeEnum.class).getMessage());
        drugVO.setPackingUnit(EnumUtil.getByCode(drug.getPackingUnit(), PackingUnitEnum.class).getMessage());
        drugVO.setTargetDept(EnumUtil.getByCode(drug.getTargetDept(), TargetDeptEnum.class).getMessage());
        if(drug.getDrugStock()<=30){
            drugVO.setStockWarning("库存不足");
        }
        if(DataUtil.daysBetween(drug.getDrugValidity())<=30){
            drugVO.setStockWarning("即将过期");
        }
    }

}
