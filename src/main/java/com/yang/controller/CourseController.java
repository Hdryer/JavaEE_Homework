package com.yang.controller;

import com.yang.dao.CourseMapper;
import com.yang.pojo.Course;
import com.yang.service.CourseService;
import com.yang.utils.FilePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/hello")
    @ResponseBody
    public String test1(){
        return "hello,mybatis";
    }

    @RequestMapping("/page1")
    public String test2(){
        return "page1";
    }

    @RequestMapping("/allcourse")
    public String allcourse(Model model){
        List<Course> courses = courseMapper.queryall();
        model.addAttribute("courses",courses);
        return "allcourse";
    }

    @RequestMapping("/deletecourse")
    public String deletecourse(int id){
        courseMapper.deletecourse(id);
        return "redirect:/allcourse";
    }

    @RequestMapping("/toupdate")
    public String toupdate(int id,Model model){
        Course course = courseMapper.queryid(id);
        model.addAttribute("onecourse",course);
        return "updatepage";
    }

    @RequestMapping("/updatecourse")
    public String updatecourse(Course course){
        System.out.println(course);
        courseMapper.updatecourse(course);
        return "redirect:/allcourse";
    }
    @RequestMapping("/toadd")
    public String toadd(){
        return "addpage";
    }
    @RequestMapping("/addcourse")
    public String addcourse(Course course, @RequestParam("myFile") MultipartFile file) throws IOException {
        if(courseService.saveimage(course,file)){
            return "redirect:/allcourse";
        }
        return "page1";
    }

    //处理显示图片的
    @RequestMapping("/showPic/{fileName}.{suffix}")
    public  void showPic(@PathVariable("fileName") String fileName,@PathVariable("suffix") String suffix, HttpServletResponse response){
        File imgFile = new File(FilePathUtil.Img_Path + fileName + "." + suffix);
        responseFile(response,imgFile);
    }

    /*
    响应输出图片文件
    @param response
    @param imgFile
    */
    private void responseFile(HttpServletResponse response,File imgFile){
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024]; // 图片文件流缓存池
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
