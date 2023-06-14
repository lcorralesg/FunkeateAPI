package com.example.funkeateapi.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * author = Jacko Tinoco
 *
 * */

@Entity
@Table(name="ubigeo")
public class Ubigeo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private int id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String calle;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String distrito;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String provincia;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String departamento;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String pais;

    @Column(columnDefinition = "varchar(255)", nullable = false, name = "codigo_postal")
    private String codigoPostal;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String referencia;


    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "created_at")
    private Date createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "update_at")
    private Date updateAt;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Users users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
