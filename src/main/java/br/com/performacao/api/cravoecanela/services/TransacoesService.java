package br.com.performacao.api.cravoecanela.services;

import br.com.performacao.api.cravoecanela.controller.dto.PageDTO;
import br.com.performacao.api.cravoecanela.controller.dto.TransacoesDTO;
import br.com.performacao.api.cravoecanela.entities.Transacoes;
import br.com.performacao.api.cravoecanela.mapper.TransacoesMapper;
import br.com.performacao.api.cravoecanela.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransacoesService {
    @Autowired
    private TransacoesRepository transacoesRepository;

    @Autowired
    private TransacoesMapper transacoesMapper;

    public TransacoesDTO createTransacao(Transacoes transacao) {
        Transacoes savedTransacao = transacoesRepository.save(transacao);
        return transacoesMapper.toTransacoesDTO(savedTransacao);
    }

    public void createTransacoesList(List<TransacoesDTO> transacoes) {
        transacoesRepository.saveAll(transacoesMapper.toTransacoesList(transacoes));
    }

    @Transactional(readOnly = true)
    public PageDTO<TransacoesDTO> findAll(Pageable pageable) {

        Page<Transacoes> result = transacoesRepository.findAll(pageable);

        PageDTO<TransacoesDTO> transacoes = new PageDTO<>(transacoesMapper.toTransacoesDTOList(result.getContent()));

        transacoes.setFirst(result.isFirst());
        transacoes.setLast(result.isLast());
        transacoes.setNumber(result.getNumber());
        transacoes.setNumberOfElements(result.getNumberOfElements());
        transacoes.setSize(result.getSize());
        transacoes.setTotalElements(result.getTotalElements());
        transacoes.setTotalPages(result.getTotalPages());
        transacoes.setSort(result.getSort());

        return transacoes;
    }

    public void update(TransacoesDTO transacoesDTO) throws ChangeSetPersister.NotFoundException {
        Transacoes transacoes = transacoesMapper.toTransacoesEntity(transacoesDTO);
        verifyIfExists(transacoes.getId());
        transacoesRepository.save(transacoes);
    }

    private void verifyIfExists(Long id) throws ChangeSetPersister.NotFoundException {
        transacoesRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
