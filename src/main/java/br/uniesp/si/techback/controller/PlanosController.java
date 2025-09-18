package br.uniesp.si.techback.controller;


import br.uniesp.si.techback.model.Planos;
import br.uniesp.si.techback.service.PlanosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/planos")
@RequiredArgsConstructor

public class PlanosController {
    private final PlanosService planosService;

    @GetMapping
    public List<Planos> listar() {return planosService.listar();}

    @GetMapping("/{id}")
    public ResponseEntity<Planos> buscarPorId(Long id) {
        try {
            return ResponseEntity.ok(planosService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Planos> criar(@Valid @RequestBody Planos planos) {
        Planos planosSalvo = planosService.salvar(planos);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(planosSalvo.getId())
                .toUri();
        return ResponseEntity.created(location).body(planosSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planos> atualizar(@PathVariable Long id, @Valid @RequestBody Planos planos) {
        try {
            Planos planosAtualizado = planosService.atualizar(id, planos);
            return ResponseEntity.ok(planosAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            planosService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}