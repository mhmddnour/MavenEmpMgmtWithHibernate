package com.mnour.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class employee implements Serializable{

    public employee(){

    }
    private static final long serialVersionUID = 8633415090390966715L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "aga")
    private String aga ;

    @Column(name = "job")
    private String job;

    @Column(name = "salary")
    private double salary;


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

    public String getAga() {
        return aga;
    }

    public void setAga(String aga) {
        this.aga = aga;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee Details = {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + aga + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
