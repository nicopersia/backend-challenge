package com.ma.pedidos.domain.dto;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import com.ma.pedidos.domain.Pedido;
import com.ma.pedidos.domain.PedidoDetalle;
import com.ma.pedidos.domain.Producto;
import com.ma.pedidos.validador.PedidoDomicilio;

public class PedidoDTO {
	
	private String fecha;
	@PedidoDomicilio
	private String direccion;
	private String email;
	private String telefono;
	private String horario;
	@Valid
	private List<PedidoDetalleDTO> detalle;
	private double total;
	private boolean descuento;
	private String estado;
	
	public List<PedidoDetalleDTO> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<PedidoDetalleDTO> detalle) {
		this.detalle = detalle;
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
	public boolean isDescuento() {
		return descuento;
	}
	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
