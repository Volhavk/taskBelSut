package task2;


import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TextRunner {

    public static void main(String[] args) {

        Text text = new Text(SourceString.SOURCE_TEXT);
         Sentence sentence = text.getSentences().stream()
                 .filter(s -> s.getPunctuations().stream().anyMatch(e -> e.getPunctuationMark().equals("?")))
                 .findFirst()
                 .get();

        List<Word> restWords = text.getSentences()
                .stream()
                .skip(1)
                .map(Sentence::getWords)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<Word> wordsThatAbsent = text.getSentences().get(0).getWords().stream()
                .filter(word -> restWords.stream().noneMatch(w -> w.getValue().equals(word.getValue())))
                .collect(Collectors.toList());

        String first = "B";
        String second = "name";

        List<Word> wordsInSentence = sentence.getWords();

        int indexOfFirst = wordsInSentence.indexOf(wordsInSentence.stream().filter(word -> word.getValue().startsWith(first)).findFirst().get());
        int indexOfSecond = wordsInSentence.indexOf(wordsInSentence.stream().filter(word -> word.getValue().endsWith(second)).findFirst().get());

        sentence.getWords().removeIf(word -> sentence.getWords().indexOf(word) >= indexOfFirst && sentence.getWords().indexOf(word) <= indexOfSecond);

        System.out.println(text);
    }
}

