# Biblioteca Pessoal API

API REST desenvolvida com Java 17, Spring Boot, Spring Data JPA, H2 e Maven para organizar livros de uma biblioteca pessoal.

## Funcionalidades
- Cadastrar livros
- Listar todos os livros
- Consultar livro por ID
- Atualizar dados de um livro
- Excluir livro
- Validar os campos obrigatórios e retornar erros HTTP apropriados

## Dados de um livro
- `titulo`
- `autor`
- `genero`
- `anoPublicacao`
- `statusLeitura`

Valores aceitos para `genero`: `FICCAO`, `FANTASIA`, `ROMANCE`, `MISTERIO`, `TERROR`, `AVENTURA`, `BIOGRAFIA`, `HISTORIA`, `CIENCIA`, `TECNICO`, `OUTRO`.

Valores aceitos para `statusLeitura`: `NAO_LIDO`, `LENDO`, `LIDO`.

## Como executar no IntelliJ IDEA
1. Extraia o ZIP.
2. Abra a pasta `Biblioteca-Pessoal-API` no IntelliJ IDEA.
3. Configure um JDK 17 ou superior.
4. Aguarde o Maven carregar as dependências.
5. Execute `BibliotecaApplication.java`.
6. A API ficará disponível em `http://localhost:8080`.

O banco H2 é em memória; os dados de exemplo são recriados ao iniciar a aplicação.

## Testes
No IntelliJ, abra `src/test/java` e execute os testes com o botão de execução da classe `LivroControllerTest`.

Pelo terminal, na raiz do projeto:
- Windows: `mvnw.cmd test`
- Linux/macOS: `./mvnw test`

Os testes cobrem listagem, cadastro, consulta por ID, atualização, exclusão e validação de título obrigatório.

## Endpoints
| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/livros` | Cadastra um livro |
| GET | `/livros` | Lista livros |
| GET | `/livros/{id}` | Consulta um livro |
| PUT | `/livros/{id}` | Atualiza um livro |
| DELETE | `/livros/{id}` | Exclui um livro |

## Exemplo de JSON
```json
{
  "titulo": "O Hobbit",
  "autor": "J. R. R. Tolkien",
  "genero": "FANTASIA",
  "anoPublicacao": 1937,
  "statusLeitura": "LIDO"
}
```

## Repositório GitHub
Depois de criar um repositório vazio no GitHub, execute na pasta do projeto:
```bash
git init
git add .
git commit -m "Projeto API Biblioteca Pessoal"
git branch -M main
git remote add origin https://github.com/SEU-USUARIO/biblioteca-pessoal-api.git
git push -u origin main
```
Substitua `SEU-USUARIO` pelo seu nome de usuário do GitHub.
