package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.TransacoesDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.entities.Servicos;
import br.com.performacao.api.cravoecanela.entities.Transacoes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransacoesMapper {

    @Mapping(target = "horasTotais" , source = "horas_totais")
    @Mapping(target = "valorTotal" , source = "valor_total")
    @Mapping(target = "clienteId", expression = "java(transacoes.getCliente().getId())")
    @Mapping(target = "servicosIds", expression = "java(TransacoesDTO.transformServicos(transacoes.getServicos()))")
    TransacoesDTO toTransacoesDTO (Transacoes transacoes);

    @Mapping(source = "transacoesDTO.horasTotais" , target = "horas_totais")
    @Mapping(source = "transacoesDTO.valorTotal" , target = "valor_total")
    @Mapping(source = "transacoesDTO.status" , target = "status")
    @Mapping(source = "transacoesDTO.id", target = "id")
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "servicos", target = "servicos")
    Transacoes toTransacoesEntity (TransacoesDTO transacoesDTO, Cliente cliente, List<Servicos> servicos);

    List<TransacoesDTO> toTransacoesDTOList (List<Transacoes> transacoes);

    List<Transacoes> toTransacoesList (List<TransacoesDTO> transacoes);

}
