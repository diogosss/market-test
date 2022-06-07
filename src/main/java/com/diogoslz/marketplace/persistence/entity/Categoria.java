package com.diogoslz.marketplace.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id  //clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria") //nombre ral en la tabla de datos abajo notacion camelcase
    private Integer idCategoria;

    private String descripcion;

    private boolean estado;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
