package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblEstatus")
public class EstatusEntidad implements Serializable {

    public EstatusEntidad() {
    }

    public EstatusEntidad(String nombre) {
        this.nombre = nombre;
    }

    public EstatusEntidad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public EstatusEntidad(String nombre, List<EmpleadoEntidad> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    @Id
    @Column(name = "idEstatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @OneToMany(mappedBy = "estatus", cascade = {CascadeType.ALL})
    private List<EmpleadoEntidad> empleados;

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

    public List<EmpleadoEntidad> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoEntidad> empleados) {
        this.empleados = empleados;
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
        if (!(object instanceof EstatusEntidad)) {
            return false;
        }
        EstatusEntidad other = (EstatusEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EstatusEntidad[ id=" + id + " ]";
    }

}
