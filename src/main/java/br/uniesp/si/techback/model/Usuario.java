package br.uniesp.si.techback.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome_completo;

    @Column(nullable = false)
    private LocalDate data_nascimento;

    @Column(nullable = false, unique = true, length = 254)
    private String email;

    @Column(nullable = false, length = 60)
    private String senha_hash;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf_cnpj;

    @Column(nullable = false, length = 20)
    private String perfil;

    @Column(nullable = false)
    private LocalDate criado_em;

    @Column(nullable = false)
    private LocalDate atualizado_em;
}
