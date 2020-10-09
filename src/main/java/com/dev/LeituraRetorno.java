package com.dev;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author anabeatriz
 * Baseado no projeto disponível em:
 * https://manoelcampos.com/padroes-projetos/comportamentais/strategy/retorno-boleto/
 */

public interface LeituraRetorno {

    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    List<Boleto> lerArquivo(String nomeArquivo) ;
}

