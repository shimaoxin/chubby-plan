package com.shimaoxin.chubbyplan.controller;

import com.shimaoxin.chubbyplan.model.Result;
import com.shimaoxin.chubbyplan.model.matrial.MaterialCategoryAddOrUpdateRequest;
import com.shimaoxin.chubbyplan.service.IFileManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 19:13
 * @description：
 */
@RestController
@RequestMapping("/file")
@Api(tags = "文件管理")
public class FileManagerController {

    @Autowired
    private IFileManagerService fileManagerService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    public Result upload(@RequestParam("file") MultipartFile file) {
        return Result.success(fileManagerService.upload(file));
    }
}
