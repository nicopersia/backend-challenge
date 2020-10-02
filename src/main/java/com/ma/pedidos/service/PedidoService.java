package com.ma.pedidos.service;

import java.util.List;


import com.ma.pedidos.domain.Pedido;
import com.ma.pedidos.domain.PedidoDetalle;
import com.ma.pedidos.domain.dto.PedidoDTO;

public interface PedidoService {
	
	Pedido crearPedido(Pedido pedido);
	Pedido listarCabecera(String fecha);
	List<PedidoDetalle> listarDetalle(String fecha);
	List<Pedido> listarPedidos(String fecha);

}
