package com.javaaiexample;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TextToSpeechService textToSpeechService = new TextToSpeechService();
        textToSpeechService.generateMp3("tts-1",
                """
                Now that I know how to generate an audio file,
                I can use it to add the ability to convert
                text to speech to any existing Java system.
                """,
                "alloy");
    }
}