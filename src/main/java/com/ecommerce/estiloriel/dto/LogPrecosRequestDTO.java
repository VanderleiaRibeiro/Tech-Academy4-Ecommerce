package com.ecommerce.estiloriel.dto;

import java.util.Date;

public class LogPrecosRequestDTO {
    private Integer idUsuario;
    private Integer idProduto;
    private Date data;
    private Double valorAnterior;
    private Double valorPosterior;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(Double valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public Double getValorPosterior() {
        return valorPosterior;
    }

    public void setValorPosterior(Double valorPosterior) {
        this.valorPosterior = valorPosterior;
    }
}
