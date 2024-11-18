public class NumberedCard extends Card implements ColoredCard{

    private final int VALUE;

    private final String NAME = "NumberedCard";
    private Color color;
    private Number number;

    public NumberedCard(Color color, Number number){
       this.color = color;
       this.number = number;
       this.VALUE = number.getNum();
   }

   public Color getColor(){
       return color;
   }

   public Number getNumber(){
       return number;
   }

   public int getValue() { return VALUE; }

    @Override
    public String getName() { return NAME; }
   public boolean isSameColor(NumberedCard numberedCard){
        return this.color.equals(numberedCard.color);
   }

    public boolean isSameNumber(NumberedCard numberedCard){
        return this.number.equals(numberedCard.number);
    }
}
