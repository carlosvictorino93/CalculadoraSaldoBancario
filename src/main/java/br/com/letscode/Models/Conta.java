package br.com.letscode.Models;

import br.com.letscode.Enums.Movimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conta {
    private String nomeBanco;
    private String numAgencia;
    private String numConta;
    private Set<Operacao> operacoes = new TreeSet<Operacao>() ;

    public Conta(String nomeBanco, String numAgencia, String numConta) {
        this.nomeBanco = nomeBanco;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
    }

    @Override
    public String toString() {
        String opers = "Saldo Inicial: $ 0,00\n";
        for (Operacao op : this.operacoes) {
            opers += (op.toString());
        }
        opers += ("Saldo Final: $" + this.getSaldo());
        return "Banco: " + nomeBanco + "\n" +
                "Numero da Agencia: " + numAgencia + "\n" +
                "Numero da Conta: " + numConta + "\n\n" +
                "EXTRATO: " + "\n\n" + opers;
    }

    public double getSaldo() {
        double saldo = 0;
        for (Operacao  op : this.operacoes) {
            double valor = op.getValor();
            saldo += op.getTipo() == Movimento.DEPOSITO ? valor : -valor;
        }
        return saldo;
    }
}
