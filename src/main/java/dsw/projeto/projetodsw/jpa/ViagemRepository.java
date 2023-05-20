package dsw.projeto.projetodsw.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dsw.projeto.projetodsw.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {
	Optional<Viagem> findById(int id);
	List<Viagem> findByCliente(int id);
}
