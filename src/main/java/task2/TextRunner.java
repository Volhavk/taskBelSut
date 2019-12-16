package task2;


import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static task2.SourceString.SOURCE_TEXT;

public class TextRunner {

    public static void main(String[] args) {

        Text text = new Text(SOURCE_TEXT);
        Word word = new Word("happily");

        text.getSentences().forEach(s -> System.out.println(s.getSourceSentence())); //выводим на экран текст, разбитый на предложения

        Sentence sentence = text.getSentences().stream()
                .filter(s -> s.getPunctuations().stream().anyMatch(e -> e.getPunctuationMark().equals("?")))
                .findFirst()
                .get(); // sentence теперь это вопросительное предложение

        Sentence sentence1 = text.getSentences().stream()
                .filter(s -> s.getPunctuations().stream().anyMatch(e -> e.getPunctuationMark().equals("!")))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("bla")); // sentence1 это восклицательное предложение

        sentence1.swapWords(sentence1.getWords().get(0), sentence1.getWords().get(sentence1.getWords().size()-1)); //в предложении меняем местами слова

        String firstSymbol = "a";
        String lastSymbol = "d";

        List<Sentence> narrativeSent = text.getSentences().stream()
                .filter(n -> n.getPunctuations().contains(new Punctuation(".")))
                .collect(Collectors.toList()); //собираем в коллекцию все повествовательные предложения

        for (Sentence s : narrativeSent) {
            int indexOfFirst = s.getWords().indexOf(
                    s.getWords().stream()
                            .filter(w -> w.getValue().startsWith(firstSymbol))
                            .findFirst().get()); // находим первый в предложении символ "а"
            int indexOfLast = s.getWords().indexOf(
                    s.getWords().stream()
                            .filter(w -> w.getValue().endsWith(lastSymbol))
                            .findFirst().get()); //находим первый символ "d"

            s.getWords().removeIf(w -> s.getWords().indexOf(w) >= indexOfFirst && s.getWords().indexOf(w) <= indexOfLast); //удаляем все между первыми
            //символами в повествовательных предложениях ("a" и "d")
        }

        sentence.isWordPresent(word); //ищем захардкоданное слово, потому что оно точно есть в предложении sentence :)

        List<Word> restWords = text.getSentences()
                .stream()
                .skip(1)
                .map(Sentence::getWords)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());    //здесь собираем коллекцию из слов, которые есть во всех предложениях кроме 1

        List<Word> wordsThatAbsent = text.getSentences().get(0).getWords().stream()
                .filter(w -> restWords.stream().noneMatch(wo -> wo.getValue().equals(w.getValue())))
                .collect(Collectors.toList()); //возвращаем все слова, которые есть только в первом предложении

        List<Word> wordsInSentence = sentence.getWords(); //здесь вернутся все слова из второго предложения

        sentence.deleteFirstSymbol(); // удаляем первые буквы во всех словах вопросительного предложения

    }
}

