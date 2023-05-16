package dsw.projeto.projetodsw.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Integer id;

	private String descricao;
	private float valor;
	private int quantidade;
	private String tamanho;
	private String cor;
	private String imagem;

	@OneToMany(mappedBy = "produto")
	@JsonIgnore
	private List<Estoque> estoque;

	public Produto() {

	}

	public Produto(Integer id, String descricao, float valor, int quantidade, String tamanho, String cor, String imagem,
			List<Estoque> estoque) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
		this.tamanho = tamanho;
		this.cor = cor;
		this.imagem = imagem;
		this.estoque = estoque;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", quantidade=" + quantidade
				+ ", tamanho=" + tamanho + ", cor=" + cor + ", imagem=" + imagem + ", estoque=" + estoque + "]";
	}

}
