package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosDetalhamentoOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosListagemOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaMapper {

    public DadosListagemOcorrencia toListDTO(Ocorrencia ocorrencia) {
        return new DadosListagemOcorrencia(
                ocorrencia.getId(),
                ocorrencia.getUsuario(),
                ocorrencia.getTurma(),
                ocorrencia.getAluno(),
                ocorrencia.getRegistrada_em(),
                ocorrencia.getCategoriaOcorrencia(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getDescricao()
        );
    }

    public DadosDetalhamentoOcorrencia toDetailsDTO(Ocorrencia ocorrencia) {
        return new DadosDetalhamentoOcorrencia(
                ocorrencia.getId(),
                ocorrencia.getUsuario(),
                ocorrencia.getTurma(),
                ocorrencia.getAluno(),
                ocorrencia.getRegistrada_em(),
                ocorrencia.getCategoriaOcorrencia(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getDescricao()
        );
    }
}
