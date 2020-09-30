package com.ma.pedidos.domain;

public class PedidoCabecera {
	
	private Integer id;
	private String direccion;
	private String mail;
	private String telefono;
	private String horario;
	private String fecha_alta;
	private double monto_total;
	private boolean aplico_descuento;
	private Integer estado;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public double getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}
	public boolean isAplico_descuento() {
		return aplico_descuento;
	}
	public void setAplico_descuento(boolean aplico_descuento) {
		this.aplico_descuento = aplico_descuento;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	

}
