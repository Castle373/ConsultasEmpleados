package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.persistence.jpa.config.Cascade;

@Entity
@Table(name = "tblEmpleados")
public class EmpleadoEntidad implements Serializable {

    public EmpleadoEntidad(String nombre, DireccionEntidad direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    

    public EmpleadoEntidad() {
    }

    public EmpleadoEntidad(String nombre) {
        this.nombre = nombre;
    }

    public EmpleadoEntidad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public EmpleadoEntidad(String nombre, EstatusEntidad estatus) {
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public EmpleadoEntidad(String nombre, EstatusEntidad estatus, DireccionEntidad Direccion) {
        this.nombre = nombre;
        this.estatus = estatus;
        this.direccion = Direccion;
    }

    @Id
    @Column(name = "idEmpleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres", length = 60, nullable = false)
    private String nombre;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="idEstatus", nullable = true)
    private EstatusEntidad estatus;
    
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="idDireccion", nullable = false)
    private DireccionEntidad direccion;

    public DireccionEntidad getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionEntidad direccion) {
        this.direccion = direccion;
    }

    
    public EstatusEntidad getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusEntidad estatus) {
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof EmpleadoEntidad)) {
            return false;
        }
        EmpleadoEntidad other = (EmpleadoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpleadoEntidad{" + "id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + ", direccion=" + direccion + '}';
    }

    

}
