package mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculadoraTest {

    @Test
    void testSomar() {
        // Criando o mock de ServicoMatematico
        ServicoMatematico servicoMock = mock(ServicoMatematico.class);

        // Definindo o comportamento do mock para a chamada somar(2, 3)
        when(servicoMock.somar(2, 3)).thenReturn(5);

        // Criando uma instância da Calculadora com o mock
        Calculadora calculadora = new Calculadora(servicoMock);

        // Executando o teste
        int resultado = calculadora.somar(2, 3);

        // Verificando se o resultado é o esperado
        assertEquals(5, resultado);

        // Verificando se o método somar foi chamado corretamente
        verify(servicoMock).somar(2, 3);
    }
}
