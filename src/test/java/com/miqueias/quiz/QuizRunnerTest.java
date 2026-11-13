package com.miqueias.quiz;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuizRunnerTest {

    @Test
    void deveExecutarQuizComRespostasMistasEValidarEntradasInvalidas() {
        List<Questao> questoes = List.of(
                Questao.of("Pergunta 1", "A1", "B1", "C1", "D1", "E1", Alternativa.A),
                Questao.of("Pergunta 2", "A2", "B2", "C2", "D2", "E2", Alternativa.C)
        );

        String entradaSimulada = String.join("\n", "Z", "", "a", "B") + "\n";
        Scanner scanner = new Scanner(entradaSimulada);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer, true, StandardCharsets.UTF_8);

        QuizRunner runner = new QuizRunner(scanner, out);
        ResultadoQuiz resultado = runner.executar(questoes);

        assertEquals(2, resultado.totalQuestoes());
        assertEquals(1, resultado.acertos());
        assertEquals(1, resultado.erros());
        assertEquals(50.0, resultado.percentualAcertos(), 0.001);

        String saida = buffer.toString(StandardCharsets.UTF_8);
        assertTrue(saida.contains("Resposta inválida!"));
        assertTrue(saida.contains("Total de acertos: 1"));
        assertTrue(saida.contains("Total de erros: 1"));
        assertTrue(saida.contains("Aproveitamento: 50,00%"));
    }

    @Test
    void deveCalcularCemPorCentoNoQuizCompletoSemErroDeDivisao() {
        List<Questao> questoes = BancoDeQuestoes.freakazoid();
        StringBuilder entradas = new StringBuilder();
        for (Questao q : questoes) {
            entradas.append(q.correta().name()).append('\n');
        }

        Scanner scanner = new Scanner(entradas.toString());
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer, true, StandardCharsets.UTF_8);

        ResultadoQuiz resultado = new QuizRunner(scanner, out).executar(questoes);

        assertEquals(15, resultado.acertos());
        assertEquals(0, resultado.erros());
        assertEquals(100.0, resultado.percentualAcertos(), 0.001);

        String saida = buffer.toString(StandardCharsets.UTF_8);
        assertTrue(saida.contains("Aproveitamento: 100,00%"));
    }

    @Test
    void deveLancarExcecaoClaraQuandoEntradaTerminarAntesDoFim() {
        List<Questao> questoes = List.of(
                Questao.of("Pergunta 1", "A1", "B1", "C1", "D1", "E1", Alternativa.A)
        );
        Scanner scanner = new Scanner("");
        PrintStream out = new PrintStream(new ByteArrayOutputStream(), true, StandardCharsets.UTF_8);

        QuizRunner runner = new QuizRunner(scanner, out);

        assertThrows(IllegalStateException.class, () -> runner.executar(questoes));
    }
}
