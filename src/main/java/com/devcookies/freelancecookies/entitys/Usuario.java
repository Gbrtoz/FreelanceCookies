package com.devcookies.freelancecookies.entitys;

import com.devcookies.freelancecookies.dto.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table(name="Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String Nome;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Cpf;

    @Column(nullable = false)
    private String Telefone;

    @Column(nullable = false)
    private String Senha;
    @Column(nullable = false)
    private double Saldo;

    private double Nota;

    private double Avaliacoes;

    public Usuario(int id, String nome, String email, String cpf, String telefone, String senha ,double saldo, double nota, double avaliacoes) {
        Id = id;
        Nome = nome;
        Email = email;
        Cpf = cpf;
        Telefone = telefone;
        Senha = senha;
        Saldo = saldo;
        Nota = nota;
        Avaliacoes = avaliacoes;
    }

    public Usuario( String nome, String email, String cpf, String telefone, String senha ,double saldo, double nota, double avaliacoes) {
        Nome = nome;
        Email = email;
        Cpf = cpf;
        Telefone = telefone;
        Senha = senha;
        Saldo = saldo;
        Nota = nota;
        Avaliacoes = avaliacoes;
    }

    public Usuario() {
    }

    public Usuario(UsuarioDTO usuarioDTO){
        Nome = usuarioDTO.getNome();
        Email = usuarioDTO.getEmail();
        Cpf = usuarioDTO.getCpf();
        Telefone = usuarioDTO.getTelefone();
        Senha = usuarioDTO.getSenha();
    }


    

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double nota) {
        Nota = nota;
    }

    public double getAvaliacoes() {
        return Avaliacoes;
    }

    public void setAvaliacoes(double avaliacoes) {
        Avaliacoes = avaliacoes;
    }
}
