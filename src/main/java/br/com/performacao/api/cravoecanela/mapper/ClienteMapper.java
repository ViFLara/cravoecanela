package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.ClienteDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDTO toClienteDTO (Cliente cliente);
    Cliente toClienteEntity (ClienteDTO clienteDTO);

    List<ClienteDTO> toClienteDTOList (List<Cliente> cliente);

}
