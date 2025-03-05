package com.paloma_matos.validador_senha.validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Locale;

public class TestMessageSource {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.paloma_matos.validador_senha.config.MessageConfig.class);
        MessageSource messageSource = context.getBean(MessageSource.class);

        String mensagem = messageSource.getMessage("senha.valida", null, Locale.getDefault());
        System.out.println("Mensagem carregada: " + mensagem);

        context.close();
    }
}
