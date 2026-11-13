package com.miqueias.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultadoQuizTest {

    @Test
    void deveCalcularErrosEPercentualCorretamente() {
        ResultadoQuiz resultado = new ResultadoQuiz(15, 12);

        assertEquals(15, resultado.totalQuestoes());
        assertEquals(12, resultado.acertos());
        assertEquals(3, resultado.erros());
        assertEquals(80.0, resultado.percentualAcertos(), 0.001);
    }

    @Test
    void deveRetornarCemPorCentoQuandoAcertarTodas() {
        ResultadoQuiz resultado = new ResultadoQuiz(15, 15);

        assertEquals(0, resultado.erros());
        assertEquals(100.0, resultado.percentualAcertos(), 0.001);
    }

    @Test
    void deveTratarZeroQuestoesSemDivisaoPorZero() {
        ResultadoQuiz resultado = new ResultadoQuiz(0, 0);

        assertEquals(0, resultado.erros());
        assertEquals(0.0, resultado.percentualAcertos(), 0.001);
    }

    @Test
    void deveRejeitarValoresInconsistentes() {
        assertThrows(IllegalArgumentException.class, () -> new ResultadoQuiz(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> new ResultadoQuiz(10, -1));
        assertThrows(IllegalArgumentException.class, () -> new ResultadoQuiz(10, 11));
    }
}
