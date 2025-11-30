package com.lanchonete.sistema_pedido.controller;

import com.lanchonete.sistema_pedido.DTO.ProdutoRequestDTO;
import com.lanchonete.sistema_pedido.DTO.ProdutoResponseDTO;
import com.lanchonete.sistema_pedido.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutoResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public ProdutoResponseDTO cadastrar(@RequestBody ProdutoRequestDTO dto) {
        return service.cadastrar(dto);
    }
}
