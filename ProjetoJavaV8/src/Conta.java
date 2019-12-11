import java.util.ArrayList;
import java.util.Scanner;

public class Conta {

	Scanner stdIn = new Scanner(System.in);
	ArrayList contas = new ArrayList();
	String resposta = "";
	String procuraDado = "";
	String auxProcuraDado = "";
	String busca = "";
	Double valorAtualDeposito = 0.0;
	Double valorAtualTransferencia = 0.0;
	Double respostaValor = 0.0;
	boolean existeContaPoupan�a = false;
	int poicaoContaPoupanca = 0;
	int posicaoContaOrdem = 0;
	int numeroContaPoupanca = 0;
	int opcao = 0;
	int codigo = 0;
	int contaContaPoupanca = 0;
	int escolheContaPoupanca = 0;
	boolean okcontaPoupanca = false;
	Double valorContaOrdemTransferir = 0.0;

	public void opcaoConta() {
		/*
		 * Menu de op��es
		 */
		opcao = 0;
		do {
			System.out.println("\n");
			System.out.println("#--------------------------------------------------#");
			System.out.println("| Por favor, insira a op��o:                       |");
			System.out.println("| 1 - Levantamento da Conta Ordem:                 |");
			System.out.println("| 2 - Dep�sito na conta Ordem:                     |");
			System.out.println("| 3 - Cria conta Poupan�a:                         |");
			System.out.println("| 4 - Transfer�ncia entre contas do mesmo Cliente: |");
			System.out.println("| 0 - Sair                                         |");
			System.out.println("#--------------------------------------------------#");
			System.out.println("  Op��o:                                            ");
			opcao = stdIn.nextInt();
			switch (opcao) {
			case 1:
				levantamento();
				break;
			case 2:
				deposito();
				break;
			case 3:
				criarContaPoupan�a();
				break;
			case 4:
				transferenciaParaContaPoupanca();
				break;
			case 0:
				break;
			default:
				System.out.println("Op��o Inv�lida");
				break;
			}
		} while (opcao != 0);
	}

