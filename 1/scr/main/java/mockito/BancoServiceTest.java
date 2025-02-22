import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("12345", 1000.0);

        // Definindo comportamento do mock
        when(contaRepositoryMock.buscarConta("12345")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepositoryMock);

        // Testando consulta de saldo
        double saldo = bancoService.consultarSaldo("12345");

        // Verificando se o saldo está correto
        assertEquals(1000.0, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(contaRepositoryMock).buscarConta("12345");
    }

    @Test
    public void testDepositar() {
        // Criando mock do repositório
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("12345", 1000.0);

        // Definindo comportamento do mock
        when(contaRepositoryMock.buscarConta("12345")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepositoryMock);

        // Executando depósito
        bancoService.depositar("12345", 500.0);

        // Verificando se o saldo foi atualizado
        assertEquals(1500.0, conta.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(contaRepositoryMock).buscarConta("12345");
        verify(contaRepositoryMock).salvar(conta);
    }
}
