package dsw.projeto.projetodsw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Estoque {
	@Id
	@GeneratedValue
	private int id;

	private int produto;
	private int pedido;
	private String operacao;
	private int quantidade;

	public Estoque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estoque(int id, int produto, int pedido, String operacao, int quantidade) {
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

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
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
