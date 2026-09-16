package com.sake.studentmanagementweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sake.studentmanagementweb.entity.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper extends BaseMapper<Student>{
    //增删改查已经全部继承好了，什么也不用写
}

