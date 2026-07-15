package com.javanauta.bffagendadortarefas.business;

import com.javanauta.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.javanauta.bffagendadortarefas.infrastructure.client.TarefaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefaClient tarefaClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {
        return tarefaClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token) {
        return tarefaClient.buscaListaDeTarefaPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {
        return tarefaClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefaClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefaClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return tarefaClient.updateTarefa(dto, id, token);
    }
}
