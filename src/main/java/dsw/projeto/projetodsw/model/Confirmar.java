package dsw.projeto.projetodsw.model;

public class Confirmar {
	private int id;
	private int status;

	public Confirmar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Confirmar(int id, int status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Confirmar [id=" + id + ", status=" + status + "]";
	}

}
