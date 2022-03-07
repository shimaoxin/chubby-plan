package com.shimaoxin.chubbyplan.service.impl;

import com.shimaoxin.chubbyplan.exception.BusinessException;
import com.shimaoxin.chubbyplan.model.Result;
import com.shimaoxin.chubbyplan.service.IFileManagerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 19:15
 * @description：
 */
@Service
public class FileManagerService implements IFileManagerService {

    @Value("${file.resource.innerPath}")
    private String innerPath;

    @Value("${file.resource.outerPath}")
    private String outerPath;

    @Override
    public String upload(MultipartFile file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String month = sdf.format(new Date());
        String dirPath = innerPath + "/" + month;
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String filePath = dirPath  +"/" + uuid + "-" + file.getOriginalFilename();
        File dir = new File(dirPath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        File targetFile = new File(filePath);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            throw new BusinessException("上传失败");
        }
        String returnPath = outerPath + "/" + month + "/" + uuid + "-" + file.getOriginalFilename();
        return returnPath;
    }
}
