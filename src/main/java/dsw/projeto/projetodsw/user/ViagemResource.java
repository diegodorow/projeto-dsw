package dsw.projeto.projetodsw.user;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dsw.projeto.projetodsw.jpa.ViagemRepository;
import dsw.projeto.projetodsw.model.Confirmar;
import dsw.projeto.projetodsw.model.Viagem;
import jakarta.validation.Valid;

@RestController
public class ViagemResource {

	private ViagemRepository viagemRepository;

	public ViagemResource(ViagemRepository viagemRepository) {
		super();
		this.viagemRepository = viagemRepository;
	}

	@PostMapping("/viagens")
	public int createViagem(@Valid @RequestBody Viagem viagem) {
		Calendar dataViagem = Calendar.getInstance();
		viagem.setDthrviagem(dataViagem);
		Viagem savedViagem = viagemRepository.save(viagem);
		return savedViagem.getId();
	}

	@GetMapping("/viagens")
	public List<Viagem> allViagens() {
		return viagemRepository.findAll();
	}

	@GetMapping("/viagens/{id}")
	public List<Viagem> getViagens(@PathVariable int id) throws Exception {
		return viagemRepository.findByCliente(id);
	}

	@PostMapping("/confirmarviagens/{id}")
	public ResponseEntity<Viagem> confirmarViagens(@PathVariable int id, @RequestBody Confirmar confirmar) {
		int status = confirmar.getStatus();
		Optional<Viagem> viagem = viagemRepository.findById(id);
		Calendar dataPrevisao = Calendar.getInstance();
		viagem.get().setStatus(status);
		viagem.get().setPrevisao(dataPrevisao);
		Viagem savedViagem = viagemRepository.save(viagem.get());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedViagem.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
