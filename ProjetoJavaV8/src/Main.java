import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Projeto Java V8");

		Scanner stdIn = new Scanner(System.in);
		Cliente cliente = new Cliente();

		int opcao = 0;
		/*
		 * Menu de op��es
		 */
		do {                                          
			System.out.println("\n");
			System.out.println(" SEJA BEM VINDO!");
			System.out.println("#-------------------------------------------#");
			System.out.println("| Por favor, insira a op��o:                |");
			System.out.println("| 1 - Cliente:                              |");
			System.out.println("| 0 - Sair                                  |");
			System.out.println("#-------------------------------------------#");
			System.out.println("  Op��o:                                     ");

			opcao = stdIn.nextInt();
			switch (opcao) {
			case 1:
				cliente.opcaoCliente();
				break;
			case 0:
				break;
			default:
				System.out.println("Op��o Inv�lida");
				break;
			}
		} while (opcao != 0);

	}
}
