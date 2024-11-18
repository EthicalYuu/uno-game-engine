public class Reverse extends Card implements ExecutableCard, ColoredCard {
    private final int VALUE = 20;
    private final String NAME = "Reverse";
    private Color color;


    public Reverse(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String getName(){ return NAME; }

    public int getValue(){
        return VALUE;
    }
}
