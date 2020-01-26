package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sentence {

    private List<Word> words;
    private List<Punctuation> punctuations;
    private String sourceSentence;

    public Sentence(String sentence) {
        this.sourceSentence = sentence;
        words = Stream.of(sentence.split("[[ ]*|[,]*|[:]|[/]*|[—]*|[+]*]+"))
                .filter(s -> !s.isEmpty())
                .map(word -> new Word(word))
                .collect(Collectors.toList());

        punctuations = Stream.of(sentence.split("\\w"))
                .map(s -> s.trim())
                .filter(s -> !s.isEmpty())
                .map(Punctuation::new)
                .collect(Collectors.toList());
    }

    public boolean isWordPresent(Word wordToFind) {
        return words.stream().anyMatch(word -> word.equals(wordToFind));
    }

    public void swapWords(Word firstWord, Word secondWord) {
        int indexOfFirst = words.indexOf(firstWord);
        int indexOfSecond = words.indexOf(secondWord);
        Collections.swap(words, indexOfFirst, indexOfSecond);
    }

    public void deleteFirstSymbol() {
        words = words.stream()
                .map(word -> new Word(word.getValue().replace(String.valueOf(word.getValue().charAt(0)), "")))
                .collect(Collectors.toList());
    }


    public List<Word> getWords() {
        return words;
    }

    public List<Punctuation> getPunctuations() {
        return punctuations;
    }

    public String getSourceSentence() {
        return sourceSentence;
    }
}
