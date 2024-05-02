package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.DepositoSaque;
import com.devcookies.freelancecookies.entitys.Reclamacao;
import com.devcookies.freelancecookies.entitys.Transacao;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.DepositoSaqueRepository;
import com.devcookies.freelancecookies.repository.ReclamacaoRepository;
import com.devcookies.freelancecookies.repository.TransacaoRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.ReclamacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamacaoServiceImpl implements ReclamacaoService {

    @Autowired
    private ReclamacaoRepository reclamacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DepositoSaqueRepository depositoSaqueRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public List<Reclamacao> findAllReclamacoes() {
        return reclamacaoRepository.findAll();
    }

    @Override
    public List<Reclamacao> getAllReclamacoes() {
        return null;
    }

    @Override
    public Reclamacao getReclamacaoById(int id) {
        return reclamacaoRepository.findById(id).orElse(null);
    }

    @Override
    public Reclamacao createReclamacao(Reclamacao reclamacao) {
        Usuario usuario = usuarioRepository.findUsuarioById(reclamacao.getUsuario_Id().getId());
        DepositoSaque deposito = depositoSaqueRepository.findById(reclamacao.getDepositoSaque_Id().getId()).orElse(null);
        Transacao transacao = transacaoRepository.findById(reclamacao.getTransacao_Id().getId()).orElse(null);

        if(usuario == null || deposito == null || transacao == null)
            return null;
        reclamacao.setUsuario_Id(usuario);
        reclamacao.setDepositoSaque_Id(deposito);
        reclamacao.setTransacao_Id(transacao);
        return reclamacaoRepository.save(reclamacao);
    }

    @Override
    public void deleteReclamacao(int id) {

    }
}