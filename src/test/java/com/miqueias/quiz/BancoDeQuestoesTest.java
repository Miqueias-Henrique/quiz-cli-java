package com.miqueias.quiz;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BancoDeQuestoesTest {

    @Test
    void deveCarregarQuinzeQuestoesValidas() {
        List<Questao> questoes = BancoDeQuestoes.freakazoid();

        assertEquals(15, questoes.size());
        for (Questao questao : questoes) {
            assertFalse(questao.enunciado().isBlank());
            assertNotNull(questao.correta());
            for (Alternativa alt : Alternativa.values()) {
                assertFalse(questao.textoOpcao(alt).isBlank());
            }
        }
    }
}
