package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity(name = "Turma")
@Table(name = "turma")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TurmaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_turma;

    @Enumerated(EnumType.STRING)
    private Turno turno;
    private Year ano;
    private Integer semestre;

    private boolean ativo = true;

}