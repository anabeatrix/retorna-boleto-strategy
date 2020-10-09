package com.dev;

import java.util.List;

/**
 * @author anabeatriz
 * Baseado no projeto disponível em:
 * https://manoelcampos.com/padroes-projetos/comportamentais/strategy/retorno-boleto/
 */
public class ProcessarBoletos {

    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo) {
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        boletos.forEach(boleto -> System.out.println("ID: " + boleto.getId() + " | Banco: "
                + boleto.getCodBanco() + " | CPF Cliente: "
                + boleto.getCpfCliente()));
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
