package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.ServicosDTO;
import br.com.performacao.api.cravoecanela.entities.Servicos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicosMapper {

    @Mapping(source = "quantidade_horas", target = "quantidadeHoras")
    ServicosDTO toServicosDTO (Servicos servicos);

    List<ServicosDTO> toServicosDTOList (List<Servicos> servicos);


}