	public void criaConta() {
		/*
		 * Complementa as informa��es que inicialmente foram criadas na Classe Cliente
		 */
		
		// Codigos para busca nas contas
		String contaOrdem = "c1";
		String contaPoupanca = "d1";
		String gestor = "g1";
		String contaInvestimento = "i1";

		contas.add(this.codigo + contaOrdem + 0);
		System.out.println("Deseja criar uma Conta Poupan�a? S/N");
		resposta = stdIn.nextLine();
		if (resposta.toUpperCase().equals("S")) {
			contas.add(this.codigo + contaPoupanca + 0);
		}
		System.out.println("Ser� um Cliente VIP? S/N");
		resposta = stdIn.nextLine();
		if (resposta.toUpperCase().equals("S")) {
			System.out.println("Qual o nome do Gestor?");
			resposta = stdIn.nextLine();
			contas.add(this.codigo + gestor + resposta);
			contas.add(this.codigo + contaInvestimento + 0);
		}

		System.out.println("Cliente criado com sucesso!");
		System.out.println("O n�mero de sua conta �: " + codigo);
		System.out.println("Este c�digo ser� necess�rio para acessar sua conta novamente");
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void informacoesConta() {
		/*
		 * Imprimi as informa��es que inicialmente foram criadas na Classe Cliente
		 */
		for (int i = 0; i < contas.size(); i++) {
			procuraDado = (String) contas.get(i);
			if (procuraDado.contains(this.resposta)) {
				auxProcuraDado = procuraDado.substring(0, 5);

				if (auxProcuraDado.contains("c")) {
					procuraDado = procuraDado.substring(5);
					System.out.println("Saldo da conta Ordem: $" + procuraDado);
				}
				if (auxProcuraDado.contains("d")) {
					numeroContaPoupanca = Integer.parseInt(procuraDado.substring(4, 5));
					procuraDado = procuraDado.substring(5);
					System.out.println("Saldo da Conta Poupan�a " + numeroContaPoupanca + " : $" + procuraDado);
				}
				if (auxProcuraDado.contains("g")) {
					procuraDado = procuraDado.substring(5);
					System.out.println("Nome do Gestor de contas: " + procuraDado);
				}
				if (auxProcuraDado.contains("i")) {
					procuraDado = procuraDado.substring(5);
					System.out.println("Saldo da conta de Investimento: $" + procuraDado);
				}

			}

		}
		this.resposta = "";
		opcao = 0;
	}

	public void levantamento() {
		/*
		 * Ap�s ser verificado se existe o cliente � feito o procedimento de levantamento na conta ordem
		 */
		for (int i = 0; i < contas.size(); i++) {
			procuraDado = (String) contas.get(i);
			if (procuraDado.contains(this.resposta)) {
				auxProcuraDado = procuraDado.substring(0, 5);

				if (auxProcuraDado.contains("c")) {
					auxProcuraDado = procuraDado.substring(5);
					System.out.println("Por favor, insira o valor que deseja levantar:");
					respostaValor = stdIn.nextDouble();
					valorAtualDeposito = Double.parseDouble(auxProcuraDado) - respostaValor;
					if (valorAtualDeposito > 0) {
						contas.remove(i);
						contas.add(i, procuraDado.substring(0, 5) + valorAtualDeposito);
						System.out.println("Levantamento realizado com sucesso!");
						break;
					} else {
						System.out.println("Saldo indispon�vel na conta!");
					}

				}
			}
		}
		opcao = 0;
	}

	public void deposito() {
		/*
		 * Ap�s ser verificado se existe o cliente � feito o procedimento de dep�sito na conta ordem
		 */
		for (int i = 0; i < contas.size(); i++) {
			procuraDado = (String) contas.get(i);
			if (procuraDado.contains(this.resposta)) {
				auxProcuraDado = procuraDado.substring(0, 5);

				if (auxProcuraDado.contains("c")) {
					auxProcuraDado = procuraDado.substring(5);
					System.out.println("Por favor, insira o valor que deseja depositar:");
					respostaValor = stdIn.nextDouble();
					valorAtualDeposito = Double.parseDouble(auxProcuraDado) + respostaValor;
					contas.remove(i);
					contas.add(i, procuraDado.substring(0, 5) + valorAtualDeposito);
					System.out.println("Dep�sito realizado com sucesso!");
					break;
				}
			}
		}
		opcao = 0;
	}

	public void transferenciaParaContaPoupanca() {
		/*
		 * Ap�s ser verificado se existe o cliente � feito o procedimento de trasnferencia da conta ordem para uma conta poupan�a
		 */
		contaContaPoupanca = 0;
		for (int i = 0; i < contas.size(); i++) {
			procuraDado = (String) contas.get(i);
			if (procuraDado.contains(this.resposta) && procuraDado.contains("d")) {
				contaContaPoupanca++;
			}
		}
		/*
		 * Verifica se h� nenhum, uma ou mais contas Poupan�a
		 */
		if (contaContaPoupanca > 0) {
			System.out.println("Selecione para qual conta ser� feita a transferencia: ");
				System.out.println("#------------------------------------#");
			for (int j = 1; j <= contaContaPoupanca; j++) {

				System.out.println("| " + j + " - Conta Poupan�a " + j + "                |");
			}
				System.out.println("#------------------------------------#");
				System.out.println(" Op��o: ");
			do {
				if (contaContaPoupanca >= 1) {
					escolheContaPoupanca = stdIn.nextInt();
					if (escolheContaPoupanca > contaContaPoupanca) {
						System.out.println("N�mero inv�lido!");
					} else {
						boolean ok = true;
					}
				}
			} while (okcontaPoupanca = false);

			for (int i = 0; i < contas.size(); i++) {
				procuraDado = (String) contas.get(i);
				if (procuraDado.contains(this.resposta)) {
					auxProcuraDado = procuraDado.substring(0, 5);

					if (auxProcuraDado.contains(this.resposta + "c")) {
						posicaoContaOrdem = i;
						valorContaOrdemTransferir = Double.parseDouble(procuraDado.substring(5));
					}
					String juntaCodigoPoupanca = "d" + escolheContaPoupanca;
					if (auxProcuraDado.contains(juntaCodigoPoupanca)) {
						auxProcuraDado = procuraDado.substring(5);
						System.out.println("Por favor, insira o valor que deseja Transferir:");
						respostaValor = stdIn.nextDouble();

						valorAtualTransferencia = valorContaOrdemTransferir - respostaValor; // valor que continua na
																								// conta ordem
						if (valorAtualTransferencia > 0) {
							contas.remove(posicaoContaOrdem);
							contas.add(posicaoContaOrdem, this.resposta + "c1" + valorAtualTransferencia);
							contas.remove(i);
							double somaPoupanca = Double.parseDouble(auxProcuraDado) + respostaValor;
							contas.add(i, procuraDado.substring(0, 5) + somaPoupanca);
							System.out.println("Transfer�ncia realizada com sucesso!");
							break;
						} else {
							System.out.println("Saldo insuficiente para Transferencia!");
							break;
						}

					}
				}
			}
		} else {
			System.out.println("N�o foi encontrado nenhuma Conta Poupan�a deste cliente!");
		}
		opcao = 0;

	}

	public void criarContaPoupan�a() {
		/*
		 * Ap�s ser verificado se existe o cliente � feito o procedimento de cria��o de uma conta Poupan�a
		 */
		for (int i = 0; i < contas.size(); i++) {
			procuraDado = (String) contas.get(i);
			if (procuraDado.contains(this.resposta + "d")) {
				existeContaPoupan�a = true;
				break;
			}
		}
		if (existeContaPoupan�a == false) {
			for (int i = 0; i < contas.size(); i++) {
				procuraDado = (String) contas.get(i);
				if (procuraDado.contains(this.resposta + "c1")) {
					contas.add(i + 1, this.resposta + "d1" + 0);
					System.out.println("Conta Poupan�a " + 1 + " criada com sucesso!");
				}
			}
		}
		if (existeContaPoupan�a == true) {
			boolean achouContaPoupan�a = false;
			for (int i = 0; i < contas.size(); i++) {
				procuraDado = (String) contas.get(i);
				if (procuraDado.contains(this.resposta + "d")) {
					numeroContaPoupanca = Integer.parseInt(procuraDado.substring(4, 5));
					achouContaPoupan�a = true;
					poicaoContaPoupanca = i;
				}
			}
			if (achouContaPoupan�a == true) {
				numeroContaPoupanca += 1;
				contas.add(poicaoContaPoupanca + 1, this.resposta + "d" + numeroContaPoupanca + "" + 0);
				System.out.println("Conta Poupan�a " + numeroContaPoupanca + " criada com sucesso!");
			}
		}
		opcao = 0;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
