package com.ma.pedidos.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ma.pedidos.domain.Pedido;
import com.ma.pedidos.domain.dto.PedidoDTO;
import com.ma.pedidos.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	ModelMapper mapper;
	
	@RequestMapping(value = "/pedidos", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> crearPedido(@Valid @RequestBody PedidoDTO pedido) {
		Pedido p = mapper.map(pedido, Pedido.class);
	    p = pedidoService.crearPedido(p);
	    return ResponseEntity.ok(mapper.map(p, PedidoDTO.class));
	}
	
	@RequestMapping(value = "/pedidos", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<PedidoDTO> listarPorFecha(@RequestParam String fecha){
		List<Pedido> pedidos = pedidoService.listarPedidos(fecha);
		List<PedidoDTO> pedidosDTO = mapper.map(pedidos, new TypeToken<List<PedidoDTO>>() {}.getType());
		return pedidosDTO;
	}
	
	
}
