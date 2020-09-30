package com.ma.pedidos.domain;

public class PedidoDetalle {
	
	private Integer id;
	private float cantidad;
	private double precio_unitario;
	private Integer pedidos_cabecera_id;
	private Integer productos_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public Integer getPedidos_cabecera_id() {
		return pedidos_cabecera_id;
	}
	public void setPedidos_cabecera_id(Integer pedidos_cabecera_id) {
		this.pedidos_cabecera_id = pedidos_cabecera_id;
	}
	public Integer getProductos_id() {
		return productos_id;
	}
	public void setProductos_id(Integer productos_id) {
		this.productos_id = productos_id;
	}

}
