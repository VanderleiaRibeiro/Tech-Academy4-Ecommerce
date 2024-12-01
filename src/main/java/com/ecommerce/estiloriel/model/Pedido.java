package com.ecommerce.estiloriel.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_status", referencedColumnName = "id_status")
    private Status status;

    private Double total;

    public Pedido() {}

    public Pedido(Usuario usuario, Date data, Status status, Double total) {
        this.usuario = usuario;
        this.data = data;
        this.status = status;
        this.total = total;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(idPedido, pedido.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido);
    }

    public void setIdUsuario(Usuario idUsuario) {
    }

    public void setIdStatus(Status idStatus) {
    }
}
