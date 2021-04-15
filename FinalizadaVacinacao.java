public class FinalizadaVacinacao extends Estado {

	public FinalizadaVacinacao() {
		this.descricao = "Vacinação finalizada!";
	}

	@Override
	public String tomarDose(Pessoa pessoa) {
		return "A vacinação para a pessoa selecionada já foi finalizada.";
	}

}
