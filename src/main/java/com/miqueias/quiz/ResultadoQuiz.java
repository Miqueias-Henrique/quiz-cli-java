package com.miqueias.quiz;

/**
 * Representa o resultado consolidado de uma execução do quiz.
 */
public record ResultadoQuiz(int totalQuestoes, int acertos) {

    public ResultadoQuiz {
        if (totalQuestoes < 0) {
            throw new IllegalArgumentException("O total de questões não pode ser negativo.");
        }
        if (acertos < 0 || acertos > totalQuestoes) {
            throw new IllegalArgumentException("Número de acertos inválido: " + acertos);
        }
    }

    public int erros() {
        return totalQuestoes - acertos;
    }

    public double percentualAcertos() {
        if (totalQuestoes == 0) {
            return 0.0;
        }
        return (acertos * 100.0) / totalQuestoes;
    }
}
