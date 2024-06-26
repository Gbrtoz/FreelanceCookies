package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.Oferta;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class OfertaDTO {
    private int id;
    private int usuarioId;
    private String titulo;
    private String texto;
    private String imagem;
    private int prazo;
    private double preco;
    private boolean status;
    private LocalDateTime tempoAtual;


    public OfertaDTO() {}

    public OfertaDTO(int id, int usuarioId, String titulo, String texto, String imagem, int prazo, double preco, boolean status, LocalDateTime tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.titulo = titulo;
        this.texto = texto;
        this.imagem = imagem;
        this.prazo = prazo;
        this.preco = preco;
        this.status = status;
        this.tempoAtual = tempoAtual;
    }

    public OfertaDTO(int usuarioId, String titulo, String texto, String imagem, int prazo, double preco) {
        this.usuarioId = usuarioId;
        this.titulo = titulo;
        this.texto = texto;
        this.imagem = imagem;
        this.prazo = prazo;
        this.preco = preco;
        this.status = true;
        this.tempoAtual = LocalDateTime.now();
    }

    public OfertaDTO(Oferta oferta){
        this.id = oferta.getId();
        this.usuarioId = oferta.getUsuario().getId();
        this.titulo = oferta.getTitulo();
        this.texto = oferta.getTexto();
        this.imagem = oferta.getImagem();
        this.prazo = oferta.getPrazo();
        this.preco = oferta.getPreco();
        this.status = oferta.isStatus();
        this.tempoAtual = oferta.getTempoAtual();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {
        this.tempoAtual = tempoAtual;
    }
}

