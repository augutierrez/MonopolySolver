package monopolyLogic;

public class MonopolyCard {
    public int pos;
    public int rent;
    public int hValue;
    public int house1;
    public int house2;
    public int house3;
    public int house4;
    public int hotel;
    public boolean h1;
    public boolean h2;
    public boolean h3;
    public boolean h4;
    public boolean h;
    public int player;
    public String name;

    public MonopolyCard(int player, int rent, int position){
        this.player = player;
        this.rent = rent;
        h1 = false;
        h2 = false;
        h3 = false;
        h4 = false;
        h = false;
        pos = position;
        hValue = 0;
    }

    public int gethValue(){
        return hValue;
    }

    public void sethValue(int hValue) {
        this.hValue = hValue;
    }

    public int getPos(){
        return pos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getRent(){
        if(h1){
            return house1;
        }
        else if(h2){
            return house2;
        }
        else if(h3){
            return house3;
        }
        else if(h4){
            return house4;
        }
        else if(h){
            return hotel;
        }
        return rent;
    }

    public int getOwner(){
        return player;
    }

    public void setRent(int rent){
        this.rent = rent;
    }

    public void setHouse1(int rent){
        this.house1=rent;
    }

    public void setHouse2(int rent){
        this.house2=rent;
    }

    public void setHouse3(int rent){
        this.house3=rent;
    }

    public void setHouse4(int rent){
        this.house4=rent;
    }

    public void setHotel(int rent){
        this.hotel=rent;
    }

    public void has1house(){
        h1 = true;
    }
    public void has2house(){
        h2 = true;
    }
    public void has3house(){
        h3 = true;
    }
    public void has4house(){
        h4 = true;
    }
    public void hashotel(){
        h = true;
    }

    public void setPlayer(int player){
        this.player = player;
    }

}