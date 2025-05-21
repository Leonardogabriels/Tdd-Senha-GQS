package Tdd.Senha;

import org.junit.jupiter.api.Test;
import java.util.List;

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
    void deveFalharSeSenhaNaoTiverLetraMaiuscula() {
        ResultadoValidacao resultado = validador.validarSenha("abc123!!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos uma letra maiuscula"));
    }

    @Test
    void deveFalharSeSenhaNaoTiverCaractereEspecial() {
        ResultadoValidacao resultado = validador.validarSenha("Abc12345");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void devePassarComSenhaValida() {
        ResultadoValidacao resultado = validador.validarSenha("Abc123!!");
        assertTrue(resultado.isValida());
        assertEquals(0, resultado.getErros().size());
    }

    @Test
    void deveRetornarTodosOsErrosComSenhaInvalida() {
        ResultadoValidacao resultado = validador.validarSenha("abc");
        List<String> erros = resultado.getErros();

        assertFalse(resultado.isValida());
        assertEquals(4, erros.size());
        assertTrue(erros.contains("A senha deve ter pelo menos 8 caracteres"));
        assertTrue(erros.contains("A senha deve conter pelo menos 2 dígitos"));
        assertTrue(erros.contains("A senha deve conter pelo menos uma letra maiuscula"));
        assertTrue(erros.contains("A senha deve conter pelo menos um caractere especial"));
    }
}