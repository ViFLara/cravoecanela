package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.TransacoesDTO;
import br.com.performacao.api.cravoecanela.entities.Transacoes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransacoesMapper {

    TransacoesDTO toTransacoesDTO (Transacoes transacoes);
    Transacoes toTransacoesEntity (TransacoesDTO transacoesDTO);

    List<TransacoesDTO> toTransacoesDTOList (List<Transacoes> transacoes);

}
