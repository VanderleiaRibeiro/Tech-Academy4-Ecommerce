package com.ecommerce.estiloriel.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Integer idStatus;

    private String nome;

    public Status() {}

    public Status(String nome) {
        this.nome = nome;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(idStatus, status.idStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStatus);
    }
}
