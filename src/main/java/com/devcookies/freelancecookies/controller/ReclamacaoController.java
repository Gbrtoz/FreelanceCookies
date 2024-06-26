package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.Reclamacao;
import com.devcookies.freelancecookies.service.interfaces.ReclamacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reclamacoes")
public class ReclamacaoController {

    @Autowired
    private ReclamacaoService reclamacaoService;


    @GetMapping
    public ResponseEntity<List<Reclamacao>> findAllReclamacoes() {
        List<Reclamacao> reclamacoes = reclamacaoService.findAllReclamacoes();
        return new ResponseEntity<>(reclamacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamacao> getReclamacaoById(@PathVariable("id") int id) {
        Reclamacao reclamacao = reclamacaoService.getReclamacaoById(id);
        if (reclamacao == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reclamacao, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReclamacaoDTO> createReclamacao(@RequestBody ReclamacaoDTO reclamacao) throws Exception {

        try{
            ReclamacaoDTO reclamacaoCreted = reclamacaoService.createReclamacao(reclamacao);
            if (reclamacaoCreted != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(reclamacaoCreted);
            } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e){
            throw  new Exception(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReclamacaoById(@PathVariable("id") int id) {
        Reclamacao reclamacao = reclamacaoService.getReclamacaoById(id);
        if (reclamacao == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        reclamacaoService.deleteReclamacao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
