public class TomouPrimeiraDose extends Estado {

	public TomouPrimeiraDose() {
		this.descricao = "Tomou a primeira dose da vacina";
	}

	@Override
	public void avancar20Dias(Pessoa pessoa) {
		pessoa.setEstado(new HabilitadaSegundaDose());
	}

	@Override
	public String tomarDose(Pessoa pessoa) {
		return "A pessoa selecionada ainda não está habilitada a tomar a segunda dose.";
	}
}
