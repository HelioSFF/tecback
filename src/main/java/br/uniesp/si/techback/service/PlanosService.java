package br.uniesp.si.techback.service;

import br.uniesp.si.techback.exception.EntidadeNaoEncontradaException;
import br.uniesp.si.techback.model.Planos;
import br.uniesp.si.techback.repository.PlanosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanosService {

    private final PlanosRepository planosRepository;

    public List<Planos> listar() {
        return planosRepository.findAll();
    }

    public Planos buscarPorId(Long id) {
        return planosRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Plano não encontrado com o ID: " + id));
    }

    @Transactional
    public Planos salvar(Planos planos) {
        return planosRepository.save(planos);
    }

    @Transactional
    public Planos atualizar(Long id, Planos planos) {
        if (!planosRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Plano não encontrado com o ID: " + id);
        }
        planos.setId(id);
        return planosRepository.save(planos);
    }

    @Transactional
    public void excluir(Long id) {
        if (!planosRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Plano não encontrado com o ID: " + id);
        }
        planosRepository.deleteById(id);
    }
}
