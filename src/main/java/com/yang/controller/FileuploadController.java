package com.yang.controller;

import com.yang.utils.FilePathUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileuploadController {

    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, @RequestParam("myfile") MultipartFile upload) throws IOException {
        //设置上传位置
        String path = FilePathUtil.Img_Path;
        //获取文件名称
        String filename = upload.getOriginalFilename();
        //保证上传后的文件的id唯一
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid +"_"+filename;
        String filePath = path+filename;
        System.out.println(filePath);
        File file = new File(filePath);
        System.out.println(file);
        upload.transferTo(new File(path,filename));
        return "success";
    }
}
