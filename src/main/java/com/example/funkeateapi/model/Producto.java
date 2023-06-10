package com.example.funkeateapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="funkos_producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "varchar(55)", unique = true, nullable = false)
	private String nombre;
	
    @Column(columnDefinition = "varchar(255)", nullable = false)
	private String descripcion;

	@Column(columnDefinition = "varchar(255)")
	private String detalles;
    
    @Column(columnDefinition = "decimal(8,2)", nullable = false)
	private double precio;
    
    @Column(columnDefinition = "varchar(255)", nullable = false, unique = true)
	private String imagen;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "created_at")
	private Date createdAt;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = "update_at")
	private Date updateAt;
    
    @Column(columnDefinition = "boolean default true")
	private boolean estado;

	@Column(columnDefinition = "boolean default true", name = "caja_personalizada")
	private boolean cajaPersonalizada;

	@Column(columnDefinition = "boolean default true")
	private boolean personalizable;

	@Column(columnDefinition = "varchar(50) default 16x12x9 cm", name="tamaño_caja")
	private String tamañoCaja;

	@Column(columnDefinition = "varchar(50) default 13x6 cm", name = "tamaño_funko")
	private String tamañoFunko;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Categoria categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isPersonalizable() {
		return personalizable;
	}

	public void setPersonalizable(boolean personalizable) {
		this.personalizable = personalizable;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
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

	public boolean isCajaPersonalizada() {
		return cajaPersonalizada;
	}

	public void setCajaPersonalizada(boolean cajaPersonalizada) {
		this.cajaPersonalizada = cajaPersonalizada;
	}

	public String getTamañoCaja() {
		return tamañoCaja;
	}

	public void setTamañoCaja(String tamañoCaja) {
		this.tamañoCaja = tamañoCaja;
	}

	public String getTamañoFunko() {
		return tamañoFunko;
	}

	public void setTamañoFunko(String tamañoFunko) {
		this.tamañoFunko = tamañoFunko;
	}
}
//insert into funkos-producto (nombre, descripcion, precio, imagen, categoria_id) values ('Goku', 'Funko de Goku', 10.00, 'test2', 1);
//insert into funkos_producto (nombre, descripcion, precio, imagen, categoria_id) values ('Capitan America', 'Funko de Capitan America', 10.00, 'test1', 2);