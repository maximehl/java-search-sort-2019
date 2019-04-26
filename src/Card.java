public class Card {
    public int value;
    public String name;

    public Card(int value){
        this.value = value;
        if(value<11){
            this.name = Integer.toString(value);
        }else if(value==11){
            this.name = "J";
        }else if(value==12){
            this.name = "Q";
        }else if(value==13){
            this.name = "K";
        }else if(value==14){
            this.name = "A";
        }
    }
}
