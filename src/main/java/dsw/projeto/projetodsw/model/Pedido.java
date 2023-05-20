package dsw.projeto.projetodsw.model;

import java.sql.Date;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue
	private Integer id;

	private String cartao;
	private String entrega;

	@Column(name = "previsao", columnDefinition = "TIMESTAMP")
	private Calendar previsao;

	@Column(name = "dthrpedido", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Calendar dthrpedido;
	private float valor;
	private int status;
	private int cliente;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, String cartao, String entrega, Calendar previsao, Calendar dthrpedido, float valor,
			int status, int cliente) {
		super();
		this.id = id;
		this.cartao = cartao;
		this.entrega = entrega;
		this.previsao = previsao;
		this.dthrpedido = dthrpedido;
		this.valor = valor;
		this.status = status;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public Calendar getPrevisao() {
		return previsao;
	}

	public void setPrevisao(Calendar previsao) {
		this.previsao = previsao;
	}

	public Calendar getDthrpedido() {
		return dthrpedido;
	}

	public void setDthrpedido(Calendar dthrpedido) {
		this.dthrpedido = dthrpedido;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cartao=" + cartao + ", entrega=" + entrega + ", previsao=" + previsao
				+ ", dthrpedido=" + dthrpedido + ", valor=" + valor + ", status=" + status + ", cliente=" + cliente
				+ "]";
	}

}
