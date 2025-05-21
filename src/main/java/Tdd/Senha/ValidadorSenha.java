package Tdd.Senha;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public ResultadoValidacao validarSenha(String senha) {
        List<String> erros = new ArrayList<>();

        if (!temComprimentoMinimo(senha)) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }

    private boolean temComprimentoMinimo(String senha) {
        return senha.length() >= 8;
    }

}