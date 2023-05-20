package dsw.projeto.projetodsw.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dsw.projeto.projetodsw.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	Optional<Pedido> findById(int id);
	List<Pedido> findByCliente(int id);
}
