//package com.ecommerce.estiloriel.dto;
//
//import java.util.Date;
//
//public class AvaliacaoRequestDTO {
//    private Integer idProduto;
//    private Integer idUsuario;
//    private Integer nota;
//    private String comentario;
//    private Date data;
//
//    public Integer getIdProduto() {
//        return idProduto;
//    }
//
//    public void setIdProduto(Integer idProduto) {
//        this.idProduto = idProduto;
//    }
//
//    public Integer getIdUsuario() {
//        return idUsuario;
//    }
//
//    public void setIdUsuario(Integer idUsuario) {
//        this.idUsuario = idUsuario;
//    }
//
//    public Integer getNota() {
//        return nota;
//    }
//
//    public void setNota(Integer nota) {
//        this.nota = nota;
//    }
//
//    public String getComentario() {
//        return comentario;
//    }
//
//    public void setComentario(String comentario) {
//        this.comentario = comentario;
//    }
//
//
//
package com.ecommerce.estiloriel.dto;

import java.util.Date;

public class AvaliacaoRequestDTO {
    private Integer idProduto;
    private Integer idUsuario;
    private Integer nota;
    private String comentario;
    private Date data;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
