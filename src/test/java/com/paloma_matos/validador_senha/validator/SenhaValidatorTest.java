package com.paloma_matos.validador_senha.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SenhaValidatorTest {

    private SenhaValidator senhaValidator;
    private MessageSource messageSource;

    @BeforeEach
    public void setup() {
        // Cria um mock do MessageSource
        messageSource = Mockito.mock(MessageSource.class);
        senhaValidator = new SenhaValidator(messageSource);

        // Defina o comportamento do MessageSource para retornar mensagens específicas
        Mockito.when(messageSource.getMessage("senha.erro.tamanho", null, Locale.getDefault()))
                .thenReturn("A senha tem menos de 9 caracteres.");
        Mockito.when(messageSource.getMessage("senha.erro.maiuscula", null, Locale.getDefault()))
                .thenReturn("A senha não tem letra maiúscula.");
        Mockito.when(messageSource.getMessage("senha.erro.minuscula", null, Locale.getDefault()))
                .thenReturn("A senha não tem letra minúscula.");
        Mockito.when(messageSource.getMessage("senha.erro.numero", null, Locale.getDefault()))
                .thenReturn("A senha não tem número.");
        Mockito.when(messageSource.getMessage("senha.erro.especial", null, Locale.getDefault()))
                .thenReturn("A senha não tem caractere especial.");
        Mockito.when(messageSource.getMessage("senha.erro.repetidos", null, Locale.getDefault()))
                .thenReturn("A senha contém caracteres repetidos.");
        Mockito.when(messageSource.getMessage("senha.valida", null, Locale.getDefault()))
                .thenReturn("Senha válida!");
    }

    @Test
    public void testSenhaValida() {
        String senha = "Senha@123";
        assertEquals("Senha válida!", senhaValidator.validarSenha(senha));
    }

    @Test
    public void testSenhaCurta() {
        String senha = "Sa@1";
        assertEquals("A senha tem menos de 9 caracteres.", senhaValidator.validarSenha(senha));
    }

    @Test
    public void testSenhaSemMaiuscula() {
        String senha = "senha@123";
        assertEquals("A senha não tem letra maiúscula.", senhaValidator.validarSenha(senha));
    }

    @Test
    public void testSenhaSemMinuscula() {
        String senha = "SENHA@123";
        assertEquals("A senha não tem letra minúscula.", senhaValidator.validarSenha(senha));
    }

    @Test
    public void testSenhaSemNumero() {
        String senha = "Senha@bcde";
        assertEquals("A senha não tem número.", senhaValidator.validarSenha(senha));
    }

    @Test
    public void testSenhaSemEspecial() {
        String senha = "Senha123e";
        assertEquals("A senha não tem caractere especial.", senhaValidator.validarSenha(senha));
    }

   
    @Test
    void deveRejeitarSenhaComCaracteresRepetidos() {
        String senha = "SenhaA12!A"; // 'A' se repete
        String mensagem = senhaValidator.validarSenha(senha);
        assertEquals("A senha contém caracteres repetidos.", mensagem);
    }
    
}
