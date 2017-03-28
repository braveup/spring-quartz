package com.sl.jpa.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by braveup on 2017/3/28.
 */
@Entity
public class Person {
    private int pid;
    private String name;
    private String birtthday;

    @Id
    @GeneratedValue
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Column(length = 12)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 12)
    public String getBirtthday() {
        return birtthday;
    }

    public void setBirtthday(String birtthday) {
        this.birtthday = birtthday;
    }
}
