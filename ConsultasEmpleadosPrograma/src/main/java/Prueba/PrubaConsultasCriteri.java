/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import Entity.EmpleadoEntidad;
import Entity.EstatusEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author diego
 */
public class PrubaConsultasCriteri {
    public void nombreIdEmpleado(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
        //EJERCICIO: Obtener 1 solo dato de la entidad empleado
        //1.- El CriteriaBuilder que basados en el se creara el query
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);

        Root<EmpleadoEntidad> raizEmpleado = criteriaQuery.from(EmpleadoEntidad.class);
        
        criteriaQuery.multiselect(raizEmpleado.get("id"),raizEmpleado.get("nombre"));  
        List<Tuple> lstNombresEmpleados = entity.createQuery(criteriaQuery).getResultList();      
        lstNombresEmpleados.forEach(item -> {
         System.out.println("ID: " + item.get(0).toString() + ", Nombre: " + item.get(1).toString());
        });

        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
    public void nombreEmpleado(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<EmpleadoEntidad> raizEmpleado = criteriaQuery.from(EmpleadoEntidad.class);
        criteriaQuery.select(raizEmpleado.get("nombre"));
        List<String> lstNombresEmpleados = entity.createQuery(criteriaQuery).getResultList();      
        lstNombresEmpleados.forEach(item -> {
         System.out.println("Nombre: " + item.toString());
        });
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
    public void Empleados(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<EmpleadoEntidad> criteriaQuery = criteriaBuilder.createQuery(EmpleadoEntidad.class);
        Root<EmpleadoEntidad> raizEmpleado = criteriaQuery.from(EmpleadoEntidad.class);
        
        criteriaQuery.orderBy(criteriaBuilder.asc(raizEmpleado.get("nombre")));
        
        List<EmpleadoEntidad> lstNombresEmpleados = entity.createQuery(criteriaQuery).getResultList();  
        lstNombresEmpleados.forEach(item -> {
         System.out.println("Empleado: " + item.toString());
        });
        
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
    public void LikeEmpleados(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<EmpleadoEntidad> criteriaQuery = criteriaBuilder.createQuery(EmpleadoEntidad.class);
        Root<EmpleadoEntidad> raizEmpleado = criteriaQuery.from(EmpleadoEntidad.class);
        
        
        criteriaQuery.where(criteriaBuilder.like(raizEmpleado.get("nombre"), "%a%"));
        criteriaQuery.orderBy(criteriaBuilder.asc(raizEmpleado.get("nombre")));
        
        List<EmpleadoEntidad> lstNombresEmpleados = entity.createQuery(criteriaQuery).getResultList();  
        lstNombresEmpleados.forEach(item -> {
         System.out.println("Empleado: " + item.toString());
        });
        
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
    public void InnerActivoEmpleados(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<EmpleadoEntidad> criteriaQuery = criteriaBuilder.createQuery(EmpleadoEntidad.class);
        Root<EmpleadoEntidad> raizEmpleado = criteriaQuery.from(EmpleadoEntidad.class);

        Join<EmpleadoEntidad, EstatusEntidad> estatusJoin = raizEmpleado.join("estatus");
        criteriaQuery.select(raizEmpleado).where(criteriaBuilder.equal(estatusJoin.get("nombre"), "activo"));
        
        List<EmpleadoEntidad> lstNombresEmpleados = entity.createQuery(criteriaQuery).getResultList();  
        lstNombresEmpleados.forEach(item -> {
         System.out.println("Empleado: " + item.toString());
        }); 
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
     public void InnerNombreEmpleados(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
         CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<EmpleadoEntidad> raizEmpleado = criteriaQuery.from(EmpleadoEntidad.class);

        Join<EmpleadoEntidad, EstatusEntidad> estatusJoin = raizEmpleado.join("estatus");
        criteriaQuery.multiselect(raizEmpleado.get("nombre"),estatusJoin.get(("nombre")));
        
        
        List<Tuple> lstNombresEmpleados = entity.createQuery(criteriaQuery).getResultList();  
        lstNombresEmpleados.forEach(item -> {
         System.out.println("Nombre: " + item.get(0)+", Estatus: " + item.get(1));
        }); 
          
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
     public void InnerNombreAEmpleados(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<EmpleadoEntidad> raizEmpleado = criteriaQuery.from(EmpleadoEntidad.class);

        Join<EmpleadoEntidad, EstatusEntidad> estatusJoin = raizEmpleado.join("estatus");
        criteriaQuery.multiselect(raizEmpleado.get("nombre"),estatusJoin.get(("nombre")));
        criteriaQuery.where(criteriaBuilder.like(raizEmpleado.get("nombre"), "%a%"));
        
        List<Tuple> lstNombresEmpleados = entity.createQuery(criteriaQuery).getResultList();  
        lstNombresEmpleados.forEach(item -> {
         System.out.println("Nombre: " + item.get(0)+", Estatus: " + item.get(1));
        }); 
          
         
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
}
