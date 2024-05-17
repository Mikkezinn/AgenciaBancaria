package Model;

import Utils.Utils;

public class Conta {
    private static int accountCounter = 1;

    public int numeroConta;
    private Pessoa Pessoa; 

    public Conta(Pessoa Pessoa) {
        this.numeroConta = Conta.accountCounter;
        this.Pessoa = Pessoa;
        Conta.accountCounter += 1;
    }

    public Pessoa getPessoa() {
        return Pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setPessoa(Pessoa pessoa) {
        this.Pessoa = pessoa;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String toString() {
        return "\nBank account: " + this.getNumeroConta() +
                "\nCliente: " + this.Pessoa.getName() +
                "\nCPF: " + this.Pessoa.getCPF() +
                "\nEmail: " + this.Pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    // Funções/Métodos

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque");
        }
    }

    public void transferencia(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            this.sacar(valor);
            contaParaDeposito.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }
}
