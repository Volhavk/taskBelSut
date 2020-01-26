package task2;


import java.util.Objects;

public class Word {

    private String value;
    private int length;

    public Word(String value) {
        this.value = value;
        this.length = value.length();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return length == word.length &&
                Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, length);
    }
}
