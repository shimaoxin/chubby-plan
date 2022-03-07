package com.shimaoxin.chubbyplan.service;

import com.shimaoxin.chubbyplan.model.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 19:15
 * @description：
 */
public interface IFileManagerService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
