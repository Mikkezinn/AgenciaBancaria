package Main;

import java.util.ArrayList;
import java.util.Scanner;
import Model.Pessoa;
import Model.Conta;

public class AgenciaBancaria {
	
	 static Scanner input = new Scanner(System.in);
	    static ArrayList<Conta> ContasBancarias;

	    public static void main(String[] args) {
	        ContasBancarias = new ArrayList<Conta>();
	        Operacoes();
	    }

	    public static void Operacoes() {

	        System.out.println("------------------------------------------------------");
	        System.out.println("-------------Bem vindos a nossa Agência---------------");
	        System.out.println("------------------------------------------------------");
	        System.out.println("***** Selecione uma operação que deseja realizar *****");
	        System.out.println("------------------------------------------------------");
	        System.out.println("|   Opção 1 - Criar conta   |");
	        System.out.println("|   Opção 2 - Depositar     |");
	        System.out.println("|   Opção 3 - Sacar         |");
	        System.out.println("|   Opção 4 - Transferir    |");
	        System.out.println("|   Opção 5 - Listar        |");
	        System.out.println("|   Opção 6 - Sair          |");

	        int Operacao = input.nextInt();;

	        switch (Operacao) {
	            case 1:
	                CriarConta();
	                break;

	            case 2:
	                Depositar();
	                break;

	            case 3:
	                Sacar();
	                break;

	            case 4:
	                Transferir();
	                break;

	            case 5:
	                ListarContas();
	                break;

	            case 6:
	                System.out.println("Até mais jovem gafanhoto!");
	                System.exit(0); // para o sistema

	            default:
	                System.out.println("Opção inválida!");
	                Operacoes();
	                break;
	        }
	    }

	    public static void CriarConta() {
	        //System.out.println("Você está criando uma conta\n");

	        System.out.println("\nNome: ");
	        String Nome = input.next();

	        System.out.println("\nCPF: ");
	        String CPF = input.next();

	        System.out.println("Email: ");
	        String Email = input.next();

	        Pessoa Cliente = new Pessoa(Nome, CPF, Email);

	        Conta Conta = new Conta(Cliente);

	        ContasBancarias.add(Conta);
	        System.out.println("--- Sua conta foi criada com sucesso! ---");

	        Operacoes();

	    }

	    private static Conta EncontrarConta(int NumeroConta) {
	        Conta Conta = null;
	        if(ContasBancarias.size() > 0) {
	            for(Conta Contaa : ContasBancarias) {
	                if(Contaa.getNumeroConta() == NumeroConta) {
	                    Conta = Contaa;
	                }
	            }
	        }
	        return Conta;
	    }

	    public static void Depositar() {
	        System.out.println("Número da conta: ");
	        int NumeroConta = input.nextInt();
	        Conta Conta = EncontrarConta(NumeroConta);

	        if(Conta != null) {
	            System.out.println("Qual valor deseja depositar? ");
	            Double ValorDeposito = input.nextDouble();

	            Conta.depositar(ValorDeposito);
	        }else {
	            System.out.println("--- Conta não encontrada ---");
	        }

	        Operacoes();

	    }

	    public static void Sacar() {
	        System.out.println("Número da conta: ");
	        int NumeroConta = input.nextInt();

	        Conta Conta = EncontrarConta(NumeroConta);

	        if(Conta != null) {
	            System.out.println("Qual valor deseja sacar? ");
	            Double ValorSaque = input.nextDouble();

	            Conta.sacar(ValorSaque);
	            System.out.println("--- Saque realizado com sucesso! ---");
	        }else {
	            System.out.println("--- Conta não encontrada ---");
	        }

	        Operacoes();

	    }

	    public static void Transferir() {
	        System.out.println("Número da conta que vai enviar a transferência: ");
	        int NumeroContaRemetente = input.nextInt();

	        Conta ContaRemetente = EncontrarConta(NumeroContaRemetente);

	        if(ContaRemetente != null) {
	            System.out.println("Número da conta do destinatário: ");
	            int NumeroContaDestinatario = input.nextInt();

	            Conta ContaDestinatario = EncontrarConta(NumeroContaDestinatario);

	            if(ContaDestinatario != null) {
	                System.out.println("Valor da transferência: ");
	                Double Valor = input.nextDouble();

	                ContaRemetente.transferencia(ContaDestinatario, Valor);

	            }else {
	                System.out.println("--- A conta para depósito não foi encontrada ---");
	            }

	        }else {
	            System.out.println("--- Conta para transferência não encontrada ---");
	        }
	        Operacoes();
	    }

	    public static void ListarContas() {
	        if(ContasBancarias.size() > 0) {
	            for(Conta Conta: ContasBancarias) {
	                System.out.println(Conta);
	            }
	        }else {
	            System.out.println("--- Nenhuma conta no Registro! ---");
	        }

	        Operacoes();
	    }
	}


