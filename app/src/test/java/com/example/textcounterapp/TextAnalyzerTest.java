package com.example.textcounterapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextAnalyzerTest {

    @Test
    public void countWords_SimpleSentence_ReturnsCorrectCount() {
        String input = "Labas rytas Lietuva";
        int result = TextAnalyzer.countWords(input);
        assertEquals(3, result);
    }

    @Test
    public void countWords_EmptyString_ReturnsZero() {
        assertEquals(0, TextAnalyzer.countWords(""));
    }

    @Test
    public void countSentences_MultipleSentences_ReturnsCorrectCount() {
        String input = "Tai yra sakinys. Tai antras. Ir trečias...";
        int result = TextAnalyzer.countSentences(input);
        assertEquals(3, result);
    }

    @Test
    public void countNumbers_MixedText_ReturnsCorrectCount() {
        String input = "Turiu 2 obuolius ir 50 eurų";
        int result = TextAnalyzer.countNumbers(input);
        assertEquals(2, result);
    }

    @Test
    public void countPunctuation_VariousSymbols_ReturnsCorrectCount() {
        String input = "A, B, C.";
        int result = TextAnalyzer.countPunctuation(input);
        assertEquals(5, result);
    }
}