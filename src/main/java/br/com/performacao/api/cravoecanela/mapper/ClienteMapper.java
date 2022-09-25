package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.ClienteDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.enums.Genero;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;

import java.util.List;

import static br.com.performacao.api.cravoecanela.enums.Genero.*;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(expression = "java(null == ClienteDTO.transformGeneroToEnum(cliente.getGenero()) ? null : ClienteDTO.transformGeneroToEnum(cliente.getGenero()))", target = "genero")
    @Mapping(expression = "java(null == ClienteDTO.transformECToEnum(cliente.getEstadoCivil()) ? null : ClienteDTO.transformECToEnum(cliente.getEstadoCivil()))", target = "estadoCivil")
    ClienteDTO toClienteDTO (Cliente cliente);
    @Mapping(expression = "java(null == clienteDTO.getGenero().getValue() ? null : clienteDTO.getGenero().getValue())", target = "genero")
    @Mapping(expression = "java(null == clienteDTO.getEstadoCivil().getValue() ? null : clienteDTO.getEstadoCivil().getValue())", target = "estadoCivil")
    @Mapping(target = "Endereco.cliente",ignore = true)
    Cliente toClienteEntity (ClienteDTO clienteDTO);

    List<ClienteDTO> toClienteDTOList (List<Cliente> cliente);

    List<Cliente> toClienteList (List<ClienteDTO> cliente);

}
