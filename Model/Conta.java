package Model;

import Utils.Utils;

public class Conta {
private static int accountCounter = 1;

public int numeroConta;
private Pessoa pessoa; //Pessoa da classe Pessoa criada no mesmo pacote
private Double saldo = 0.0;

public Conta(Pessoa pessoa) {
this.numeroConta = Conta.accountCounter;
this.pessoa = pessoa;
this.updateSaldo();
Conta.accountCounter += 1;
}

public Pessoa getPessoa() {
return pessoa;
}

public Double getSaldo() {
return saldo;
}

public void setPessoa(Pessoa pessoa) {
this.pessoa = pessoa;
}

public void setSaldo(Double saldo) {
this.saldo = saldo;
}

private void updateSaldo() {
this.saldo = this.getSaldo();
}

public int getNumeroConta() {
return numeroConta;
}

public String toString() {
return "\nBank account: " + this.getNumeroConta() +
"\nCliente: " + this.pessoa.getName() +
"\nCPF: " + this.pessoa.getCPF() +
"\nEmail : " + this.pessoa.getEmail() +
"\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
"\n";
}

//Funções/Métodos

public void depositar(Double valor) {
if(valor > 0) {
setSaldo(getSaldo() + valor);
System.out.println("Seu depósito foi realizadoo com sucesso!");
}
else {
System.out.println("Não foi possível realizar o depósito!");
}
}

public void sacar(Double valor) {
if(valor > 0 && this.getSaldo() >= valor) {
setSaldo(getSaldo() - valor);
System.out.println("Saque realizado com sucesso!");
}
else {
System.out.println("Não foi possível realizar o saque");
}
}

public void transferencia(Conta contaParaDeposito, Double valor) {
if(valor > 0 && this.getSaldo() >= valor) {
setSaldo(getSaldo() - valor);
System.out.println("Transferência realizada!");
}
else {
System.out.println("A fiel não deixou depositar");
}
}

}
