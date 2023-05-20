package dsw.projeto.projetodsw.model;

public class EstoqueCamisa {

	/*
	 * const camisa = { id: item.id, descricao: item.descricao, valor: item.valor,
	 * tamanho: item.tamanho, cor: item.cor, };
	 */
	private int id;
	private String descricao;
	private float valor;
	private String tamanho;
	private String cor;

	public EstoqueCamisa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstoqueCamisa(int id, String descricao, float valor, String tamanho, String cor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.tamanho = tamanho;
		this.cor = cor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "EstoqueCamisa [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", tamanho=" + tamanho
				+ ", cor=" + cor + "]";
	}

}
