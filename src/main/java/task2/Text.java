package task2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Text {

    private List<Sentence> sentences;
    private List<String> sourceSentence;

    public Text(String text) {
        sentences = Stream.of(text.split("(?<=[.|!|?])"))
                .map(sentence -> new Sentence(sentence))
                .collect(Collectors.toList());
        sourceSentence = Stream.of(text.split("(?<=[.|!|?])"))
                .collect(Collectors.toList());
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

//    public void deleteFirstLetter() {
//        Sentence sentence = sentences.stream()
//                .filter(sent -> sent.getPunctuations()
//                        .stream()
//                        .anyMatch(punctuation -> punctuation.getPunctuationMark().equals("?")))
//                .findFirst()
//                .orElseThrow(()-> new NoSuchElementException("No question marks"));
//    }

    public List<String> getSourceSentence() {
        return sourceSentence;
    }
}
