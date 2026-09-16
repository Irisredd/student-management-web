package com.sake.studentmanagementweb.controller;


import com.sake.studentmanagementweb.entity.Student;
import com.sake.studentmanagementweb.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")//这个类以下的所有方法都以/students开头
public class StudentController {
    private final StudentMapper mapper;
    public StudentController(StudentMapper mapper){//构造器注入
        this.mapper = mapper;
    }

    //======1.查询======
    @GetMapping
    public List<Student> list(){
        return mapper.selectList(null);   // null = 没有查询条件，查全部
    }

    //======2.添加======
    @PostMapping
    public String add(@RequestBody Student student){
        mapper.insert(student);
        return "添加成功，id="+student.getId();//insert后会自动回填id
    }

    //======3.修改======
    @PutMapping("/{id}")
    public String update(@PathVariable int id,@RequestBody Student student){
        student.setId(id);
        mapper.updateById(student);
        return "修改成功，id="+student.getId();
    }

    //======4.删除======
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        mapper.deleteById(id);
        return "删除成功";
    }


}
