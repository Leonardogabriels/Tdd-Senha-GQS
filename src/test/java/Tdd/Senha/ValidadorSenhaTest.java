package Tdd.Senha;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ValidadorSenhaTest {

    ValidadorSenha validador = new ValidadorSenha();

    @Test
    void deveFalharSeSenhaTiverMenosDe8Caracteres() {
        ResultadoValidacao resultado = validador.validarSenha("Ab1!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve ter pelo menos 8 caracteres"));
    }
}
