package com.sl.jpa.JpaContoller;

import com.sl.jpa.po.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by braveup on 2017/3/28.
 */
public class JapTest {
    public static void main(String args[]) {
//        createTable();
//        save();
//        update();
//        updateOrCreate();
//        remove();
        find();
        findBySecond();

    }

    //create
    public static void createTable() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
        factory.close();
    }

    //save
    public static void save() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Person person = new Person();//person为new状态
        person.setBirtthday("2017-03-28");
        person.setName("宋磊");
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    //update
    public static void update() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();
        Person person=entityManager.find(Person.class,1);
        person.setName("宋磊update");
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
    //update or create
    public static void updateOrCreate(){
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("mysqlJPA");
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();
        Person person=entityManager.find(Person.class,1);
        //把实体管理器中的所有实体变为托管状态
        entityManager.clear();
        person.setName("insert");
        //把脱管状态变为托管状态,merge可以自动选择insert or update 数据
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
    //remove
    public  static  void remove(){
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("mysqlJPA");
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        Person person =manager.find(Person.class,1);
        manager.remove(person);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
    //find
    public static void  find(){
        EntityManagerFactory  factory=Persistence.createEntityManagerFactory("mysqlJPA");
        EntityManager  entityManager=factory.createEntityManager();
        Person  person=entityManager.find(Person.class,2);//类似于hibernate的find方法，没有数据返回的话就是null
        System.out.printf("person"+person);
        entityManager.close();
        factory.close();
    }

    //find other
    public static  void findBySecond(){
        EntityManagerFactory  factory=Persistence.createEntityManagerFactory("mysqlJPA");
        EntityManager  entityManager=factory.createEntityManager();
        Person  person=entityManager.getReference(Person.class,1);//类似于hibernate的load方法,延时加载，没有相应的数据就会报出异常
        System.out.println("person"+person.getName()+person.getBirtthday());
        entityManager.close();
        factory.close();

    }

}
