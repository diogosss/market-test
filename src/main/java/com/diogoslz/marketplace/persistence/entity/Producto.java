package com.diogoslz.marketplace.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class Producto {

    @Id  //clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto") //nombre ral en la tabla de datos abajo notacion camelcase
    private Integer idProducto;

    private String nombre; //es el mismo nombre valor de la tabla no se pone @Column

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado; //es el mismo nombre valor de la tabla no se pone @Column

    @ManyToOne //
    @JoinColumn(name = "id_categoria",insertable = false, updatable = false)//no permitira añadir/borrar una categoria por medio de esta relacion
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
