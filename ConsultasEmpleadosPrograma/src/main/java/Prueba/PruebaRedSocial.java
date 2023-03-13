/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import Entity.RedSocialEntidad;
import Entity.RedSocialUsuarioEntidad;
import Entity.Sexo;
import Entity.UsuarioEntidad;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diego
 */
public class PruebaRedSocial {
    public  void redSocial(){
        //Conexion Jpa
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("Conexion");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        //Transacion
        
        entity.getTransaction().begin();
        
        ArrayList <Object> entidades = new ArrayList<>();
        
        RedSocialEntidad facebook = new RedSocialEntidad("Facebook", "www.facebook.com", new GregorianCalendar(2003, 11, 1));
        RedSocialEntidad twitter = new RedSocialEntidad("Twitter", "www.Twitter.com", new GregorianCalendar(2003, 11, 1));
        RedSocialEntidad youtube = new RedSocialEntidad("Youtube", "www.Youtube.com", new GregorianCalendar(2003, 11, 1));
        entidades.add(facebook);
        entidades.add(twitter);
        entidades.add(youtube);
        
        
        UsuarioEntidad diego = new UsuarioEntidad("Diego", "diego@gmail.com", new GregorianCalendar(2003, 07, 3),Sexo.MASCULINO);
        diego.agregaRedSocial(new RedSocialUsuarioEntidad(diego, youtube, new GregorianCalendar(2012, 3, 3), "Castle"));
        entidades.add(diego);
        
        
        UsuarioEntidad gabriel = new UsuarioEntidad("Gabriel", "Gabriel@gmail.com", new GregorianCalendar(2003, 04, 17),Sexo.FEMENINO);
        gabriel.agregaRedSocial(new RedSocialUsuarioEntidad(gabriel, youtube, new GregorianCalendar(2011, 11, 1), "Schatten08"));
        gabriel.agregaRedSocial(new RedSocialUsuarioEntidad(gabriel, twitter, new GregorianCalendar(2011, 11, 1), "Schatten08"));
        gabriel.agregaRedSocial(new RedSocialUsuarioEntidad(gabriel, facebook, new GregorianCalendar(2011, 11, 1), "Schatten08"));
        entidades.add(gabriel);

        
        for (Object e : entidades) {
            entity.persist(e);
        }
        
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
}
