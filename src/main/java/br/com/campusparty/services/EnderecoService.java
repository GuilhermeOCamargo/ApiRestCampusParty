package br.com.campusparty.services;

import br.com.campusparty.model.Endereco;
import br.com.campusparty.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco findById(Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.get();
    }
    @Transactional
    public Endereco save(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public void deleteById(Long id){
        enderecoRepository.deleteById(id);
    }

    @Transactional
    public List<Endereco> saveAll(List<Endereco> enderecos){
        return enderecoRepository.saveAll(enderecos);
    }
}
