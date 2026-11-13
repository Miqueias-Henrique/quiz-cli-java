# Quiz Freakazoid!

Quiz de terminal em Java com 15 perguntas de múltipla escolha sobre a animação *Freakazoid!*.

Comecei esse projeto como um trabalho da faculdade (Unifan — Centro Universitário Alfredo Nasser, disciplina do Prof. Brenno Pimenta). Depois da entrega inicial, voltei no código para reorganizar a estrutura com Maven, separar melhor as classes, corrigir alguns bugs e adicionar testes unitários com JUnit 5.

## Como funciona

O programa exibe as 15 perguntas em sequência no terminal, valida se a resposta digitada está entre `A` e `E` (aceitando maiúsculas ou minúsculas) e mostra o total de acertos, erros e o percentual de aproveitamento ao final.

## Estrutura do projeto

```text
src/
├── main/java/com/miqueias/quiz/
│   ├── Alternativa.java       # Enum das opções (A–E) e leitura segura da entrada
│   ├── BancoDeQuestoes.java   # Lista com as 15 perguntas do quiz
│   ├── Main.java              # Ponto de entrada da aplicação
│   ├── Questao.java           # Modelo da questão com validação das opções
│   ├── QuizRunner.java        # Fluxo de interação no terminal
│   └── ResultadoQuiz.java     # Cálculo de acertos, erros e porcentagem
└── test/java/com/miqueias/quiz/
    └── ...                    # Testes unitários e de fluxo com JUnit 5
```

## Requisitos

- Java 17 ou superior
- Maven 3.8+

## Como rodar

Para executar os testes:

```bash
mvn test
```

Para rodar o quiz pelo Maven:

```bash
mvn -q compile exec:java
```

Se preferir gerar e executar o `.jar`:

```bash
mvn package
java -jar target/quiz-freakazoid-1.0.0.jar
```

## Exemplo de saída

```text
Pergunta 1/15: Qual é o verdadeiro nome do Freakazoid?

A) Dexter Douglas
B) Bruce Wayne
C) Clark Kent
D) Peter Parker
E) Wally West

Digite a resposta (A, B, C, D ou E): A
Parabéns, resposta correta! - Letra: A
```
