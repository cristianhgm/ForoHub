package com.alura.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicCreationData(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        int author,
        @NotBlank
        String course) {
}
