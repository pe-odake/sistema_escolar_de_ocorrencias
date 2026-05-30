package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Perfil;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity(name = "Ocorrencia")
@Table(name = "ocorrencia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class OcorrenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id")
    private TurmaEntity turma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    private Instant registrada_em;

    @Enumerated(EnumType.STRING)
    private Categoria_Ocorrencia categoriaOcorrencia;

    @Enumerated(EnumType.STRING)
    private Tipo_Ocorrencia tipoOcorrencia;

    private String descricao;

}