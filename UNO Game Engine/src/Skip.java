public class Skip extends Card implements ExecutableCard, ColoredCard{

    private final int VALUE = 20;
    private final String NAME = "Skip";
    private Color color;

    public Skip(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public String getName(){ return NAME; }

    public int getValue(){
        return VALUE;
    }
}
