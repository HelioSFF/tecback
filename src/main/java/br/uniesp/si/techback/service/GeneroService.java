package br.uniesp.si.techback.service;

import br.uniesp.si.techback.exception.EntidadeNaoEncontradaException;
import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneroService {

    private final GeneroRepository generoRepository;


    public List<Genero> listar() { return generoRepository.findAll(); }

    public Genero burcarPorId(Long id) {
        return generoRepository.findById(id)
                .orElswThrow(() -> new EntidadeNaoEncontradaException("Genero não encontra com o ID: " + id));
    }
}
