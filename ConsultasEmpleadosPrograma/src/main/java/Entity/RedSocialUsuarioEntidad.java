/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name="RelacionUsuarioRed")
public class RedSocialUsuarioEntidad implements Serializable {
    public RedSocialUsuarioEntidad(){
        
    }
    @Id
    @Column(name="IdRelacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="IdUsuario",nullable =  false)
    private UsuarioEntidad usuarioEntidad;
    @ManyToOne
    @JoinColumn(name="IdRedSocial",nullable =  false)
    private RedSocialEntidad redSocialEntidad;
    
    @Column(name="fechaRegistro",nullable =  false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRegistro;
    
    @Column(name="Pseudonimo",nullable =  false)
    private String pseudonimo;

    public RedSocialUsuarioEntidad(UsuarioEntidad UsuarioEntidad, RedSocialEntidad RedSocialEntidad, Calendar fechaRegistro, String Pseudonimo) {
        this.usuarioEntidad = UsuarioEntidad;
        this.redSocialEntidad = RedSocialEntidad;
        this.fechaRegistro = fechaRegistro;
        this.pseudonimo = Pseudonimo;
    }
    
   

    public UsuarioEntidad getUsuarioEntidad() {
        return usuarioEntidad;
    }

    public void setUsuarioEntidad(UsuarioEntidad usuarioEntidad) {
        this.usuarioEntidad = usuarioEntidad;
    }

    public RedSocialEntidad getRedSocialEntidad() {
        return redSocialEntidad;
    }

    public void setRedSocialEntidad(RedSocialEntidad redSocialEntidad) {
        this.redSocialEntidad = redSocialEntidad;
    }

    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
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
        if (!(object instanceof RedSocialUsuarioEntidad)) {
            return false;
        }
        RedSocialUsuarioEntidad other = (RedSocialUsuarioEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RedSocialUsuarioEntidad[ id=" + id + " ]";
    }
    
}
