package Tdd.Senha;
import java.util.List;

public class ResultadoValidacao {
    private final boolean valida;
    private final List<String> erros;

    public ResultadoValidacao(boolean valida, List<String> erros) {
        this.valida = valida;
        this.erros = erros;
    }

    public boolean isValida() {
        return valida;
    }

    public List<String> getErros() {
        return erros;
    }
}