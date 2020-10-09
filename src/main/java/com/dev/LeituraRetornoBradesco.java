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

public class LeituraRetornoBradesco implements LeituraRetorno {


    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        List<Boleto> listaBradesco = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] vetor = linha.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], LeituraRetorno.FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[5], LeituraRetorno.FORMATO_DATA_HORA).atTime(0, 0, 0));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));
                listaBradesco.add(boleto);
            }
            return listaBradesco;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
