package com.entity;


public class Student {

  private int id;
  private String name;
  private int age;
  private String sex;
  private String hobby;
  private String work;
  private String sdesc;

  public Student(int id, String name, int age, String sex, String hobby, String work, String sdesc) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.hobby = hobby;
    this.work = work;
    this.sdesc = sdesc;
  }

  public Student() {
  }

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


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }


  public String getWork() {
    return work;
  }

  public void setWork(String work) {
    this.work = work;
  }


  public String getSdesc() {
    return sdesc;
  }

  public void setSdesc(String sdesc) {
    this.sdesc = sdesc;
  }

}
