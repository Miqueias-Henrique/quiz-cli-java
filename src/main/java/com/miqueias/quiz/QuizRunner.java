package com.miqueias.quiz;

import java.io.PrintStream;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class QuizRunner {

    private static final Locale LOCALE_PT_BR = Locale.forLanguageTag("pt-BR");

    private final Scanner scanner;
    private final PrintStream out;

    public QuizRunner(Scanner scanner, PrintStream out) {
        this.scanner = Objects.requireNonNull(scanner, "Scanner não pode ser nulo.");
        this.out = Objects.requireNonNull(out, "PrintStream não pode ser nulo.");
    }

    public ResultadoQuiz executar(List<Questao> questoes) {
        Objects.requireNonNull(questoes, "A lista de questões não pode ser nula.");

        exibirCabecalho(questoes.size());

        int acertos = 0;
        for (int i = 0; i < questoes.size(); i++) {
            Questao questao = questoes.get(i);
            exibirQuestao(i + 1, questoes.size(), questao);

            Alternativa resposta = lerRespostaValida();
            if (questao.isCorreta(resposta)) {
                acertos++;
                out.println("Parabéns, resposta correta! - Letra: " + questao.correta());
            } else {
                out.println("Resposta errada!");
                out.println("A opção correta é a letra: " + questao.correta()
                        + " (" + questao.textoOpcao(questao.correta()) + ")");
            }
            out.println();
        }

        ResultadoQuiz resultado = new ResultadoQuiz(questoes.size(), acertos);
        exibirResultado(resultado);
        return resultado;
    }

    private void exibirCabecalho(int totalQuestoes) {
        out.println("--------------------------------------------------");
        out.println("Unifan - Centro Universitário Alfredo Nasser");
        out.println("Professor: Brenno Pimenta");
        out.println("Aluno: Miqueias Henrique Da Silva Carvalho");
        out.println("--------------------------------------------------");
        out.println();
        out.println("**************************************************");
        out.printf(LOCALE_PT_BR, "* Quiz de %d perguntas sobre Freakazoid!         *%n", totalQuestoes);
        out.println("**************************************************");
        out.println("Bem-vindo ao Quiz sobre Freakazoid! Espero que se divirta.");
        out.println();
    }

    private void exibirQuestao(int numero, int total, Questao questao) {
        out.printf(LOCALE_PT_BR, "Pergunta %d/%d: %s%n", numero, total, questao.enunciado());
        out.println();
        for (Alternativa alternativa : Alternativa.values()) {
            out.printf("%s) %s%n", alternativa, questao.textoOpcao(alternativa));
        }
        out.println();
    }

    private Alternativa lerRespostaValida() {
        while (true) {
            out.print("Digite a resposta (A, B, C, D ou E): ");
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Entrada encerrada antes da conclusão do quiz.");
            }
            String entrada = scanner.nextLine();
            Optional<Alternativa> alternativa = Alternativa.fromInput(entrada);
            if (alternativa.isPresent()) {
                return alternativa.get();
            }
            out.println("Resposta inválida! Digite uma opção entre A, B, C, D ou E.");
            out.println();
        }
    }

    private void exibirResultado(ResultadoQuiz resultado) {
        out.println("--------------------------------------------------");
        out.println("Parabéns! Você respondeu todas as perguntas do quiz.");
        out.println("Total de acertos: " + resultado.acertos());
        out.println("Total de erros: " + resultado.erros());
        out.printf(LOCALE_PT_BR, "Aproveitamento: %.2f%%%n", resultado.percentualAcertos());
        out.println("--------------------------------------------------");
    }
}
