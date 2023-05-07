package dsw.projeto.projetodsw.jpa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dsw.projeto.projetodsw.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	Optional<Produto> findByDescricao(String desricao);
}
