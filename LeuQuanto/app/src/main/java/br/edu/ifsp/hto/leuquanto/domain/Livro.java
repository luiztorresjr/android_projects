package br.edu.ifsp.hto.leuquanto.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Livro implements Serializable{

    @SerializedName("n_livro")
    long id;

    @SerializedName("titulo")
    String titulo;

    @SerializedName("autor")
    String autor;

    @SerializedName("paginas_total")
    int paginasTotal;

    @SerializedName("paginas_lida")
    int paginasLidas;

    @SerializedName("paginas_faltando")
    int paginasFaltando;

    @SerializedName("status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginasTotal() {
        return paginasTotal;
    }

    public void setPaginasTotal(int paginasTotal) {
        this.paginasTotal = paginasTotal;
    }

    public int getPaginasLidas() {
        return paginasLidas;
    }

    public void setPaginasLidas(int paginasLidas) {
        this.paginasLidas = paginasLidas;
    }

    public int getPaginasFaltando() {
        return paginasFaltando;
    }

    public void setPaginasFaltando(int paginasFaltando) {
        this.paginasFaltando = paginasFaltando;
    }
}
