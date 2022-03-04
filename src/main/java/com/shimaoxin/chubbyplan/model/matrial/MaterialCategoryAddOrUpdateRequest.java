package com.shimaoxin.chubbyplan.model.matrial;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 17:42
 * @description：
 */
@Data
public class MaterialCategoryAddOrUpdateRequest {

    @ApiModelProperty(value = "分类id, 编辑时必填")
    private Long categoryId;

    @NotNull(message = "分类名称 不能为空")
    @ApiModelProperty(value = "分类名称", required = true)
    private String categoryName;

    @ApiModelProperty(value = "父类id, 顶级节点不传")
    private Long parentId;
}
