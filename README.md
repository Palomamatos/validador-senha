# Validador de Senhas

Este projeto implementa uma API para validar senhas de acordo com critérios de segurança pré-definidos. Ele recebe uma senha enviada pelo usuário e verifica se ela atende aos requisitos, retornando uma resposta indicando se a senha é válida ou não.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Web** (para criar a API REST)
- **Spring Boot Validation** (para validação de dados)
- **JUnit 5 e Mockito** (para testes automatizados)
- **Logback** (para logging)
- **MessageSource** (para internacionalização das mensagens de erro)

## Requisitos de Validação da Senha

A senha deve atender aos seguintes critérios:

- Ter no mínimo 9 caracteres
- Conter pelo menos uma letra maiúscula
- Conter pelo menos uma letra minúscula
- Conter pelo menos um número
- Conter pelo menos um caractere especial (ex: !@#$%^&*()-+)
- Não conter caracteres repetidos.
