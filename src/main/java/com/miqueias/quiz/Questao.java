package com.miqueias.quiz;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Modelo imutável de uma questão de múltipla escolha com 5 alternativas (A–E).
 */
public record Questao(
        String enunciado,
        Map<Alternativa, String> opcoes,
        Alternativa correta
) {
    public Questao {
        if (enunciado == null || enunciado.isBlank()) {
            throw new IllegalArgumentException("O enunciado da questão não pode ser vazio.");
        }
        Objects.requireNonNull(opcoes, "As opções da questão não podem ser nulas.");
        Objects.requireNonNull(correta, "A alternativa correta não pode ser nula.");

        EnumMap<Alternativa, String> copia = new EnumMap<>(Alternativa.class);
        for (Alternativa alt : Alternativa.values()) {
            String texto = opcoes.get(alt);
            if (texto == null || texto.isBlank()) {
                throw new IllegalArgumentException("A opção " + alt + " não pode ser vazia.");
            }
            copia.put(alt, texto.trim());
        }

        enunciado = enunciado.trim();
        opcoes = Collections.unmodifiableMap(copia);
    }

    public static Questao of(
            String enunciado,
            String opcaoA,
            String opcaoB,
            String opcaoC,
            String opcaoD,
            String opcaoE,
            Alternativa correta
    ) {
        EnumMap<Alternativa, String> mapa = new EnumMap<>(Alternativa.class);
        mapa.put(Alternativa.A, opcaoA);
        mapa.put(Alternativa.B, opcaoB);
        mapa.put(Alternativa.C, opcaoC);
        mapa.put(Alternativa.D, opcaoD);
        mapa.put(Alternativa.E, opcaoE);
        return new Questao(enunciado, mapa, correta);
    }

    public boolean isCorreta(Alternativa resposta) {
        return correta == resposta;
    }

    public String textoOpcao(Alternativa alternativa) {
        Objects.requireNonNull(alternativa, "A alternativa não pode ser nula.");
        return opcoes.get(alternativa);
    }
}
