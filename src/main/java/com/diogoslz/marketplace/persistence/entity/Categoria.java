package com.diogoslz.marketplace.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id  //clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria") //nombre ral en la tabla de datos abajo notacion camelcase
    private Integer idCategoria;

    private String descripcion;
    private boolean estado;

    @OneToMany(mappedBy = "categoria") ///de la clase Producto private Categoria categoria;
    private List<Producto> productos;

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
