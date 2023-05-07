package dsw.projeto.projetodsw.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dsw.projeto.projetodsw.jpa.UsuarioRepository;
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

	@GetMapping("/users/{id}")
	public Usuario getUser(@PathVariable int id) throws Exception {
		Optional<Usuario> user = usuarioRepository.findById(id);
		if (user.isEmpty()) {
			throw new Exception("Erro: id do usuário não encontrado: " + id);
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
}