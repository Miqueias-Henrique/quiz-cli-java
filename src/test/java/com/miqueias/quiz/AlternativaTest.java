package com.miqueias.quiz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlternativaTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "a", " A ", "\tb\n", "c", "D", " e "})
    void deveConverterEntradasValidas(String entrada) {
        assertTrue(Alternativa.fromInput(entrada).isPresent());
    }

    @Test
    void deveMapearLetrasCorretamente() {
        assertEquals(Alternativa.A, Alternativa.fromInput("a").orElseThrow());
        assertEquals(Alternativa.B, Alternativa.fromInput("B").orElseThrow());
        assertEquals(Alternativa.C, Alternativa.fromInput(" c ").orElseThrow());
        assertEquals(Alternativa.D, Alternativa.fromInput("d").orElseThrow());
        assertEquals(Alternativa.E, Alternativa.fromInput("E").orElseThrow());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "F", "1", "AB", "Z"})
    void deveRetornarVazioParaEntradasInvalidas(String entrada) {
        assertTrue(Alternativa.fromInput(entrada).isEmpty());
    }
}
