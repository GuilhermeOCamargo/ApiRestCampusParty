package br.com.campusparty.services;

import br.com.campusparty.model.Usuario;
import br.com.campusparty.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoService enderecoService;

    public Usuario findById(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }
    @Transactional
    public Usuario save(Usuario usuario){
        usuario.setEnderecos(enderecoService.saveAll(usuario.getEnderecos()));
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
}
