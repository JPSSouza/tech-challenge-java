package com.fiap.fiapburger.adapter.in.controller;

import com.fiap.fiapburger.adapter.in.controller.mapper.ClienteMapper;
import com.fiap.fiapburger.adapter.in.controller.request.ClienteRequest;
import com.fiap.fiapburger.application.ports.in.EditarClienteInputport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.fiapburger.application.ports.in.SalvarClienteInputport;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private SalvarClienteInputport salvarClienteInputport;
    @Autowired
    private EditarClienteInputport editarClienteInputport;

    private ClienteMapper clienteMapper;
    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteRequest clienteRequest){
        var cliente = clienteMapper.toCliente(clienteRequest);
        salvarClienteInputport.salvar(cliente);
        return ResponseEntity.ok().build();
    };

    @PatchMapping
    public ResponseEntity<Void> editar(@Valid @RequestBody ClienteRequest clienteRequest){
        var cliente = clienteMapper.toCliente(clienteRequest);
        editarClienteInputport.editar(cliente);
        return ResponseEntity.ok().build();
    };

}
