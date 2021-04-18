package revisao;

public class Usuario {
	private String usuario;
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		if (usuario.length() > 0)
			this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha.length() > 0)
			this.senha = senha;
	}

}
