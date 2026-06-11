package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia.DadosRegistroOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosDetalhamentoOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosListagemOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaMapper {

    public DadosListagemOcorrencia toListDTO(Ocorrencia ocorrencia) {
        return new DadosListagemOcorrencia(ocorrencia);
    }

    public DadosDetalhamentoOcorrencia toDetailsDTO(Ocorrencia ocorrencia) {
        return new DadosDetalhamentoOcorrencia(ocorrencia);
    }
}
