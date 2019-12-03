package task2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text {

    private List<Sentence> sentences;

    public Text(String text) {
        sentences = Stream.of(text.split("(?<=[.|!|?])"))
                .map(sentence -> new Sentence(sentence))
                .collect(Collectors.toList());
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void deleteFirstLetter() {
        Sentence sentence = sentences.stream()
                .filter(sent -> sent.getPunctuations()
                        .stream()
                        .anyMatch(punctuation -> punctuation.getPunctuationMark().equals("?")))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("No question marks"));
    }
}
