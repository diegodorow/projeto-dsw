package dsw.projeto.projetodsw.model;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Viagem {
	@Id
	@GeneratedValue
	private int id;

	private float valor;
	private int status;
	private int cliente;
	private String entrega;
	private int pedido;

	@Column(name = "previsao", columnDefinition = "TIMESTAMP")
	private Calendar previsao;

	@Column(name = "dthrpedido", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Calendar dthrviagem;

	public Viagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Viagem(int id, float valor, int status, int cliente, String entrega, int pedido, Calendar previsao,
			Calendar dthrviagem) {
		super();
		this.id = id;
		this.valor = valor;
		this.status = status;
		this.cliente = cliente;
		this.entrega = entrega;
		this.pedido = pedido;
		this.previsao = previsao;
		this.dthrviagem = dthrviagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public Calendar getPrevisao() {
		return previsao;
	}

	public void setPrevisao(Calendar previsao) {
		this.previsao = previsao;
	}

	public Calendar getDthrviagem() {
		return dthrviagem;
	}

	public void setDthrviagem(Calendar dthrviagem) {
		this.dthrviagem = dthrviagem;
	}

	@Override
	public String toString() {
		return "Viagem [id=" + id + ", valor=" + valor + ", status=" + status + ", cliente=" + cliente + ", entrega="
				+ entrega + ", pedido=" + pedido + ", previsao=" + previsao + ", dthrviagem=" + dthrviagem + "]";
	}

}
