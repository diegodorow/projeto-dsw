package dsw.projeto.projetodsw.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dsw.projeto.projetodsw.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
	Optional<Estoque> findByProduto(int produto);
}
