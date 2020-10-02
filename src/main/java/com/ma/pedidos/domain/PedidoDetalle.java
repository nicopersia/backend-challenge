package com.ma.pedidos.domain;

import java.util.UUID;

public class PedidoDetalle {
	
	private String id;
	private Integer cantidad;
	private double importe;
	private String pedidos_cabecera_id;
	private String producto;
	private String nombre;

	public PedidoDetalle() {
		/*this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.producto = producto;
		this.id = UUID.randomUUID().toString();*/
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getPedidos_cabecera_id() {
		return pedidos_cabecera_id;
	}
	public void setPedidos_cabecera_id(String pedidos_cabecera_id) {
		this.pedidos_cabecera_id = pedidos_cabecera_id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

}
