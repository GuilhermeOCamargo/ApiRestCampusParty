package br.com.campusparty;

import br.com.campusparty.model.Endereco;
import br.com.campusparty.model.Usuario;
import br.com.campusparty.repository.EnderecoRepository;
import br.com.campusparty.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CampuspartyApplication implements CommandLineRunner {

	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	public static void main(String[] args) {
		SpringApplication.run(CampuspartyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Endereco endereco = enderecoRepository.save(new Endereco("1111111", "rua 1", "bairro 1", "123"));

		usuarioRepository.save(new Usuario("Nome1", "email@email.com", Arrays.asList(endereco)));
	}
}

