package br.com.performacao.api.cravoecanela.services;

import br.com.performacao.api.cravoecanela.controller.dto.PageDTO;
import br.com.performacao.api.cravoecanela.controller.dto.ServicosDTO;
import br.com.performacao.api.cravoecanela.entities.Servicos;
import br.com.performacao.api.cravoecanela.mapper.ServicosMapper;
import br.com.performacao.api.cravoecanela.repositories.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private ServicosMapper servicosMapper;

    @Transactional(readOnly = true)
    public PageDTO<ServicosDTO> findAll(Pageable pageable) {

        Page<Servicos> result = servicosRepository.findAll(pageable);

        PageDTO<ServicosDTO> servicos = new PageDTO<>(servicosMapper.toServicosDTOList(result.getContent()));

        servicos.setFirst(result.isFirst());
        servicos.setLast(result.isLast());
        servicos.setNumber(result.getNumber());
        servicos.setNumberOfElements(result.getNumberOfElements());
        servicos.setSize(result.getSize());
        servicos.setTotalElements(result.getTotalElements());
        servicos.setTotalPages(result.getTotalPages());
        servicos.setSort(result.getSort());

        return servicos;
    }

}
