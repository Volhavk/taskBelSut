package task2;

public class TextRunner {

    public static void main(String[] args) {

            Word word = new Word("quote");
            Text text = new Text(word);

            Word word1 = new Word("abr");
            Word word2 = new Word("abrr");
            Word word3 = new Word("abrrvalg");

            Sentence phrase = new Sentence();
            phrase.addValue(word1);
            phrase.addValue(word2);
            phrase.addValue(word3);

            System.out.println(phrase.getValue());

        }
    }

