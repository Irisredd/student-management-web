package com.sake.studentmanagementweb;

import com.sake.studentmanagementweb.dao.StudentDao;
import com.sake.studentmanagementweb.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")//这个类以下的所有方法都以/students开头
public class StudentController {
    private final StudentDao dao = new StudentDao();

    //1.查询全部：GET http://localhost:8080/students
    @GetMapping
    public List<Student> list(){
        return dao.findAll();
    }

    //2.添加学生：POST http://localhost:8080/students
    @PostMapping
    public String add(@RequestBody Student student){
        //@RequestBody：把请求体里的JSON自动转成Student对象
        dao.add(student);
        return "添加成功";
    }

    //3.修改：PUT http://localhost:8080/students/1
    @PutMapping("/{id}")
    public String update(@PathVariable int id,@RequestBody Student student){
        //@PathVariable：把URL里的1取出来赋值给id
        student.setId(id);
        dao.update(student);
        return "修改成功";
    }

    //4.删除：DELETE http://localhost:8080/students/2
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "删除成功";
    }


}
