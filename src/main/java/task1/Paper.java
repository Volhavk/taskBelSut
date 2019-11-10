package task1;

public interface Paper {

    public String paper = "paper";

    default Color color(){
        return Color.valueOf(color().getColor());
    }

}
