package com.sake.studentmanagementweb.dao;

import com.sake.studentmanagementweb.entity.Student;
import com.sake.studentmanagementweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import  java.util.ArrayList;
import java.util.List;

public class StudentDao {

    //======1.添加学生======
    public void add(Student student){
        String sql="INSERT INTO student (name,age,major) values(?,?,?)";
        //try with resourses:括号里面创建的资源，用完自动关闭（链接、语句对象）\
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            //用？占位符传参数，防止sql注入，也是标准写法
            ps.setString(1, student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3, student.getMajor());

            int rows = ps.executeUpdate();//用于增删改，返回受影响行数
            System.out.println("添加成功,影响了"+ rows +"行");

        }catch (SQLException e){
            System.out.println("添加失败："+e.getMessage());
        }
    }

    //======2.查询全部学生======
    public List<Student> findAll(){
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id,name,age,major FROM student";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            //rs.next()：指针移动到下一行，有数据返回true
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setMajor(rs.getString("major"));
                list.add(s);
            }

        } catch (Exception e) {
            System.out.println("查询失败："+e.getMessage());
        }
        return list;
    }
    //======3.修改学生======
    public void update(Student student){
        String sql = "UPDATE student SET name=?,age=?,major=? WHERE id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3, student.getMajor());
            ps.setInt(4,student.getId());

            int rows = ps.executeUpdate();
            if (rows>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败，找不到id为"+student.getId()+"的学生");
            }
        } catch (Exception e) {
            System.out.println("修改失败："+e.getMessage());
        }
    }

    //======4.删除学生======
    public void delete(int id){
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,id);
            int rows = ps.executeUpdate();
            if (rows>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败，找不到id为"+id+"的学生");
            }

        } catch (Exception e) {
            System.out.println("删除失败："+e.getMessage());
        }

    }

}
