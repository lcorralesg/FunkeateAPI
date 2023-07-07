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

	@Column(columnDefinition = "varchar(50) default '16x12x9 cm'", name = "tamano_caja")
	private String tamanoCaja;

	@Column(columnDefinition = "varchar(50) default '13x6 cm'", name = "tamano_funko")
	private String tamanoFunko;
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

	public String getTamanoCaja() {
		return tamanoCaja;
	}

	public void setTamanoCaja(String tamañoCaja) {
		this.tamanoCaja = tamanoCaja;
	}

	public String getTamanoFunko() {
		return tamanoFunko;
	}

	public void setTamanoFunko(String tamanoFunko) {
		this.tamanoFunko = tamanoFunko;
	}
}
//insert into funkos_producto (nombre, descripcion, precio, imagen, estado, categoria_id) values ('Funko Pop! Marvel: Avengers Endgame - Captain America with Broken Shield & Mjoinir', 'Funko Pop! Marvel: Avengers Endgame - Captain America with Broken Shield & Mjoinir', 15.99, 'https://m.media-amazon.com/images/I/61LQ7gJzxXL.jpg', true, 1);

//insert into funkos_producto (nombre, descripcion, precio, imagen, estado, categoria_id) values ('Funko Pop! Naruto Uzumaki Rasengan', 'Naruto Shippuden - Rasengan', 15.99, 'https://content.emarket.pe/common/collections/products/52/95/52953d70-0ce8-46d8-8ffa-b23dbd369c54.jpg', true, 2);