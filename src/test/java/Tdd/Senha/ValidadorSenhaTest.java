package Tdd.Senha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidadorSenhaTest {

    ValidadorSenha validador = new ValidadorSenha();

    @Test
    void deveFalharSeSenhaTiverMenosDe8Caracteres() {
        ResultadoValidacao resultado = validador.validarSenha("Ab1!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void deveFalharSeSenhaNaoTiverDoisDigitos() {
        ResultadoValidacao resultado = validador.validarSenha("Abcdefg!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    void devePassarComSenhaValida() {
        ResultadoValidacao resultado = validador.validarSenha("Abc123!!");
        assertTrue(resultado.isValida());
        assertEquals(0, resultado.getErros().size());
    }

}