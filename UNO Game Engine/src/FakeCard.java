public class FakeCard extends Card implements ColoredCard{

    private Color color;
    private final String NAME = "Fake";

    public FakeCard(Color color){
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
