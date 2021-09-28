package com.claudio.escuela.modelo.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pabellones")
public class Pabellon  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "metros_cuadrados")
    private Double mtr2;
    @Column(name = "nombre_pabellon", unique = true, nullable = false)
    private String nombre;
    @Embedded //Permite la instancia de una clase embebida
    //Sobreescribe los atributos nesesarios de la clase embebida
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "departamento", column = @Column(name = "dept"))
    })

    private Direccion direccion;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    /**
     * Crear la relacion de uno a muchos de pabellon a clase aula
     * por lo que se utiliza una variable de tipo set para crear una sola instancia
     * de la clase Aula
     */

    @OneToMany(
            mappedBy = "pabellon",
            /**
             * cuando la relacion es de uno a muchos es recomendable utilizat la carga
             * peresoza (lazy)
            */
            fetch = FetchType.LAZY
    )
    private Set<Aula> aulas; //Es nesesario crear los metodos setters and getters



    public Pabellon() {
    }

    public Pabellon(Integer id, Double mtr2, String nombre, Direccion direccion) {
        this.id = id;
        this.mtr2 = mtr2;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMtr2() {
        return mtr2;
    }

    public void setMtr2(Double mtr2) {
        this.mtr2 = mtr2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Set<Aula> getAulas() {
        return aulas;
    }

    /**
     * Crear metodos privados que se encargen de instancias las fechas de alta y fecha de modificacion
     * para que sean persistentes en todos los objetos que sean utilizados
     */

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeActualizar(){
        this.fechaModificacion = LocalDateTime.now();
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public String toString() {
        return "Pabellon{" +
                "id=" + id +
                ", mtr2=" + mtr2 +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) &&
                nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
