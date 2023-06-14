package com.example.funkeateapi.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * author = Jacko Tinoco
 *
 * */

@Entity
@Table(name="funkos_carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private int id;

    @Column(name="cantidad_total", columnDefinition = "int(11) default 0",  nullable = false)
    private int cantidadTotal;

    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0",  nullable = false)
    private double subtotal;

    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0",  nullable = false)
    private double descuento;

    @Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0",  nullable = false)
    private double total;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "created_at")
    private Date createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "update_at")
    private Date updateAt;

    @Column(columnDefinition = "boolean default true")
    private boolean estado;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Users users;

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
