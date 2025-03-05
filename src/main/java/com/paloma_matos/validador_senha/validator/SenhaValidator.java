package com.paloma_matos.validador_senha.validator;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Set;
import java.util.HashSet;

@Component
public class SenhaValidator {

    private static final Logger logger = LoggerFactory.getLogger(SenhaValidator.class);
    private final MessageSource messageSource;

    public SenhaValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String validarSenha(String senha) {
        logger.info("Validando senha fornecida...");

        if (senha.length() < 9) {
            logger.warn("Senha muito curta.");
            return messageSource.getMessage("senha.erro.tamanho", null, Locale.getDefault());
        }
        if (!senha.matches(".*[A-Z].*")) {
            logger.warn("Senha sem letra maiúscula.");
            return messageSource.getMessage("senha.erro.maiuscula", null, Locale.getDefault());
        }
        if (!senha.matches(".*[a-z].*")) {
            logger.warn("Senha sem letra minúscula.");
            return messageSource.getMessage("senha.erro.minuscula", null, Locale.getDefault());
        }
        if (!senha.matches(".*\\d.*")) {
            logger.warn("Senha sem número.");
            return messageSource.getMessage("senha.erro.numero", null, Locale.getDefault());
        }
        if (!senha.matches(".*[!@#$%^&*()\\-+=].*")) {
            logger.warn("Senha sem caractere especial.");
            return messageSource.getMessage("senha.erro.especial", null, Locale.getDefault());
        }

        Set<Character> caracteres = new HashSet<>();
        for (char c : senha.toCharArray()) {
          if (!caracteres.add(c)) {  // Se não conseguir adicionar, significa que já existe
          logger.warn("Senha contém caracteres repetidos.");
        return messageSource.getMessage("senha.erro.repetidos", null, Locale.getDefault());
    }
}

        logger.info("Senha válida!");
        return messageSource.getMessage("senha.valida", null, Locale.getDefault());
    }
}

