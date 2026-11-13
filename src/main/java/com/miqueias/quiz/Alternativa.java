package com.miqueias.quiz;

import java.util.Locale;
import java.util.Optional;

/**
 * Representa as alternativas válidas para uma questão de múltipla escolha.
 */
public enum Alternativa {
    A, B, C, D, E;

    /**
     * Converte uma entrada textual para uma {@link Alternativa}, ignorando espaços e maiúsculas/minúsculas.
     *
     * @param input texto digitado pelo usuário
     * @return {@link Optional} com a alternativa correspondente, ou vazio se inválida
     */
    public static Optional<Alternativa> fromInput(String input) {
        if (input == null) {
            return Optional.empty();
        }
        String normalized = input.trim().toUpperCase(Locale.ROOT);
        for (Alternativa alternativa : values()) {
            if (alternativa.name().equals(normalized)) {
                return Optional.of(alternativa);
            }
        }
        return Optional.empty();
    }
}
