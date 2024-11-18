public enum Color {
    RED("Red"), GREEN("Green"), BLUE("Blue"),
    YELLOW("Yellow");

    private final String color;

    Color(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
