package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sentence {

    private List<Word> words = new ArrayList<>();
    private List<Punctuation> punctuations = new ArrayList<>();

    public Sentence(String sentence) {
        words = Stream.of(sentence.split("[[ ]*|[,]*|[:]|[/]*|[—]*|[+]*]+"))
                .map(word -> new Word(word))
                .collect(Collectors.toList());

        punctuations = Stream.of(sentence.split("\\w"))
                .map(s -> s.trim())
                .filter(s -> !s.isEmpty())
                .map(punctuation -> new Punctuation(punctuation))
                .collect(Collectors.toList());

    }

    public List<Word> getWords() {
        return words;
    }

    public List<Punctuation> getPunctuations() {
        return punctuations;
    }
}
