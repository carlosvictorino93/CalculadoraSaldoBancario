package br.com.letscode.Models;

import br.com.letscode.Enums.Movimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operacao implements Comparable<Operacao> {
    private LocalDateTime dataHoraOperacao;
    private String operador;
    private Movimento tipo;
    private double valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operacao operacao = (Operacao) o;
        return Double.compare(operacao.valor, valor) == 0 && Objects.equals(dataHoraOperacao, operacao.dataHoraOperacao) && Objects.equals(operador, operacao.operador) && tipo == operacao.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataHoraOperacao, operador, tipo, valor);
    }

    @Override
    public int compareTo(Operacao op) {
        return this.dataHoraOperacao.compareTo(op.getDataHoraOperacao());
    }

    @Override
    public String toString() {
        return "Data: " + dataHoraOperacao +
                ", Operador: " + operador +
                ", Tipo: " + tipo +
                ", Valor: $" + valor +
                '\n';
    }
}
