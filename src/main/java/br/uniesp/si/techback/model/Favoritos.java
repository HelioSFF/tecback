package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favoritos")

public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "filme_id", nullable = false)
    private Long filmeId;

    @Column(name = "criado_em", nullable = false)
    private java.time.LocalDateTime criadoEm;
}
