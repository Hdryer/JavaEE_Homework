package com.yang.service;

import com.yang.dao.CourseMapper;
import com.yang.pojo.Course;
import com.yang.utils.FilePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public boolean saveimage(Course course, MultipartFile file) throws IOException {
        if(file!=null){
            System.out.println(file);
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            System.out.println("service:"+originalFilename);
            //文件为空表示未设置图片
            if(originalFilename.isEmpty()){
                //默认图片
                course.setUrl("b1f2f46d-6be9-4d20-97e8-99cc5b1fce6e.png");
                System.out.println("service：默认图片");
                return courseMapper.addcourse_image(course)>0;
            }
            //获取图片后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
            //生成图片存储的名称，uuid避免相同图片名字冲突，并加上图片后缀
            String fileName = UUID.randomUUID().toString() + suffix;
            //图片存储路径
            String filePath = FilePathUtil.Img_Path + fileName;
            File saveFile = new File(filePath);
            //将上传的文件保存到服务器文件系统
            file.transferTo(saveFile);
            //记录下文件名称
            course.setUrl(fileName);
        }
        //持久化course对象
        return courseMapper.addcourse_image(course)>0;
    }
}
