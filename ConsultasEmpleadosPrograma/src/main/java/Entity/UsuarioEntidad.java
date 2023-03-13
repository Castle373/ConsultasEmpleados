/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name="Usuario")
public class UsuarioEntidad implements Serializable {
    public UsuarioEntidad(){
        
    }

    public UsuarioEntidad( String Nombre, String Correo, Calendar fechaNacimiento, Sexo sexo) {
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.redesSociales= new ArrayList<RedSocialUsuarioEntidad>();
    }

    @Id
    @Column(name="IdUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Nombre",nullable =  false)
    private String Nombre;
    
    @Column(name="Correo",nullable =  false)
    private String Correo;
    
    @Column(name="fechaNacimiento",nullable =  false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @Column(name="Sexo",nullable =  false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @OneToMany(mappedBy = "usuarioEntidad",cascade = CascadeType.ALL)
    private List<RedSocialUsuarioEntidad> redesSociales;

    public void agregaRedSocial(RedSocialUsuarioEntidad RedSocialUsuarioEntidad){
        this.redesSociales.add(RedSocialUsuarioEntidad);
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEntidad)) {
            return false;
        }
        UsuarioEntidad other = (UsuarioEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UsuarioEntidad[ id=" + id + " ]";
    }
    
}
