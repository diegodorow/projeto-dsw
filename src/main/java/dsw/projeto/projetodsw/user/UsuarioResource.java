package dsw.projeto.projetodsw.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dsw.projeto.projetodsw.jpa.UsuarioRepository;
import dsw.projeto.projetodsw.model.Confirmar;
import dsw.projeto.projetodsw.model.Credencial;
import dsw.projeto.projetodsw.model.Usuario;
import jakarta.validation.Valid;

@RestController
public class UsuarioResource {
	private UsuarioRepository usuarioRepository;

	public UsuarioResource(UsuarioRepository repository) {
		super();
		this.usuarioRepository = repository;
	}

	@PostMapping("/users")
	public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario user) {
		Usuario savedUser = usuarioRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users")
	public List<Usuario> allUsers() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/users/{username}")
	public Usuario getUser(@PathVariable String username) throws Exception {
		Optional<Usuario> user = usuarioRepository.findByUsuario(username);
		if (user.isEmpty()) {
			throw new Exception("Erro: id do usuário não encontrado: " + username);
		}
		return user.get();
	}

	@PostMapping("/autenticar")
	public Boolean autenticar(@RequestBody Credencial credencial) {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(credencial.getUsername());
		if (usuario.isEmpty()) {
			return false;
		}

		boolean passwordMatch = false;
		if (credencial.getSenha().equals(usuario.get().getSenha())) {
			passwordMatch = true;
		}

		return passwordMatch;
	}

	@PostMapping("/validaradm")
	public Boolean validaradm(@RequestBody Credencial credencial) {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(credencial.getUsername());
		if (usuario.isEmpty()) {
			return false;
		}

		String tipo = "Administrador";
		boolean validarAdmin = false;
		if (tipo.equals(usuario.get().getAdministrador())) {
			validarAdmin = true;
		}

		return validarAdmin;
	}

	@PostMapping("/validarcliente")
	public Boolean validarcliente(@RequestBody Credencial credencial) {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(credencial.getUsername());
		if (usuario.isEmpty()) {
			return false;
		}

		String tipo = "Cliente";
		boolean validarAdmin = false;
		if (tipo.equals(usuario.get().getAdministrador())) {
			validarAdmin = true;
		}

		return validarAdmin;
	}

	@GetMapping("/clientes")
	public List<Usuario> allProdutos() {
		return usuarioRepository.findAll();
	}

	@PostMapping("/bloquearclientes/{id}")
	public ResponseEntity<Usuario> bloquearCliente(@PathVariable int id, @RequestBody Confirmar bloqueio) {
		int status = bloqueio.getStatus();
		Optional<Usuario> user = usuarioRepository.findById(id);
		user.get().setStatus(status);
		Usuario savedUsuario = usuarioRepository.save(user.get());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUsuario.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}