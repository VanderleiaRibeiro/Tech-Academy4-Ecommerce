package com.ecommerce.estiloriel.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "log_precos")
public class LogPrecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_precos")
    private Integer idLogPrecos;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    private Date data;

    @Column(name = "valor_anterior")
    private Double valorAnterior;

    @Column(name = "valor_posterior")
    private Double valorPosterior;

    public LogPrecos() {}

    public LogPrecos(Usuario usuario, Produto produto, Date data, Double valorAnterior, Double valorPosterior) {
        this.usuario = usuario;
        this.produto = produto;
        this.data = data;
        this.valorAnterior = valorAnterior;
        this.valorPosterior = valorPosterior;
    }

    public Integer getIdLogPrecos() {
        return idLogPrecos;
    }

    public void setIdLogPrecos(Integer idLogPrecos) {
        this.idLogPrecos = idLogPrecos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogPrecos logPrecos = (LogPrecos) o;
        return Objects.equals(idLogPrecos, logPrecos.idLogPrecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLogPrecos);
    }

}
