package com.ma.pedidos.domain;

public class Producto {
	
	private String id;
	private String nombre;
	private String descripcion_corta;
	private String desccripcion_larga;
	private Long precio_unitario;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion_corta() {
		return descripcion_corta;
	}
	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
	}
	public String getDesccripcion_larga() {
		return desccripcion_larga;
	}
	public void setDesccripcion_larga(String desccripcion_larga) {
		this.desccripcion_larga = desccripcion_larga;
	}
	public Long getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(Long precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

}
