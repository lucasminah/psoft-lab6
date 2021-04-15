import java.util.List;

public class Pessoa {

	private Estado estado;

	private String nomeCompleto;
	private String cpf;
	private String numeroCartaoSUS;
	private String email;
	private String telefone;
	private String profissao;
	private List<String> comorbidades;
	private int idade;

	public Pessoa(String cpf, String nomeCompleto, String numeroCartaoSUS, String email, String telefone,
			String profissao, List<String> comorbidades, int idade) {
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.numeroCartaoSUS = numeroCartaoSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.comorbidades = comorbidades;
		this.idade = idade;
		this.estado = new NaoHabilitada();
	}

	public void atualizar(Governo governo) {
		estado.atualizar(this, governo);
	}

	public void avancar20Dias() {
		estado.avancar20Dias(this);
	}

	public String tomarDose() {
		return estado.tomarDose(this);
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroCartaoSUS() {
		return numeroCartaoSUS;
	}

	public void setNumeroCartaoSUS(String numeroCartaoSUS) {
		this.numeroCartaoSUS = numeroCartaoSUS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<String> getComorbidades() {
		return comorbidades;
	}

	public void setComorbidades(List<String> comorbidades) {
		this.comorbidades = comorbidades;
	}
}
