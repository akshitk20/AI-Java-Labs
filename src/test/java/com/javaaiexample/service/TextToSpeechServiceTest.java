package com.javaaiexample.service;

import com.javaaiexample.service.TextToSpeechService;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TextToSpeechServiceTest {

    @Test
    void testGenerateMp3() {
        var service = new TextToSpeechService();
        Path result = service.generateMp3(
                "tts-1",
                """
                Now that I know how to generate an audio file,
                I can use it to add the ability to convert
                text to speech to any existing Java system.
                """,
                "alloy"
        );

        assertNotNull(result);
        System.out.println("Generated audio file: " + result.toAbsolutePath());
    }
}