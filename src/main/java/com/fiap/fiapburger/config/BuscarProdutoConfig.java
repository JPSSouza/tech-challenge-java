package com.fiap.fiapburger.config;

import com.fiap.fiapburger.adapter.out.BuscarProdutoAdapter;
import com.fiap.fiapburger.application.core.usecase.BuscarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarProdutoConfig {

    @Bean
    public BuscarProdutoUseCase buscarProdutoUseCase(BuscarProdutoAdapter buscarProdutoAdapter){
        return new BuscarProdutoUseCase(buscarProdutoAdapter);
    }

}