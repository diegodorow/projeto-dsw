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

import dsw.projeto.projetodsw.jpa.EstoqueRepository;
import dsw.projeto.projetodsw.jpa.ProdutoRepository;
import dsw.projeto.projetodsw.model.Estoque;
import dsw.projeto.projetodsw.model.Produto;
import jakarta.validation.Valid;

@RestController
public class ProdutoResource {

	private ProdutoRepository produtoRepository;
	private EstoqueRepository estoqueRepository;

	public ProdutoResource(ProdutoRepository repository, EstoqueRepository estoqueRepository) {
		super();
		this.produtoRepository = repository;
		this.estoqueRepository = estoqueRepository;
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

	@PostMapping("/estoque")
	public ResponseEntity<Estoque> addEstoque(@Valid @RequestBody Estoque estoque) {
		System.out.println("Criando produto " + estoque.getProduto());
		Estoque savedEstoque = estoqueRepository.save(estoque);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEstoque.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
