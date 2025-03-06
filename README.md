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

## Como rodar a Aplicação

1. Clonar o Repositório
git clone URL/do/repositorio
cd nome-do-repositorio
2. Configurar Dependências
Se estiver usando Maven, rode:

mvn clean install
3. Executar a Aplicação
Se estiver usando Maven:

mvn spring-boot:run
Ou execute diretamente o JAR gerado:

java -jar target/nome-do-seu-projeto.jar
4. Testar a API
Use um cliente HTTP como Postman, Insomnia ou cURL para enviar uma requisição POST para:

POST http://localhost:8080/validar-senha
Com o seguinte corpo JSON:

{
    "senha": "MinhaSenha123!"
}
Se a senha for válida, a API retorna:

{
    "mensagem": "Senha válida."
}
Caso contrário, retorna mensagens de erro indicando o motivo da invalidação.

Logs
A aplicação utiliza Logback para registrar logs no console. Os logs ajudam a depurar e entender o funcionamento da API.

Testes
Para rodar os testes unitários:

Se estiver usando Maven:

mvn test
Contribuição
Fique à vontade para abrir issues e enviar pull requests com melhorias ou correções!

Desenvolvido com ❤️ por [Paloma_Matos]
