package com.dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anabeatriz
 * Baseado no projeto disponível em:
 * https://manoelcampos.com/padroes-projetos/comportamentais/strategy/retorno-boleto/
 */

public class LeituraRetornoBB implements LeituraRetorno {

    List<Boleto> listaBB = new ArrayList<>();

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] vetor = linha.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], LeituraRetorno.FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], LeituraRetorno.FORMATO_DATA).atTime(0, 0, 0));

                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));
                listaBB.add(boleto);
            }
            return listaBB;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
