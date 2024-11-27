package com.ecommerce.estiloriel.dto;

import jakarta.persistence.Column;

public class CategoriaRequestDTO {
    private String nome;
    private String descricao;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
