package task2;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private List<Word> listOfWords = new ArrayList<>();
    private String value="";

    public void addValue(Word word) {
        value += " " + word.getValue();
    }

    public String getValue() {
        return value;
    }

}
