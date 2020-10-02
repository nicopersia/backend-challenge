package com.ma.pedidos.domain;

import java.util.UUID;

public class Pedido {
	
	private String id;
	private String direccion;
	private String email;
	private String telefono;
	private String horario;
	private String fecha;
	private double total;
	private boolean descuento;
	private String estado;
	private PedidoDetalle[] detalle;
	
	public Pedido() {
		
	}
	
	public PedidoDetalle[] getDetalle() {
		return detalle;
	}

	public void setDetalle(PedidoDetalle[] detalle) {
		this.detalle = detalle;
	}

	public Pedido(String direccion,String email,String telefono,String horario,
			String fecha,double total,boolean descuento, String estado) {
		this.id = UUID.randomUUID().toString();
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.horario = horario;
		this.fecha = fecha;
		this.total = total;
		this.descuento = descuento;
		this.estado = estado;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}
	

}
