package com.mnour.dao;



import com.mnour.model.employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Scanner;

public class EmpDAO {

    static Scanner s = new Scanner(System.in);
    static Scanner s1 = new Scanner(System.in); // to read string data

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    static Transaction tx;
    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta  = new MetadataSources(ssr).getMetadataBuilder().build();
        sessionFactoryObj = meta.getSessionFactoryBuilder().build();
        return sessionFactoryObj;
    }

    public static void addEmp(){
        System.out.println("Enter Emp Id : ");
        int empId = s.nextInt();

        System.out.println("Enter Emp Name : ");
        String empName = s1.nextLine();

        System.out.println("Enter Emp Age : ");
        String empAge = s1.nextLine();

        System.out.println("Enter Emp Job : ");
        String empJob = s1.nextLine();

        System.out.println("Enter Emp Salary : ");
        double empSalary = s.nextDouble();

        try{
            sessionObj = buildSessionFactory().openSession();
            tx = sessionObj.beginTransaction();
            employee empObj = new employee();
            empObj.setId(empId);
            empObj.setName(empName);
            empObj.setAga(empAge);
            empObj.setJob(empJob);
            empObj.setSalary(empSalary);
            sessionObj.save(empObj);
            tx.commit();
            System.out.println("******Added successfully*******");
        } catch (HibernateException e){
            if(tx != null){
                System.out.println("Transaction Rolled Back");
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void getEmp(){

        try{
            sessionObj = buildSessionFactory().openSession();
            tx = sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from employee",employee.class);
            List <employee> list = query.list();
            for (employee emp : list){
                System.out.println("Id = " + emp.getId() +
                        " name = " + emp.getName() + " age = " + emp.getAga() +
                        " jpb = " + emp.getAga() + " salary = " + emp.getSalary()) ;
            }

        }catch (HibernateException e){
            if(tx != null){
                System.out.println("Transaction Rolled Back");
                tx.rollback();
            }
            e.printStackTrace();
        }

    }

    public static void updateEmp(int empId){

        System.out.println("Enter New Employee Name : ");
        String empName = s1.nextLine();

        System.out.println("Enter New Employee Age : ");
        String empAge = s1.nextLine();

        System.out.println("Enter New Employee Job : ");
        String empJob = s1.nextLine();

        System.out.println("Enter New Employee Salary : ");
        double empSalary = s.nextDouble();

        try{
            sessionObj = buildSessionFactory().openSession();
            tx = sessionObj.beginTransaction();
            employee emp = sessionObj.get(employee.class, empId);
            emp.setName(empName);
            emp.setAga(empAge);
            emp.setJob(empJob);
            emp.setSalary(empSalary);
            sessionObj.update(emp);
            tx.commit();
            System.out.println("******Updated successfully*******");
        }catch (HibernateException e){
            if(tx != null){
                System.out.println("Transaction Rolled Back");
                tx.rollback();
            }
            e.printStackTrace();
        }

    }

    public static void deleteEmp(int empId){


        try{
            sessionObj = buildSessionFactory().openSession();
            tx = sessionObj.beginTransaction();
            employee emp = sessionObj.get(employee.class, empId);
            sessionObj.delete(emp);
            tx.commit();
            System.out.println("******Deleted successfully*******");
        }catch (HibernateException e) {
            if(tx != null){
                System.out.println("Transaction Rolled Back");
                tx.rollback();
            }
            e.printStackTrace();
        }

    }

}
