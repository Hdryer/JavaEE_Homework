package com.yang.dao;

import com.yang.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    public List<Course> queryall();
    public Course queryid(int id);
    public List<Course> querybysid(int sid);
    public void addhours(int id);
    //全部数据持久化
    public int addcourse_image(Course course);
    //未选取封面的持久化
    public int addcourse(Course course);
    public void deletecourse(int id);
    public void updatecourse(Course course);
}
