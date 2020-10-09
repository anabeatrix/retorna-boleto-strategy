import com.dev.LeituraRetorno;
import com.dev.LeituraRetornoBB;
import com.dev.ProcessarBoletos;

public class Principal {
    public static void main(String[] args) {
        LeituraRetorno leituraRetornoBB = new LeituraRetornoBB();
        ProcessarBoletos processarBoleto = new ProcessarBoletos(leituraRetornoBB);

        String nomeArquivo = "banco-brasil-1.csv";
        processarBoleto.processar(nomeArquivo);

        nomeArquivo = "bradesco-1.csv";
        processarBoleto.processar(nomeArquivo);
    }
}
