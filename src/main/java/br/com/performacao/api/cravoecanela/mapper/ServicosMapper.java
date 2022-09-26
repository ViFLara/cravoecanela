package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.ServicosDTO;
import br.com.performacao.api.cravoecanela.entities.Servicos;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicosMapper {

    ServicosDTO toServicosDTO (Servicos servicos);

    Servicos toServicosEntity (ServicosDTO servicosDTO);

    List<ServicosDTO> toServicosDTOList (List<Servicos> servicos);

    List<Servicos> toServicosList (List<ServicosDTO> servicosDTOS);

}
