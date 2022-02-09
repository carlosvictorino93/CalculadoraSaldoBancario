package br.com.letscode;

import br.com.letscode.Enums.Movimento;
import br.com.letscode.Models.Conta;
import br.com.letscode.Models.Operacao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) {

        Map<String, Conta> contas = new HashMap<String, Conta>();
        String path = ".\\src\\main\\java\\br\\com\\letscode\\Files\\";

        // Leitura e Processamento dos Dados
        try {
            List<String> lines = Files.readAllLines(Paths.get(path + "Input\\operacoes.csv"));
            lines.remove(0);
            for (String line : lines) {
                String[] dados = line.split(",");

                LocalDateTime data = LocalDateTime.parse(dados[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                String operador = dados[5];
                Movimento mv = Movimento.valueOf(dados[6]);
                double valor = Double.parseDouble(dados[7]);
                Operacao op = new Operacao(data, operador, mv, valor);

                String id = dados[1];

                if (contas.get(id) == null) {
                    String banco = dados[2];
                    String numAgencia = dados[3];
                    String numConta = dados[4];
                    Conta newConta = new Conta(banco, numAgencia, numConta);
                    contas.put(id, newConta);
                }
                contas.get(id).getOperacoes().add(op);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Escrita dos Arquivos Finais
        contas.entrySet().forEach(ct -> {
            try {
                String content = "ContaId: " + ct.getKey() + "\n" + ct.getValue().toString();
                Files.write(Paths.get(path + "Output\\" + ct.getKey() +".txt"), Arrays.asList(content),
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE);
            } catch (IOException ex) {
                        ex.printStackTrace();
                 }
            });
        }
    }
