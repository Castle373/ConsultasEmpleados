/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="RedSocial")
public class RedSocialEntidad implements Serializable {
    public RedSocialEntidad(){
        
    }

    @Id
    @Column(name="IdRedSocial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRedSocial;
    
    @Column(name="Nombre",nullable =  false)
    private String Nombre;
    
    @Column(name="paginaWeb",nullable =  false)
    private String paginaWeb;
    
    @Column(name="fechaInicio",nullable =  false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaInicio;
    
    @OneToMany(mappedBy = "redSocialEntidad",cascade = CascadeType.ALL)
    private List<RedSocialUsuarioEntidad> Usuarios;

    public RedSocialEntidad(String Nombre, String paginaWeb, Calendar fechaInicio) {
        this.Nombre = Nombre;
        this.paginaWeb = paginaWeb;
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<RedSocialUsuarioEntidad> getLista() {
        return Usuarios;
    }

    public void setLista(List<RedSocialUsuarioEntidad> lista) {
        this.Usuarios = lista;
    }
    
    
    public Integer getIdRedSocial() {
        return idRedSocial;
    }
    

    public void setIdRedSocial(Integer idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedSocial != null ? idRedSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idRedSocial fields are not set
        if (!(object instanceof RedSocialEntidad)) {
            return false;
        }
        RedSocialEntidad other = (RedSocialEntidad) object;
        if ((this.idRedSocial == null && other.idRedSocial != null) || (this.idRedSocial != null && !this.idRedSocial.equals(other.idRedSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RedSocialEntidad[ id=" + idRedSocial + " ]";
    }
    
}
