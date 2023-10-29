package com.fiap.fiapburger.application.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItensPedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String produto;
    private String pedido;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
