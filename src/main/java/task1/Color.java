package task1;

public enum Color {
    ORANGE("orange"),
    GREY("grey"),
    GREEN("green"),
    RED("red");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
