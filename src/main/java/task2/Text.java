package task2;

public class Text {

    private String text;

    public Text( Word word) {
        text = word.getValue();
    }

    public Text(Sentence sentence) {
        text = sentence.getValue();
    }

    public String getText() {
        return text;
    }

}
