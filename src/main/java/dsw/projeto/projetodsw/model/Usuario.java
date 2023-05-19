package dsw.projeto.projetodsw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 3, message = "O nome deve conter ao menos três letras")
	private String nome;

	@Column(unique = true)
	@NotNull
	private String usuario;

	@Size(min = 1)
	@NotNull
	private String senha;

	private String cartao;
	private String validade;
	private int numeroCvv;
	private String cep;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String administrador;
	private int status;
	
	private String entregacep;
	private String entregaendereco;
	private int entreganumero;
	private String entregacomplemento;
	private String entregabairro;
	private String entregacidade;
	private String entregauf;
	

	public Usuario() {

	}

	

	public Usuario(Integer id, @Size(min = 3, message = "O nome deve conter ao menos três letras") String nome,
			@NotNull String usuario, @Size(min = 1) @NotNull String senha, String cartao, String validade,
			int numeroCvv, String cep, String endereco, int numero, String complemento, String bairro, String cidade,
			String uf, String administrador, int status, String entregacep, String entregaendereco, int entreganumero,
			String entregacomplemento, String entregabairro, String entregacidade, String entregauf) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.cartao = cartao;
		this.validade = validade;
		this.numeroCvv = numeroCvv;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.administrador = administrador;
		this.status = status;
		this.entregacep = entregacep;
		this.entregaendereco = entregaendereco;
		this.entreganumero = entreganumero;
		this.entregacomplemento = entregacomplemento;
		this.entregabairro = entregabairro;
		this.entregacidade = entregacidade;
		this.entregauf = entregauf;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getNumeroCvv() {
		return numeroCvv;
	}

	public void setNumeroCvv(int numeroCvv) {
		this.numeroCvv = numeroCvv;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String tipo) {
		this.administrador = tipo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	public String getEntregacep() {
		return entregacep;
	}



	public void setEntregacep(String entregacep) {
		this.entregacep = entregacep;
	}



	public String getEntregaendereco() {
		return entregaendereco;
	}



	public void setEntregaendereco(String entregaendereco) {
		this.entregaendereco = entregaendereco;
	}



	public int getEntreganumero() {
		return entreganumero;
	}



	public void setEntreganumero(int entreganumero) {
		this.entreganumero = entreganumero;
	}



	public String getEntregacomplemento() {
		return entregacomplemento;
	}



	public void setEntregacomplemento(String entregacomplemento) {
		this.entregacomplemento = entregacomplemento;
	}



	public String getEntregabairro() {
		return entregabairro;
	}



	public void setEntregabairro(String entregabairro) {
		this.entregabairro = entregabairro;
	}



	public String getEntregacidade() {
		return entregacidade;
	}



	public void setEntregacidade(String entregacidade) {
		this.entregacidade = entregacidade;
	}



	public String getEntregauf() {
		return entregauf;
	}



	public void setEntregauf(String entregauf) {
		this.entregauf = entregauf;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", usuario=" + usuario + ", senha=" + senha + ", cartao="
				+ cartao + ", validade=" + validade + ", numeroCvv=" + numeroCvv + ", cep=" + cep + ", endereco="
				+ endereco + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade="
				+ cidade + ", uf=" + uf + ", administrador=" + administrador + ", status=" + status + ", entregacep="
				+ entregacep + ", entregaendereco=" + entregaendereco + ", entreganumero=" + entreganumero
				+ ", entregacomplemento=" + entregacomplemento + ", entregabairro=" + entregabairro + ", entregacidade="
				+ entregacidade + ", entregauf=" + entregauf + "]";
	}

	

}
