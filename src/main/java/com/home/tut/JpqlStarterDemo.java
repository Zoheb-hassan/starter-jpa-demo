package com.home.tut;

import com.home.tut.dao.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpqlStarterDemo {

    public static void main(String[] args) {
        namedQuerySample(5);
    }

    /**
     * Use :param convention & set the parameter values, this offers type checking
     * & executes the query with expected parameters , avoids sql injection
     */
    public static void useQueryParameters(int id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "select e from Employee e where e.id = :employeeId";
        TypedQuery<Employee> query = entityManager.createQuery(queryString, Employee.class);
        query.setParameter("employeeId", id);
        Employee singleResult = query.getSingleResult();
        System.out.println(singleResult);
        entityManager.close();
        entityManagerFactory.close();

    }

    /**
     * Custom Query , Fetch by object location from array
     */
    public static void customJoinExample() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "select e.id, e.name, e.employeeType, e.accessCard.organization from Employee e order by e.id DESC";
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(queryString, Object[].class);
        List<Object[]> resultList = typedQuery.getResultList();
        resultList.forEach( e -> System.out.println(e[0]+" ---- "+e[1]+" ---- "+e[2]+" ---- "+e[3]));
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void typedQuerySample() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "select e from Employee e order by e.id DESC";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(queryString, Employee.class);
        List<Employee> resultList = typedQuery.getResultList();
        resultList.forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }


    /**
     * Use Named Query Sample
     */
    public static void namedQuerySample(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> fetch_by_employee_id = entityManager.createNamedQuery("fetch_by_employee_id", Employee.class);
        TypedQuery<Employee> typedQuery = fetch_by_employee_id.setParameter("employeeId", id);
        Employee employee = typedQuery.getSingleResult();
        System.out.println(employee);
        entityManager.close();
        entityManagerFactory.close();

    }
}
