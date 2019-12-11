import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

	Conta conta = new Conta();
	Scanner stdIn = new Scanner(System.in);
	ArrayList clientes = new ArrayList();
	String resposta = "";
	int codigo = 100;
	boolean existeCliente = false;
	String procuraDado = "";
	String x = "";
	String auxProcuraDado = "";
	String busca = "";
	int opcao = 0;
	String indicaMudanca = "";

	/* Menu de opções para a classe cliente
	 * Na craição do cliente e no pedido de informações a Classe Cliente chama automaticamente o Calsse Conta
	 * Nas demais opções apenas verifica se o cliente existe e então chama a Classe Conta
	 */
	public void opcaoCliente() {    
		int opcao = 0;			
		do {
			System.out.println("\n");
			System.out.println("#-------------------------------------------#");
			System.out.println("| Por favor, insira a opção:                |");
			System.out.println("| 1 - Novo Cliente:                         |");
			System.out.println("| 2 - Informações sobre o Cliente:          |");
			System.out.println("| 3 - Mudar informações do Cliente:         |");
			System.out.println("| 4 - Contas do Cliente:                    |");
			System.out.println("| 0 - Sair                                  |");
			System.out.println("#-------------------------------------------#");
			System.out.println("  Opção:                                     ");
			opcao = stdIn.nextInt();
			switch (opcao) {
			case 1:
				criaCliente();
				break;
			case 2:
				informacoesCliente();
				break;
			case 3:
				mudarInformaçãoCliente();
				break;
			case 4:
				verificaExisteClienteParaContas();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		} while (opcao != 0);

	}

	public void criaCliente() {

		// Codigos para busca nas contas 
		String nome = "nO";
		String telefone = "tO";
		String email = "eO";
		String profissao = "pO";
        // -------------------------------
		/*Cria um codigo de identificação unica para cada cliente
		 * Adiciona ao cliente somente as informações pessoais - Nome , telefone, email e profissão
		 * Em seguida chama a Classe Conta e complemente os dados de contas bancarias e gestor de contas
		 */
		codigo++;										
		stdIn.nextLine();
		System.out.println("Nome do cliente:");
		resposta = stdIn.nextLine().toUpperCase();
		;
		clientes.add(codigo + nome + resposta);
		System.out.println("Telefone do cliente:");
		resposta = stdIn.nextLine().toUpperCase();
		;
		clientes.add(codigo + telefone + resposta);
		System.out.println("Email do cliente:");
		resposta = stdIn.nextLine().toUpperCase();
		;
		clientes.add(codigo + email + resposta);
		System.out.println("Profissão do cliente:");
		resposta = stdIn.nextLine().toUpperCase();
		;
		clientes.add(codigo + profissao + resposta);

		conta.setCodigo(codigo);

		conta.criaConta();

	}

	public void informacoesCliente() {
		/*Mostra as informações completas dos clientes
		 * Após imprimir as informações pessoais dos clientes, chama a classe Conta para imprimir os dados bancarios
		 */
		existeCliente = false;
		System.out.println("Por favor, insira o Número da conta ou Nome:");
		resposta = "";
		stdIn.nextLine();
		resposta = stdIn.nextLine().toUpperCase();

		for (int i = 0; i < clientes.size(); i++) {
			procuraDado = (String) clientes.get(i);
			String y = "nO" + resposta;
			if (procuraDado.substring(0, 3).equals(resposta)
					|| procuraDado.substring(3, procuraDado.length()).equals(y)) {
				existeCliente = true;

			}
			if (existeCliente == true && resposta.equals(procuraDado.substring(0, 3))) {
				busca = resposta;
				break;
			}
			if (existeCliente == true && !resposta.equals(procuraDado.substring(0, 3))) {
				busca = procuraDado.substring(0, 3);
				break;
			}
		}

		if (existeCliente == true) {
			for (int i = 0; i < clientes.size(); i++) {
				procuraDado = (String) clientes.get(i);
				if (procuraDado.contains(busca)) {
					auxProcuraDado = procuraDado.substring(0, 5);

					if (auxProcuraDado.contains("n")) {
						procuraDado = procuraDado.substring(5);
						System.out.println("Nome do Cliente: " + procuraDado);
					}
					if (auxProcuraDado.contains("t")) {
						procuraDado = procuraDado.substring(5);
						System.out.println("Telefone do Cliente: " + procuraDado);
					}
					if (auxProcuraDado.contains("e")) {
						procuraDado = procuraDado.substring(5);
						System.out.println("Email do Cliente: " + procuraDado);
					}
					if (auxProcuraDado.contains("p")) {
						procuraDado = procuraDado.substring(5);
						System.out.println("Profissão do Cliente: " + procuraDado);
					}

				}
			}
			conta.setResposta(busca);
			conta.informacoesConta();
		} else {
			System.out.println("Cliente não encontrado!");
		}
	}

	public void mudarInformaçãoCliente() {
		/*
		 * Muda somente uma informação pessoal do cliente
		 */
		resposta = "";
		System.out.println("Por favor, insira o Número da conta ou Nome:");
		stdIn.nextLine();
		resposta = stdIn.nextLine().toUpperCase();
		;

		for (int i = 0; i < clientes.size(); i++) {
			procuraDado = (String) clientes.get(i);
			String y = "nO" + resposta;
			if (procuraDado.substring(0, 3).equals(resposta)
					|| procuraDado.substring(3, procuraDado.length()).equals(y)) {
				existeCliente = true;
			}
			if (existeCliente == true && resposta.equals(procuraDado.substring(0, 3))) {
				busca = resposta;
				break;
			}
			if (existeCliente == true && !resposta.equals(procuraDado.substring(0, 3))) {
				busca = procuraDado.substring(0, 3);
				break;
			}
		}
		if (existeCliente == true) {

			System.out.println("Por favor, indique qual informação gostaria de mudar:");

			do {
/*
 * Apresenta e pergunta qual informação deseja alterar
 */
				System.out.println("\n");
				System.out.println("#-------------------------------------------#");
				System.out.println("| 1 - Nome:                                 |");
				System.out.println("| 2 - Telefone:                             |");
				System.out.println("| 3 - Email:                                |");
				System.out.println("| 4 - Profissão:                            |");
				System.out.println("| 0 - Sair                                  |");
				System.out.println("#-------------------------------------------#");
				System.out.println("  Opção:                                     ");
				opcao = stdIn.nextInt();

				switch (opcao) {
				case 1:
					x = "nO";
					indicaMudanca = "o novo Nome:";
					auxiliarmudarInformaçãoCliente();
					break;
				case 2:
					x = "tO";
					indicaMudanca = "o novo Telefone:";
					auxiliarmudarInformaçãoCliente();
					break;
				case 3:
					x = "eO";
					indicaMudanca = "o novo Email:";
					auxiliarmudarInformaçãoCliente();
					break;
				case 4:
					x = "pO";
					indicaMudanca = "a nova Profissão:";
					auxiliarmudarInformaçãoCliente();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}
			} while (opcao != 0);
		}

		else {
			System.out.println("Cliente não encontrado!");

		}
	}

	/*
	 * Auxilia o método mudarInformaçãoCliente()
	 */
	public void auxiliarmudarInformaçãoCliente() {
		if (existeCliente == true) {
			for (int i = 0; i < clientes.size(); i++) {
				procuraDado = (String) clientes.get(i);
				if (procuraDado.contains(busca)) {
					auxProcuraDado = procuraDado.substring(0, 5);

					if (auxProcuraDado.contains(x)) {
						procuraDado = procuraDado.substring(0, 5);
						System.out.println("Por favor, insira " + indicaMudanca);
						stdIn.nextLine();
						resposta = stdIn.nextLine();
						clientes.remove(i);
						clientes.add(i, procuraDado + resposta);
						existeCliente = false;
						System.out.println("Informação alterada com sucesso!");
						opcao = 0;
					}
				}
			}

		}

	}

	/*
	 * Verifica se existe o cliente e então faz a chamada da Classe Conta
	 */
	public void verificaExisteClienteParaContas() {
		existeCliente = false;
		System.out.println("Por favor, insira o Número da conta ou seu Nome:");
		resposta = "";
		stdIn.nextLine();
		resposta = stdIn.nextLine().toUpperCase();

		for (int i = 0; i < clientes.size(); i++) {
			procuraDado = (String) clientes.get(i);
			String y = "nO" + resposta;
			if (procuraDado.substring(0, 3).equals(resposta)
					|| procuraDado.substring(3, procuraDado.length()).equals(y)) {
				existeCliente = true;

			}
			if (existeCliente == true && resposta.equals(procuraDado.substring(0, 3))) {
				busca = resposta;
				break;
			}
			if (existeCliente == true && !resposta.equals(procuraDado.substring(0, 3))) {
				busca = procuraDado.substring(0, 3);
				break;
			}
		}
		if (existeCliente == true) {
			conta.setResposta(busca);
			conta.opcaoConta();
		} else {
			System.out.println("Cliente não encontrado!");
		}
	}
}
