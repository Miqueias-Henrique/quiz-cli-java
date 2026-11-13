package com.miqueias.quiz;

import java.util.Locale;
import java.util.Optional;

public enum Alternativa {
    A, B, C, D, E;

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
