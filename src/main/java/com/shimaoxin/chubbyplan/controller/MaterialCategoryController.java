package com.shimaoxin.chubbyplan.controller;


import com.shimaoxin.chubbyplan.model.Result;
import com.shimaoxin.chubbyplan.model.matrial.MaterialCategoryAddOrUpdateRequest;
import com.shimaoxin.chubbyplan.service.IMaterialCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 食材类别 前端控制器
 * </p>
 *
 * @author 石茂新
 * @since 2022-03-04
 */
@RestController
@RequestMapping("/material/category")
@Api(tags = "食材类别")
public class MaterialCategoryController {

    @Autowired
    private IMaterialCategoryService materialCategoryService;

    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "添加/编辑")
    public Result addOrUpdate(@RequestBody @Valid MaterialCategoryAddOrUpdateRequest request) {
        materialCategoryService.addOrUpdate(request);
        return Result.success();
    }

}
