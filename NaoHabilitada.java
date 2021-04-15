import java.util.Collections;

public class NaoHabilitada extends Estado {

	public NaoHabilitada() {
		this.descricao = "Não habilitada para vacina";
	}

	@Override
	public void atualizar(Pessoa pessoa, Governo governo) {
		if (governo.getProfissoesHabilitamPrimeiraDose().contains(pessoa.getProfissao()))
			pessoa.setEstado(new HabilitadaPrimeiraDose());
		else if (Collections.indexOfSubList(governo.getComorbidadesHabilitamPrimeiraDose(), pessoa.getComorbidades()) != -1)
			pessoa.setEstado(new HabilitadaPrimeiraDose());
		else if (pessoa.getIdade() >= governo.getIdadeHabilitaPrimeiraDose())
			pessoa.setEstado(new HabilitadaPrimeiraDose());
	}

	@Override
	public String tomarDose(Pessoa pessoa) {
		return "A pessoa selecionada ainda não está habilitada a tomar a primeira dose.";
	}
	
}
