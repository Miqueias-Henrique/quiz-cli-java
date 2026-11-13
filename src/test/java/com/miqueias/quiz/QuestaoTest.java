package com.miqueias.quiz;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestaoTest {

    @Test
    void deveValidarRespostaCorretaEIncorreta() {
        Questao questao = Questao.of(
                "Qual é o verdadeiro nome do Freakazoid?",
                "Dexter Douglas",
                "Bruce Wayne",
                "Clark Kent",
                "Peter Parker",
                "Wally West",
                Alternativa.A
        );

        assertTrue(questao.isCorreta(Alternativa.A));
        assertFalse(questao.isCorreta(Alternativa.B));
        assertFalse(questao.isCorreta(null));
        assertEquals("Dexter Douglas", questao.textoOpcao(Alternativa.A));
    }

    @Test
    void deveRejeitarEnunciadoVazioOuOpcaoInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                Questao.of("   ", "A", "B", "C", "D", "E", Alternativa.A));

        assertThrows(IllegalArgumentException.class, () ->
                Questao.of("Pergunta?", "A", " ", "C", "D", "E", Alternativa.A));

        assertThrows(NullPointerException.class, () ->
                Questao.of("Pergunta?", "A", "B", "C", "D", "E", null));
    }

    @Test
    void deveManterMapaDeOpcoesImutavel() {
        Map<Alternativa, String> mapaOriginal = new EnumMap<>(Alternativa.class);
        mapaOriginal.put(Alternativa.A, "Opção A");
        mapaOriginal.put(Alternativa.B, "Opção B");
        mapaOriginal.put(Alternativa.C, "Opção C");
        mapaOriginal.put(Alternativa.D, "Opção D");
        mapaOriginal.put(Alternativa.E, "Opção E");

        Questao questao = new Questao("Pergunta?", mapaOriginal, Alternativa.C);
        mapaOriginal.put(Alternativa.A, "Alterada");

        assertEquals("Opção A", questao.textoOpcao(Alternativa.A));
        assertThrows(UnsupportedOperationException.class, () ->
                questao.opcoes().put(Alternativa.A, "Outra"));
    }
}
