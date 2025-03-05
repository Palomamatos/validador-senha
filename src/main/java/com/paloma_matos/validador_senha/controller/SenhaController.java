package com.paloma_matos.validador_senha.controller;

import com.paloma_matos.validador_senha.validator.SenhaValidator;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SenhaController {

    private final SenhaValidator senhaValidator;

    // Injeta o validador no controller (Usando @Autowired para Spring cuidar da injeção)
    public SenhaController(SenhaValidator senhaValidator) {
        this.senhaValidator = senhaValidator;
    }

    // Endpoint para validar a senha
    @PostMapping("/validar-senha")
    public String validarSenha(@RequestBody Map<String, String> payload) {
        // Extrai a senha do corpo da requisição
        String senha = payload.get("senha");

        // Verifica se a senha foi passada
        if (senha == null || senha.isEmpty()) {
            return "Erro: O campo 'senha' é obrigatório.";
        }

        // Valida a senha e obtém a resposta do validador
        String resultado = senhaValidator.validarSenha(senha);

        // Retorna o resultado da validação
        return resultado;
    }
}
