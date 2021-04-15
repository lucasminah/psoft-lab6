public class HabilitadaSegundaDose extends Estado {

	public HabilitadaSegundaDose() {
		this.descricao = "Habilitada para a segunda dose da vacina";
	}

	@Override
	public String tomarDose(Pessoa pessoa) {
		pessoa.setEstado(new FinalizadaVacinacao());
		return "Segunda dose tomada. Vacinação completa!";
	}
}
