package com.zx.teacherSystemWeb.entity;

import com.zx.teacherSystemWeb.entity.base.Entity;
import com.zx.teacherSystemWeb.flection.Column;

import java.util.Date;

@SuppressWarnings("serial")
public class Teacher extends Entity {
    @Column(value = "id", type = "Integer")
    private Integer id;
    @Column(value = "teacher_name", type = "String")
    private String teacherName;
    @Column(value = "teacher_birthday", type = "Date")
    private Date teacherBirthday;
    @Column(value = "teacher_sex", type = "String")
    private String teacherSex;
    @Column(value = "teacher_salary", type = "Double")
    private Double teacherSalary;
    @Column(value = "teacher_email", type = "String")
    private String teacherEmail;
    @Column(value = "teacher_type", type = "String")
    private String teacherType;
    @Column(value = "teacher_level", type = "String")
    private String teacherLevel;
    @Column(value = "teacher_address", type = "String")
    private String teacherAddress;
    @Column(value = "remark", type = "String")
    private String remark;

    public Teacher() {
    }

    public Teacher(String teacherName, Date teacherBirthday, String teacherSex, Double teacherSalary, String teacherEmail, String teacherType, String teacherLevel, String teacherAddress, String remark) {
        this.teacherName = teacherName;
        this.teacherBirthday = teacherBirthday;
        this.teacherSex = teacherSex;
        this.teacherSalary = teacherSalary;
        this.teacherEmail = teacherEmail;
        this.teacherType = teacherType;
        this.teacherLevel = teacherLevel;
        this.teacherAddress = teacherAddress;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Double getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(Double teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public String getTeacherLevel() {
        return teacherLevel;
    }

    public void setTeacherLevel(String teacherLevel) {
        this.teacherLevel = teacherLevel;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getTableName() {
        return "teacher";
    }
}
