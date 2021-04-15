public class HabilitadaPrimeiraDose extends Estado {

	public HabilitadaPrimeiraDose() {
		this.descricao = "Habilitada para a primeira dose da vacina";
	}

	@Override
	public String tomarDose(Pessoa pessoa) {
		pessoa.setEstado(new TomouPrimeiraDose());
		return "Primeira dose tomada. Aguardar 20 dias para a habilitação da segunda dose.";
	}
}
