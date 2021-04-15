import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Governo {

	private List<String> profissoesHabilitamPrimeiraDose;
	private List<String> comorbidadesHabilitamPrimeiraDose;
	private int idadeHabilitaPrimeiraDose;

	private HashMap<String, Pessoa> pessoas;

	public Governo() {
		this.pessoas = new HashMap<>();
		this.profissoesHabilitamPrimeiraDose = new ArrayList<>(Arrays.asList("médico"));
		this.comorbidadesHabilitamPrimeiraDose = new ArrayList<>(Arrays.asList("hipertensão"));
		this.idadeHabilitaPrimeiraDose = 60;
	}

	public void notificarPessoasCadastradas() {
		for (Pessoa p : pessoas.values())
			p.atualizar(this);
	}

	public void cadastraPessoa(String cpf, String nomeCompleto, String numeroCartaoSUS, String email, String telefone,
			String profissao, List<String> comorbidades, int idade) {
		Pessoa pessoa = new Pessoa(cpf, nomeCompleto, numeroCartaoSUS, email, telefone, profissao, comorbidades, idade);
		pessoas.put(cpf, pessoa);
		pessoa.atualizar(this);
	}

	public Pessoa getPessoa(String cpf) {
		return pessoas.get(cpf);
	}

	public void removePessoa(String cpf) {
		pessoas.remove(cpf);
	}

	public void alteraPessoa(String cpf, String nomeCompleto, String numeroCartaoSUS, String email, String telefone,
			String profissao, List<String> comorbidades, int idade) {
		Pessoa pessoa = getPessoa(cpf);

		pessoa.setNomeCompleto(nomeCompleto);
		pessoa.setNumeroCartaoSUS(numeroCartaoSUS);
		pessoa.setEmail(email);
		pessoa.setTelefone(telefone);
		pessoa.setProfissao(profissao);
		pessoa.setComorbidades(comorbidades);
		pessoa.setIdade(idade);

		pessoa.atualizar(this);
	}

	public List<String> getProfissoesHabilitamPrimeiraDose() {
		return profissoesHabilitamPrimeiraDose;
	}

	public List<String> getComorbidadesHabilitamPrimeiraDose() {
		return comorbidadesHabilitamPrimeiraDose;
	}

	public int getIdadeHabilitaPrimeiraDose() {
		return idadeHabilitaPrimeiraDose;
	}

	public void atualizarRequisitos(List<String> profissoesHabilitamPrimeiraDose, List<String> comorbidadesHabilitamPrimeiraDose, int idadeHabilitaPrimeiraDose) {
		this.profissoesHabilitamPrimeiraDose = profissoesHabilitamPrimeiraDose;
		this.comorbidadesHabilitamPrimeiraDose = comorbidadesHabilitamPrimeiraDose;
		this.idadeHabilitaPrimeiraDose = idadeHabilitaPrimeiraDose;
		notificarPessoasCadastradas();
	}

	public void avancar20Dias() {
		for (Pessoa p : pessoas.values())
			p.avancar20Dias();
	}

	public String tomarDose(String cpf) {
		Pessoa pessoa = getPessoa(cpf);
		return pessoa.tomarDose();
	}
}
