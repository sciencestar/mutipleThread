package com.mutiplethread.demo.bean;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description: TODO
 * @Author lxc
 * @Date 2020/5/14 22:56
 * @Version V1.0
 **/
public class Person implements Serializable {

    private String personName;
    private Integer personAge;

    public Person() {
    }

    public Person(String personName, Integer personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }
}