package mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculadoraTest {

    @Test
    void testSomar() {
        
        ServicoMatematico servicoMock = mock(ServicoMatematico.class);
        when(servicoMock.somar(2, 3)).thenReturn(5);
        Calculadora calculadora = new Calculadora(servicoMock);
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
        verify(servicoMock).somar(2, 3);
    }
}
