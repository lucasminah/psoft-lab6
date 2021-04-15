import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Governo governo = new Governo();

		System.out.println("Boas vindas ao sistema de vacinação contra o COVID-19");
		while (true) {
			System.out.println("");
			System.out.println("-----------------------------------------------------");
			System.out.println("O que deseja fazer?");
			System.out.println("1 - Atualizar requisitos para a primeira dose");
			System.out.println("2 - Cadastrar uma pessoa");
			System.out.println("3 - Atualizar o cadastro de uma pessoa");
			System.out.println("4 - Remover o cadastro de uma pessoa");
			System.out.println("5 - Selecionar uma pessoa (para verificar a situação ou tomar nova dose)");
			System.out.println("6 - Avançar 20 dias");
			System.out.println("");
			int resposta = Integer.parseInt(sc.nextLine());
			switch (resposta) {
				case 1:
					int idadeMinima;
					List<String> profissoesQualificadas, comorbidadesQualificadas;
					System.out.print("Profissões que garantem qualificação (separar por vírgula): ");
					profissoesQualificadas = new ArrayList<String>(Arrays.asList(sc.nextLine().split(",")));

					System.out.print("Comorbidades que garantem qualificação (separar por vírgula): ");
					comorbidadesQualificadas = new ArrayList<String>(Arrays.asList(sc.nextLine().split(",")));

					System.out.print("Idade mínima para garantir qualificação: ");
					idadeMinima = Integer.parseInt(sc.nextLine());

					governo.atualizarRequisitos(profissoesQualificadas, comorbidadesQualificadas, idadeMinima);

					System.out.println("");
					System.out.println("Requisitos atualizados.");
					break;
				case 2:
					Pessoa pessoa;
					String nomeCompleto, cpf, numeroCartaoSUS, email, telefone, profissao;
					int idade;
					List<String> comorbidades;

					System.out.print("Nome completo: ");
					nomeCompleto = sc.nextLine();

					System.out.print("Idade: ");
					idade = Integer.parseInt(sc.nextLine());

					System.out.print("CPF: ");
					cpf = sc.nextLine();

					System.out.print("Número do cartão do SUS: ");
					numeroCartaoSUS = sc.nextLine();

					System.out.print("E-mail: ");
					email = sc.nextLine();

					System.out.print("Telefone: ");
					telefone = sc.nextLine();

					System.out.print("Profissão: ");
					profissao = sc.nextLine();

					System.out.print("Comorbidades (separar por vírgula): ");
					comorbidades = new ArrayList<String>(Arrays.asList(sc.nextLine().split(",")));

					governo.cadastraPessoa(cpf, nomeCompleto, numeroCartaoSUS, email, telefone, profissao, comorbidades,
							idade);

					System.out.println("");
					System.out.println("Cadastro concluído. Sua situação atual é: "
							+ governo.getPessoa(cpf).getEstado().toString());
					break;
				case 3:
					String cpfAtualizar;
					String nomeCompletoNovo, numeroCartaoSUSNovo, emailNovo, telefoneNovo, profissaoNova;
					int idadeNova;
					List<String> comorbidadesNovas;

					System.out.print("CPF da pessoa a ter o cadastro atualizado: ");
					cpfAtualizar = sc.nextLine();

					System.out.println("Preencha os campos a seguir com os dados mais recentes.");
					System.out.print("Nome completo: ");
					nomeCompletoNovo = sc.nextLine();

					System.out.print("Idade: ");
					idadeNova = Integer.parseInt(sc.nextLine());

					System.out.print("Número do cartão do SUS: ");
					numeroCartaoSUSNovo = sc.nextLine();

					System.out.print("E-mail: ");
					emailNovo = sc.nextLine();

					System.out.print("Telefone: ");
					telefoneNovo = sc.nextLine();

					System.out.print("Profissão: ");
					profissaoNova = sc.nextLine();

					System.out.print("Comorbidades (separar por vírgula): ");
					comorbidadesNovas = new ArrayList<String>(Arrays.asList(sc.nextLine().split(",")));

					governo.alteraPessoa(cpfAtualizar, nomeCompletoNovo, numeroCartaoSUSNovo, emailNovo, telefoneNovo,
							profissaoNova, comorbidadesNovas, idadeNova);

					System.out.println("");
					System.out.println("Dados atualizados. Sua situação atual é: "
							+ governo.getPessoa(cpfAtualizar).getEstado().toString());
					break;
				case 4:
					String cpfRemover;

					System.out.print("CPF da pessoa a ter o cadastro removido: ");
					cpfRemover = sc.nextLine();

					governo.removePessoa(cpfRemover);

					System.out.println("");
					System.out.println("Cadastro removido.");
					break;
				case 5:
					String cpfAcompanhar;

					System.out.print("CPF da pessoa a ser selecionada: ");
					cpfAcompanhar = sc.nextLine();

					Pessoa pessoaSelecionada = governo.getPessoa(cpfAcompanhar);

					System.out.println("Selecionado o cadastro de " + pessoaSelecionada.getNomeCompleto());
					System.out.println("O que deseja fazer?");
					System.out.println("1 - Verificar a situação");
					System.out.println("2 - Tomar a dose seguinte");
					System.out.println("");

					int resposta2 = Integer.parseInt(sc.nextLine());
					switch (resposta2) {
						case 1:
							System.out.println("");
							System.out.println("A situação atual é: " + pessoaSelecionada.getEstado().toString());
							break;
						case 2:
							System.out.println("");
							System.out.println(pessoaSelecionada.tomarDose());
							break;
					}
					break;
				case 6:
					governo.avancar20Dias();
					System.out.println("");
					System.out.println("20 dias passaram...");
					break;
			}
		}
	}
}
