package dsw.projeto.projetodsw.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dsw.projeto.projetodsw.jpa.ProdutoRepository;
import dsw.projeto.projetodsw.model.Produto;
import jakarta.validation.Valid;

@RestController
public class ProdutoResource {

	private ProdutoRepository produtoRepository;

	public ProdutoResource(ProdutoRepository repository) {
		super();
		this.produtoRepository = repository;
	}

	@PostMapping("/produtos")
	public ResponseEntity<Produto> createProduto(@Valid @RequestBody Produto produto) {
		System.out.println("Criando produto " + produto.getDescricao());
		Produto savedProduto = produtoRepository.save(produto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduto.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/produtos")
	public List<Produto> allProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Produto getUser(@PathVariable int id) throws Exception {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isEmpty()) {
			throw new Exception("Erro: id do produto não encontrado: " + id);
		}
		return produto.get();
	}
	
	@DeleteMapping("/produtos/{idCamisa}")
	public void excluirCamisa(@PathVariable int idCamisa) {
		produtoRepository.deleteById(idCamisa);
	}

}
