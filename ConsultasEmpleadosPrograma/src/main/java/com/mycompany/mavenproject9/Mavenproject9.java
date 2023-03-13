/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject9;

import Entity.RedSocialEntidad;
import Entity.RedSocialUsuarioEntidad;
import Entity.Sexo;
import Entity.UsuarioEntidad;
import Prueba.PrubaConsultasCriteri;
import Prueba.PruebaConsultas;
import Prueba.PruebaRedSocial;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diego
 */
public class Mavenproject9 {
    public static void main(String[] args) {
        PruebaRedSocial red = new PruebaRedSocial();
        PruebaConsultas consultas = new PruebaConsultas();
        PrubaConsultasCriteri consultasCri = new PrubaConsultasCriteri();
        
        System.out.println("----------1----------");
        consultas.nombreIdEmpleado();
        System.out.println("---------------------");
        System.out.println("----------1----------");
        consultasCri.nombreIdEmpleado();
        System.out.println("---------------------");
        
        
        System.out.println("----------2----------");
        consultas.nombreEmpleado();
        System.out.println("---------------------");
        System.out.println("----------2----------");
        consultasCri.nombreEmpleado();
        System.out.println("---------------------");
        
        System.out.println("----------3----------");
        consultas.Empleados();
        System.out.println("---------------------");
        System.out.println("----------3----------");
        consultasCri.Empleados();
        System.out.println("---------------------");
        
        System.out.println("----------4----------");
        consultas.LikeEmpleados();
        System.out.println("---------------------");
        System.out.println("----------4----------");
        consultasCri.LikeEmpleados();
        System.out.println("---------------------");
                
        System.out.println("----------4----------");
        consultas.InnerActivoEmpleados();
        System.out.println("---------------------");
        System.out.println("----------4----------");
        consultasCri.InnerActivoEmpleados();
        System.out.println("---------------------");
        
        System.out.println("----------5----------");
        consultas.InnerNombreEmpleados();
        System.out.println("---------------------");
        
        System.out.println("----------5----------");
        consultasCri.InnerNombreEmpleados();
        System.out.println("---------------------");
        
        System.out.println("----------5----------");
        consultas.InnerNombreAEmpleados();
        System.out.println("---------------------");
        System.out.println("----------5----------");
        consultasCri.InnerNombreAEmpleados();
        System.out.println("---------------------");
        
    }
}
