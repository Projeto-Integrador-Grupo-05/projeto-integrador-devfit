
package com.generation.devfit.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.generation.devfit.model.UsuarioLogin;
import com.generation.devfit.security.JwtService;
import com.generation.devfit.model.IMC;
import com.generation.devfit.model.Usuario;
import com.generation.devfit.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			return Optional.empty();

		usuario.setSenha(criptografarSenha(usuario.getSenha()));

		return Optional.of(usuarioRepository.save(usuario));

	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {

		if (usuarioRepository.findById(usuario.getId()).isPresent()) {

			Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());

			if ((buscaUsuario.isPresent()) && (buscaUsuario.get().getId() != usuario.getId()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

			usuario.setSenha(criptografarSenha(usuario.getSenha()));

			return Optional.ofNullable(usuarioRepository.save(usuario));

		}

		return Optional.empty();
	}

	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {

		var credenciais = new UsernamePasswordAuthenticationToken(usuarioLogin.get().getEmail(),
				usuarioLogin.get().getSenha());

		Authentication authentication = authenticationManager.authenticate(credenciais);

		if (authentication.isAuthenticated()) {

			Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());

			if (usuario.isPresent()) {

				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setEmail(usuario.get().getEmail());
				usuarioLogin.get().setAltura(usuario.get().getAltura());
				usuarioLogin.get().setPeso(usuario.get().getPeso());
				usuarioLogin.get().setNivelFitness(usuario.get().getNivelFitness());
				usuarioLogin.get().setObjetivo(usuario.get().getObjetivo());
				usuarioLogin.get().setToken(gerarToken(usuarioLogin.get().getEmail()));
				usuarioLogin.get().setSenha("");

				return usuarioLogin;

			}

		}

		return Optional.empty();

	}

	private String criptografarSenha(String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.encode(senha);

	}

	private String gerarToken(String usuario) {
		return "Bearer " + jwtService.generateToken(usuario);
	}

	public IMC calcularImc(Long id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent()) {

			Double valor = usuario.get().getPeso() / (usuario.get().getAltura() * usuario.get().getAltura());

			IMC imc = new IMC(valor, classificacaoImc(valor));

			return imc;
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}

	private String classificacaoImc(Double valor) {

		String descricao = null;

		if (valor < 18.5) {
			descricao = "Abaixo do peso";
		} else if (valor >= 18.5 && valor < 24.9) {
			descricao = "Peso ideal";
		} else if (valor >= 24.9 && valor < 29.9) {
			descricao = "Levemente acima do peso";
		} else if (valor >= 29.9 && valor < 34.9) {
			descricao = "Obesidade Grau I";
		} else if(valor >= 34.9 && valor < 39.9) {
			descricao = "Obesidade Grau II (Severa)";
		}else {
			descricao = "Obesidade Grau III (Morbida)";
		}

		return descricao;
	}
}
