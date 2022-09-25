package br.com.performacao.api.cravoecanela.services;

import br.com.performacao.api.cravoecanela.controller.dto.PageDTO;
import br.com.performacao.api.cravoecanela.controller.dto.TransacoesDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.entities.Transacoes;
import br.com.performacao.api.cravoecanela.mapper.TransacoesMapper;
import br.com.performacao.api.cravoecanela.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public PageDTO<TransacoesDTO> findAll(Pageable pageable, Long clienteId) {

        List<Transacoes> result = transacoesRepository.findAll()
                .stream()
                .filter(transacoes -> transacoes.getCliente().getId() == clienteId)
                .collect(Collectors.toList());

        Page<Transacoes> resultPage = new PageImpl<>(result,pageable, result.size());

        PageDTO<TransacoesDTO> transacoes = new PageDTO<>(transacoesMapper.toTransacoesDTOList(result));

        transacoes.setFirst(resultPage.isFirst());
        transacoes.setLast(resultPage.isLast());
        transacoes.setNumber(resultPage.getNumber());
        transacoes.setNumberOfElements(resultPage.getNumberOfElements());
        transacoes.setSize(resultPage.getSize());
        transacoes.setTotalElements(resultPage.getTotalElements());
        transacoes.setTotalPages(resultPage.getTotalPages());
        transacoes.setSort(resultPage.getSort());

        return transacoes;
    }

    public void update(String status, Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Transacoes> transacoes = transacoesRepository.findById(id);
        transacoes.orElseThrow().setStatus(status);
        transacoesRepository.save(transacoes.get());
    }

    private void verifyIfExists(Long id) throws ChangeSetPersister.NotFoundException {
        transacoesRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}

