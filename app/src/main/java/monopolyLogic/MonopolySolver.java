package monopolyLogic;
import java.util.ArrayList;

public class MonopolySolver {
    public static ArrayList<MonopolyCard> properties;
    public static ArrayList<Integer> positions;
    public static ArrayList<Long> balances;
    public static ArrayList<MonopolyCard>deck;

    public static void generatePositions(int numPlayers){
        positions = new ArrayList<>();
        for(int i = 0; i < numPlayers; i++){
            positions.add(0);
        }
    }

    public static void generateBalances(int numPlayers){
        balances = new ArrayList<>();
        for(int i = 0; i < numPlayers; i++){
            balances.add((long)0);
        }
    }


    public static void generateDeck(){
        properties = new ArrayList<>();
        int turn = 0;

        /*
        Populate all the Monopoly properties and then the next thing would be to assign who owns them
         */

        deck = new ArrayList<>();

        for(int i = 0; i < 40; i++){
            deck.add(new MonopolyCard(-1, 0, i));
        }

        MonopolyCard card;
        //populating properties
        //1
        card = deck.get(1);
        card.setName("Mediterranean Avenue");
        card.setRent(2);
        card.setHouse1(10);
        card.setHouse2(30);
        card.setHouse3(90);
        card.setHouse4(160);
        card.setHotel(250);
        properties.add(card);

        //2
        card = deck.get(3);
        card.setName("Baltic Avenue");
        card.setRent(4);
        card.setHouse1(20);
        card.setHouse2(60);
        card.setHouse3(180);
        card.setHouse4(320);
        card.setHotel(450);
        properties.add(card);

        //3
        card = deck.get(6);
        card.setName("Oriental Avenue");
        card.setRent(6);
        card.setHouse1(30);
        card.setHouse2(90);
        card.setHouse3(270);
        card.setHouse4(400);
        card.setHotel(550);
        properties.add(card);

        //4
        card = deck.get(8);
        card.setName("Vermont Avenue");
        card.setRent(6);
        card.setHouse1(30);
        card.setHouse2(90);
        card.setHouse3(270);
        card.setHouse4(400);
        card.setHotel(550);
        properties.add(card);


        //5
        card = deck.get(9);
        card.setName("Connecticut Avenue");
        card.setRent(8);
        card.setHouse1(40);
        card.setHouse2(100);
        card.setHouse3(300);
        card.setHouse4(450);
        card.setHotel(600);
        properties.add(card);


        //6
        card = deck.get(11);
        card.setName("St. Charles Place");
        card.setRent(10);
        card.setHouse1(50);
        card.setHouse2(150);
        card.setHouse3(450);
        card.setHouse4(625);
        card.setHotel(750);
        properties.add(card);


        //7
        card = deck.get(13);
        card.setName("States Avenue");
        card.setRent(10);
        card.setHouse1(50);
        card.setHouse2(150);
        card.setHouse3(450);
        card.setHouse4(625);
        card.setHotel(750);
        properties.add(card);


        //8
        card = deck.get(14);
        card.setName("Virginia Avenue");
        card.setRent(12);
        card.setHouse1(60);
        card.setHouse2(180);
        card.setHouse3(500);
        card.setHouse4(700);
        card.setHotel(900);
        properties.add(card);



        //9
        card = deck.get(16);
        card.setName("St. James Place");
        card.setRent(14);
        card.setHouse1(70);
        card.setHouse2(200);
        card.setHouse3(550);
        card.setHouse4(750);
        card.setHotel(950);
        properties.add(card);



        //10
        card = deck.get(18);
        card.setName("Tennessee Avenue");
        card.setRent(14);
        card.setHouse1(70);
        card.setHouse2(200);
        card.setHouse3(550);
        card.setHouse4(750);
        card.setHotel(950);
        properties.add(card);



        //11
        card = deck.get(19);
        card.setName("New York Avenue");
        card.setRent(16);
        card.setHouse1(80);
        card.setHouse2(220);
        card.setHouse3(600);
        card.setHouse4(800);
        card.setHotel(1000);
        properties.add(card);

        //12
        card = deck.get(21);
        card.setName("Kentucky Avenue");
        card.setRent(18);
        card.setHouse1(90);
        card.setHouse2(250);
        card.setHouse3(700);
        card.setHouse4(875);
        card.setHotel(1050);
        properties.add(card);

        //13
        card = deck.get(23);
        card.setName("Indiana Avenue");
        card.setRent(18);
        card.setHouse1(90);
        card.setHouse2(250);
        card.setHouse3(700);
        card.setHouse4(875);
        card.setHotel(1050);
        properties.add(card);

        //14
        card = deck.get(24);
        card.setName("Illinois Avenue");
        card.setRent(20);
        card.setHouse1(100);
        card.setHouse2(300);
        card.setHouse3(750);
        card.setHouse4(925);
        card.setHotel(1100);
        properties.add(card);


        //15
        card = deck.get(26);
        card.setName("Atlantic Avenue");
        card.setRent(22);
        card.setHouse1(110);
        card.setHouse2(330);
        card.setHouse3(800);
        card.setHouse4(975);
        card.setHotel(1150);
        properties.add(card);


        //16
        card = deck.get(27);
        card.setName("Ventnor Avenue");
        card.setRent(22);
        card.setHouse1(110);
        card.setHouse2(330);
        card.setHouse3(800);
        card.setHouse4(975);
        card.setHotel(1150);
        properties.add(card);

        //17
        card = deck.get(29);
        card.setName("Marvin Gardens");
        card.setRent(24);
        card.setHouse1(120);
        card.setHouse2(360);
        card.setHouse3(850);
        card.setHouse4(1025);
        card.setHotel(1200);
        properties.add(card);

        //18
        card = deck.get(31);
        card.setName("Pacific Avenue");
        card.setRent(26);
        card.setHouse1(130);
        card.setHouse2(390);
        card.setHouse3(900);
        card.setHouse4(1100);
        card.setHotel(1275);
        properties.add(card);

        //19
        card = deck.get(32);
        card.setName("North Carolina Avenue");
        card.setRent(26);
        card.setHouse1(130);
        card.setHouse2(390);
        card.setHouse3(900);
        card.setHouse4(1100);
        card.setHotel(1275);
        properties.add(card);

        //20
        card = deck.get(34);
        card.setName("Pennsylvania Avenue");
        card.setRent(28);
        card.setHouse1(150);
        card.setHouse2(450);
        card.setHouse3(1000);
        card.setHouse4(1200);
        card.setHotel(1400);
        properties.add(card);

        //21
        card = deck.get(37);
        card.setName("Park Place");
        card.setRent(35);
        card.setHouse1(175);
        card.setHouse2(500);
        card.setHouse3(1100);
        card.setHouse4(1300);
        card.setHotel(1500);
        properties.add(card);

        //22
        card = deck.get(39);
        card.setName("Boardwalk");
        card.setRent(50);
        card.setHouse1(200);
        card.setHouse2(600);
        card.setHouse3(1400);
        card.setHouse4(1700);
        card.setHotel(2000);
        properties.add(card);

        MonopolyLogic.deck=deck;
        //TODO find out how to represent railroads and adjust rent based off how many you own

        /*
        System.out.println("Player : " + MonopolyLogic.solveGame(players,positions,deck,turn) + " won!\n");
        if(MonopolyLogic.crossedInt){
            System.out.println("By crossing Max int!");
        }

         */
    }
}
