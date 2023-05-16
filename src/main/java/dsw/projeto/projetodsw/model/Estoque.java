package dsw.projeto.projetodsw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Estoque {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Produto produto;
	private int pedido;
	private String operacao;
	private int quantidade;

	public Estoque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estoque(int id, Produto produto, int pedido, String operacao, int quantidade) {
		super();
		this.id = id;
		this.produto = produto;
		this.pedido = pedido;
		this.operacao = operacao;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", produto=" + produto + ", pedido=" + pedido + ", operacao=" + operacao
				+ ", quantidade=" + quantidade + "]";
	}

}
