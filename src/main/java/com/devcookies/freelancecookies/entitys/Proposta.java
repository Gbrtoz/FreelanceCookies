package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private Usuario Usuario;

    @ManyToOne
    @JoinColumn(name = "Oferta_Id")
    private Oferta Oferta_Id;

    private String Texto;

    @Column(nullable = false)
    private int Prazo;

    @Column(nullable = false)
    private double Preco;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date TempoAtual;

    public Proposta() {
    }

    public Proposta(Usuario usuario_Id, Oferta oferta_Id, String texto, int prazo, double preco, Date tempoAtual) {
        Usuario = usuario_Id;
        Oferta_Id = oferta_Id;
        Texto = texto;
        Prazo = prazo;
        Preco = preco;
        TempoAtual = tempoAtual;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario_Id) {
        this.Usuario = usuario_Id;
    }

    public Oferta getOferta() {
        return Oferta_Id;
    }

    public void setOferta(Oferta oferta_Id) {
        this.Oferta_Id = oferta_Id;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public int getPrazo() {
        return Prazo;
    }

    public void setPrazo(int prazo) {
        Prazo = prazo;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public Date getTempoAtual() {return TempoAtual;}

    public void setTempoAtual(Date tempoAtual) {
        TempoAtual = tempoAtual;
    }



}
