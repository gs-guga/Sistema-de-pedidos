package com.lanchonete.sistema_pedido.controller;

import com.lanchonete.sistema_pedido.DTO.PedidoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.PedidoResponseDTO;
import com.lanchonete.sistema_pedido.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    @PostMapping
    public PedidoResponseDTO cadastrar(@RequestBody PedidoRequestDTO dto){
        return service.cadastrar(dto);
    }

    @GetMapping
    public List<PedidoResponseDTO> listar(){
        return service.listar();
    }
}




