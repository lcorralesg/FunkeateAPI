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
    
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date created_at;
	
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date update_at;
    
    @Column(columnDefinition = "boolean default true")
	private boolean estado;

	@Column(columnDefinition = "boolean default true")
	private boolean caja_personalizada;

	@Column(columnDefinition = "boolean default true")
	private boolean personalizable;

	@Column(columnDefinition = "varchar(50) default 16x12x9 cm")
	private String tamaño_caja;

	@Column(columnDefinition = "varchar(50) default 13x6 cm")
	private String tamaño_funko;
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
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

	public boolean isCaja_personalizada() {
		return caja_personalizada;
	}

	public void setCaja_personalizada(boolean caja_personalizada) {
		this.caja_personalizada = caja_personalizada;
	}

	public boolean isPersonalizable() {
		return personalizable;
	}

	public void setPersonalizable(boolean personalizable) {
		this.personalizable = personalizable;
	}

	public String getTamaño_caja() {
		return tamaño_caja;
	}

	public void setTamaño_caja(String tamaño_caja) {
		this.tamaño_caja = tamaño_caja;
	}

	public String getTamaño_funko() {
		return tamaño_funko;
	}

	public void setTamaño_funko(String tamaño_funko) {
		this.tamaño_funko = tamaño_funko;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
}
//insert into funkos-producto (nombre, descripcion, precio, imagen, categoria_id) values ('Goku', 'Funko de Goku', 10.00, 'test2', 1);
//insert into funkos_producto (nombre, descripcion, precio, imagen, categoria_id) values ('Capitan America', 'Funko de Capitan America', 10.00, 'test1', 2);