package dsw.projeto.projetodsw.user;

import org.mindrot.jbcrypt.BCrypt;

public class Credencial {
	private String username;
	private String senha;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String[] getSenhaCriptografada() {
		final String salt = BCrypt.gensalt();
		String senhaEnc = BCrypt.hashpw(this.senha, salt);
		return new String[] {senhaEnc, salt};
	}

}
