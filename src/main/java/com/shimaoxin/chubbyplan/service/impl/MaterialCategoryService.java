package com.shimaoxin.chubbyplan.service.impl;

import com.shimaoxin.chubbyplan.entity.MaterialCategory;
import com.shimaoxin.chubbyplan.dao.MaterialCategoryMapper;
import com.shimaoxin.chubbyplan.model.Result;
import com.shimaoxin.chubbyplan.model.matrial.MaterialCategoryAddOrUpdateRequest;
import com.shimaoxin.chubbyplan.service.IMaterialCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 食材类别 服务实现类
 * </p>
 *
 * @author 石茂新
 * @since 2022-03-04
 */
@Service
public class MaterialCategoryService extends ServiceImpl<MaterialCategoryMapper, MaterialCategory> implements IMaterialCategoryService {

    @Override
    public void addOrUpdate(MaterialCategoryAddOrUpdateRequest request) {
        if(ObjectUtils.isEmpty(request.getCategoryId())) {
            //增加
            MaterialCategory materialCategory = new MaterialCategory();
            BeanUtils.copyProperties(request, materialCategory);
            this.save(materialCategory);
        } else {
            //编辑
        }


    }
}
