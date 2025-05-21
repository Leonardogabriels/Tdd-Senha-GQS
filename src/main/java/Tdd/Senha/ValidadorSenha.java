package Tdd.Senha;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public ResultadoValidacao validarSenha(String senha) {
        List<String> erros = new ArrayList<>();

        if (!temComprimentoMinimo(senha)) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }
        if (!temDoisDigitos(senha)) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }

    private boolean temComprimentoMinimo(String senha) {
        return senha.length() >= 8;
    }

    private boolean temDoisDigitos(String senha) {
        return senha.chars().filter(Character::isDigit).count() >= 2;
    }

    private boolean temLetraMaiuscula(String senha) {
        return senha.chars().anyMatch(Character::isUpperCase);
    }

}