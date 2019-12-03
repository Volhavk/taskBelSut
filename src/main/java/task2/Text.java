package task2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Text {

    private List<Sentence> sentences;

    public Text(String text) {
//        sentences = Stream.of(text.split("(?<=[.|!|?])"))
//                .map(sentence -> new Sentence(sentence))
//                .collect(Collectors.toList());
        Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(text);
        while (matcher.find())
        System.out.println(matcher.group(1));
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
