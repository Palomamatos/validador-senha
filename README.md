## Como Rodar a Aplicação

### 1. Clonar o Repositório

```bash
git clone URL/do/repositorio
cd nome-do-repositorio
```

### 2. Configurar Dependências

Se estiver usando Maven, rode:

```bash
mvn clean install
```

### 3. Executar a Aplicação

Se estiver usando Maven:

```bash
mvn spring-boot:run
```

Ou execute diretamente o JAR gerado:

```bash
java -jar target/nome-do-seu-projeto.jar
```

### 4. Testar a API

Use um cliente HTTP como Postman, Insomnia ou cURL para enviar uma requisição POST para:

```bash
POST http://localhost:8080/validar-senha
```

Com o seguinte corpo JSON:

```json
{
    "senha": "MinhaSenha123!"
}
```

Se a senha for válida, a API retorna:

```json
{
    "mensagem": "Senha válida."
}
```

Caso contrário, retorna mensagens de erro indicando o motivo da invalidação.

### Logs

A aplicação utiliza Logback para registrar logs no console. Os logs ajudam a depurar e entender o funcionamento da API.

### Testes

Para rodar os testes unitários:

Se estiver usando Maven:

```bash
mvn test
```

### Contribuição

Fique à vontade para abrir issues e enviar pull requests com melhorias ou correções!

Desenvolvido com ❤️ por [Paloma_Matos]
