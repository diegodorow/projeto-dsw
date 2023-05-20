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
import dsw.projeto.projetodsw.model.EstoqueCamisa;
import dsw.projeto.projetodsw.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.Valid;

@RestController
public class ProdutoResource {

	@PersistenceContext
	private EntityManager em;
	private ProdutoRepository produtoRepository;
	private EstoqueRepository estoqueRepository;

	public ProdutoResource(ProdutoRepository repository, EstoqueRepository estoqueRepository) {
		super();
		this.produtoRepository = repository;
		this.estoqueRepository = estoqueRepository;
	}

	@PostMapping("/produtos")
	public ResponseEntity<Produto> createProduto(@Valid @RequestBody Produto produto) {
		System.out.println("Criando o produto id " + produto.getDescricao());
		Produto savedProduto = produtoRepository.save(produto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduto.getId()).toUri();

		System.out.println("Adicionando estoque do produto id " + savedProduto.getId());
		Optional<Produto> produtoId = produtoRepository.findById(savedProduto.getId());
		Estoque estoque = new Estoque();
		estoque.setProduto(produtoId.get());
		estoque.setOperacao("Cadastro de produto");
		estoque.setQuantidade(produto.getQuantidade());
		Estoque savedEstoque = estoqueRepository.save(estoque);
		location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEstoque.getId())
				.toUri();

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

	@PostMapping("/addestoque/{id}")
	public ResponseEntity<Estoque> addEstoque(@PathVariable int id, @Valid @RequestBody Estoque estoque) {
		System.out.println("Adicionando estoque do produto id " + id);
		Optional<Produto> produto = produtoRepository.findById(id);
		estoque.setProduto(produto.get());
		Estoque savedEstoque = estoqueRepository.save(estoque);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEstoque.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/baixaestoque")
	public boolean baixaEstoque(@Valid @RequestBody EstoqueCamisa estoque) {
		System.out.println("Registrando venda do produto id " + estoque.getId_produto());
		System.out.println("Registrando venda do pedido id " + estoque.getId_pedido());
		if (estoque.getId_produto() > 0) {
			Optional<Produto> produtoId = produtoRepository.findById(estoque.getId_produto());
			Estoque addEstoque = new Estoque();
			addEstoque.setProduto(produtoId.get());
			addEstoque.setOperacao("Venda");
			addEstoque.setPedido(estoque.getId_pedido());
			addEstoque.setQuantidade(1);
			Estoque savedEstoque = estoqueRepository.save(addEstoque);

			// atualizar a quantidade em estoque do produto
			Produto produto = produtoId.get();
			int novaQuantidade = produto.getQuantidade() - 1;
			produto.setQuantidade(novaQuantidade);
			Produto savedProduto = produtoRepository.save(produto);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedEstoque.getId()).toUri();
			return true;
		}
		System.out.println("Não registou a baixa do produto");
		return false;
	}

	@GetMapping("/dashboard")
	@SuppressWarnings("unchecked")
	public int getDashboard() {
		System.out.println("Entrou na função getDashboard()");
		/*Query query = em.createQuery("select produto.id,\r\n" + "			   produto.descricao,\r\n"
				+ "			   sum(estoque.quantidade) as qtd \r\n" + "		  from estoque \r\n"
				+ "		  join pedido on (pedido.id = estoque.pedido)\r\n"
				+ "		  join produto on (produto.id = estoque.produto_id)\r\n"
				+ "		 where estoque.operacao = 'Venda'\r\n" + "		   and pedido.status = 1\r\n"
				+ "	  group by produto.id,\r\n" + "			   produto.descricao");*/
		Query query = em.createQuery("select coalesce(max(previsao),current_date) from pedido");
		System.out.println("Query Dashboard> " + query);
		return query.getMaxResults();
	}

}
