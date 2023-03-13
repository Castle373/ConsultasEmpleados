/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import Entity.EmpleadoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author diego
 */
public class PruebaConsultas {
    
    public void nombreIdEmpleado(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        entity.getTransaction().begin();
        
          String queryBuscar ="Select v.id,v.nombre From EmpleadoEntidad v";
          TypedQuery<Object[]> query = entity.createQuery(queryBuscar, Object[].class);
          List<Object[]> lista = query.getResultList();
           for (Object[] fila : lista) {
            System.out.println("ID: " + fila[0] + ", Nombre: " + fila[1]);
            }
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
        
          String queryBuscar ="Select v.nombre From EmpleadoEntidad v";
          TypedQuery<String> query = entity.createQuery(queryBuscar, String.class);
          List<String> lista = query.getResultList();
           for (String fila : lista) {
            System.out.println("Nombre: " +fila);
            }
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
        
          String queryBuscar ="Select v From EmpleadoEntidad v ORDER BY v.nombre";
          TypedQuery<EmpleadoEntidad> query = entity.createQuery(queryBuscar, EmpleadoEntidad.class);
          List<EmpleadoEntidad> lista = query.getResultList();
           for (EmpleadoEntidad fila : lista) {
            System.out.println("Empleado: " +fila);
            }
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
        
          String queryBuscar ="SELECT v FROM EmpleadoEntidad v WHERE v.nombre LIKE '%a%' ORDER BY v.nombre";
          TypedQuery<EmpleadoEntidad> query = entity.createQuery(queryBuscar, EmpleadoEntidad.class);
          List<EmpleadoEntidad> lista = query.getResultList();
           for (EmpleadoEntidad fila : lista) {
            System.out.println("Empleado: "+fila);
            }
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
        
          String queryBuscar ="SELECT A FROM EmpleadoEntidad AS A INNER JOIN EstatusEntidad AS B ON A.estatus.id = B.id WHERE B.nombre = 'activo'";
          TypedQuery<EmpleadoEntidad> query = entity.createQuery(queryBuscar, EmpleadoEntidad.class);
          List<EmpleadoEntidad> lista = query.getResultList();
           for (EmpleadoEntidad fila : lista) {
            System.out.println("Empleado: " + fila);
            }
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
        
          String queryBuscar ="SELECT A.nombre,B.nombre FROM EmpleadoEntidad AS A INNER JOIN EstatusEntidad AS B ON A.estatus.id = B.id ";
          TypedQuery<Object[]> query = entity.createQuery(queryBuscar, Object[].class);
          List<Object[]> lista = query.getResultList();
           for (Object[] fila : lista) {
             System.out.println("Nombre: " + fila[0] + ", Estatus: " + fila[1]);
            }
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
        
          String queryBuscar ="SELECT A.nombre,B.nombre FROM EmpleadoEntidad AS A INNER JOIN EstatusEntidad AS B ON A.estatus.id = B.id WHERE A.nombre LIKE '%a%' ";
          TypedQuery<Object[]> query = entity.createQuery(queryBuscar, Object[].class);
          List<Object[]> lista = query.getResultList();
           for (Object[] fila : lista) {
             System.out.println("Nombre: " + fila[0] + ", Estatus: " + fila[1]);
            }
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
     
}
