package Tdd.Senha;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorSenhaTest {

    ValidadorSenha validador = new ValidadorSenha();

    @Test
    void deveFalharQuandoSenhaForMuitoCurta() {
        ResultadoValidacao resultado = validador.validarSenha("Ab1!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void deveFalharQuandoSenhaNaoTemDigitosSuficientes() {
        ResultadoValidacao resultado = validador.validarSenha("Abcdefgh!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos 2 dígitos"));
    }
}