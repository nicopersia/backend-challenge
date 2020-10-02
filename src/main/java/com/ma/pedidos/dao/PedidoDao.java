package com.ma.pedidos.dao;

import java.util.List;

import com.ma.pedidos.domain.Pedido;
import com.ma.pedidos.domain.PedidoDetalle;

public interface PedidoDao {
	
	void crearPedido(Pedido pedido);
	Pedido listarCabecera(String fecha);
	List<PedidoDetalle> listarDetalle(String fecha);
	List<Pedido> listarPedidos(String fecha);

}
