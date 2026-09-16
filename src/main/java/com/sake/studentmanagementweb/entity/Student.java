package com.sake.studentmanagementweb.entity;

public class Student {
    private int id;
    private String name;
    private int age;
    private  String major;

    //无参构造函数
    public Student(){}
    //有参构造函数
    public Student(String name, int age, String major){
        this.name=name;
        this.age=age;
        this.major=major;
    }
    //getter和setter    右键自动生成的
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    //打印对象时显示的内容，便于查看
    //@override是注解，提示下面的方法覆盖了父类或者接口中的方法
    @Override
    public String toString(){
        return "学生"+id+"  {姓名："+name+"  年龄："+age+"  专业："+major+"}";
    }
}
