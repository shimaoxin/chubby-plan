package com.shimaoxin.chubbyplan.service;

import com.shimaoxin.chubbyplan.entity.MaterialCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shimaoxin.chubbyplan.model.Result;
import com.shimaoxin.chubbyplan.model.matrial.MaterialCategoryAddOrUpdateRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * <p>
 * 食材类别 服务类
 * </p>
 *
 * @author 石茂新
 * @since 2022-03-04
 */
public interface IMaterialCategoryService extends IService<MaterialCategory> {


    /**
     * 添加/编辑
     * @param request
     * @return
     */
    public void addOrUpdate(MaterialCategoryAddOrUpdateRequest request);
}
