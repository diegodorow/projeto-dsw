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

import dsw.projeto.projetodsw.jpa.PedidoRepository;
import dsw.projeto.projetodsw.model.Confirmar;
import dsw.projeto.projetodsw.model.Pedido;

@RestController
public class PedidoResource {

	private PedidoRepository pedidoRepository;

	public PedidoResource(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
	}

	@GetMapping("/pedidos")
	public List<Pedido> allPedidos() {
		return pedidoRepository.findAll();
	}

	@PostMapping("/confirmarpedidos/{id}")
	public ResponseEntity<Pedido> confirmarPedidos(@PathVariable int id, @RequestBody Confirmar confirmar) {
		int status = confirmar.getStatus();
		System.out.println("Alterando o status do pedido id " + id + ", status: " + status);
		Optional<Pedido> user = pedidoRepository.findById(id);
		user.get().setStatus(status);
		Pedido savedPedido = pedidoRepository.save(user.get());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPedido.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
