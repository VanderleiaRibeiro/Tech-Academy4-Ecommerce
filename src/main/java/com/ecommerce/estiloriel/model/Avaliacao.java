package com.ecommerce.estiloriel.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Avaliacao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_avaliacao") // Nome da coluna no banco de dados
        private Integer idAvaliacao;

        @Column(name = "id_produto")
        private Integer idProduto;

        @Column(name = "id_usuario")
        private Integer idUsuario;

        private Integer nota;

        private String comentario;

       // @Temporal(TemporalType.DATE)
        private Date data;

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(idAvaliacao, avaliacao.idAvaliacao) && Objects.equals(idProduto, avaliacao.idProduto) && Objects.equals(idUsuario, avaliacao.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAvaliacao, idProduto, idUsuario);
    }
}
