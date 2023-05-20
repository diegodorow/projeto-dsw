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

import dsw.projeto.projetodsw.jpa.PedidoRepository;
import dsw.projeto.projetodsw.model.Confirmar;
import dsw.projeto.projetodsw.model.Pedido;
import jakarta.validation.Valid;

@RestController
public class PedidoResource {

	private PedidoRepository pedidoRepository;

	public PedidoResource(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
	}

	@PostMapping("/pedidos")
	public int createPedido(@Valid @RequestBody Pedido pedido) {
		Calendar dataPedido = Calendar.getInstance();
		pedido.setDthrpedido(dataPedido);
		Pedido savedPedido = pedidoRepository.save(pedido);
		return savedPedido.getId();
	}

	@GetMapping("/pedidos")
	public List<Pedido> allPedidos() {
		return pedidoRepository.findAll();
	}

	@GetMapping("/pedidos/{id}")
	public List<Pedido> getPedidos(@PathVariable int id) throws Exception {
		return pedidoRepository.findByCliente(id);
	}

	@PostMapping("/confirmarpedidos/{id}")
	public ResponseEntity<Pedido> confirmarPedidos(@PathVariable int id, @RequestBody Confirmar confirmar) {
		int status = confirmar.getStatus();
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		Calendar dataPrevisao = Calendar.getInstance();
		pedido.get().setStatus(status);
		pedido.get().setPrevisao(dataPrevisao);
		Pedido savedPedido = pedidoRepository.save(pedido.get());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPedido.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
