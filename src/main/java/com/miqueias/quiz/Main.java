package com.miqueias.quiz;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

/**
 * Ponto de entrada da aplicação CLI do Quiz Freakazoid.
 */
public class Main {

    public static void main(String[] args) {
        List<Questao> questoes = BancoDeQuestoes.freakazoid();
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            QuizRunner runner = new QuizRunner(scanner, System.out);
            runner.executar(questoes);
        }
    }
}
