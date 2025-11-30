package com.lanchonete.sistema_pedido.controller;

import com.lanchonete.sistema_pedido.DTO.ItemPedidoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.ItemPedidoResponseDTO;
import com.lanchonete.sistema_pedido.service.ItemPedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-pedido")
public class ItemPedidoController {

    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service){
        this.service = service;
    }

    @GetMapping
    public List<ItemPedidoResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public ItemPedidoResponseDTO cadastrar(@RequestBody ItemPedidoRequestDTO dto){
        return service.cadastrar(dto);
    }
}

