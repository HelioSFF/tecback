package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.Planos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanosRepository extends JpaRepository<Planos, Long> {
}
