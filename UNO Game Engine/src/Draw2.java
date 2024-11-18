public class Draw2 extends Card implements ExecutableCard, ColoredCard{

    private final int VALUE = 20;
    private final String NAME = "Draw2";
    private Color color;

    public Draw2(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public int getValue() {return VALUE;}

    @Override
    public String getName() {
        return NAME;
    }
}
