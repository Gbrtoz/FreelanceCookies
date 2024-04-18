package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.cadastrarUsuario(usuario);
        if (user != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuariot(@RequestBody Usuario usuario) {
        return  ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizarUsuario(usuario));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuarioById(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.deletarUsuarioById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
