package monopolyLogic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MonopolyLogic {
    public static int round = 0;
    public static ArrayList<Long> players;
    public static ArrayList<MonopolyCard> deck;
    public static ArrayList<Integer> positions;
    public static int turn;
    public static HashMap<Integer, Integer> jailed;
    public static Random random;
    public static boolean crossedInt;




    //TODO implement house + hotel options that will increment the amount of rent for properties
    //TODO implement jail feature
    //TODO implement losing/ winning order
    //TODO implement 'Best of' option that will let you decide how many games you want to base the winner off of
    //TODO implement a game summary of what happened - how many rounds? -mvp property that got you the most rent. what rounds did other players lose at?  If best of, maybe do averages between all the games
    /**
     * Pass in the arrayList of players with their values (amount of money they contain).
     * @param players
     * @return who won
     */
    public static int solveGame(ArrayList<Long> players, ArrayList<Integer> positions, ArrayList<MonopolyCard> deck, int turn){
        MonopolyLogic.players=players;
        MonopolyLogic.deck=deck;
        MonopolyLogic.positions = positions;
        MonopolyLogic.turn = turn;
        MonopolyLogic.random = new Random();
        MonopolyLogic.crossedInt = false;

        MonopolyLogic.jailed = new HashMap<>();

        System.out.println("hello");
        while(!checkForWinner()){
            System.out.println(Integer.MAX_VALUE);
            System.out.println(MonopolyLogic.players.get(0));
            System.out.println(MonopolyLogic.players.get(1));
            //  System.out.println("Player : " + turn + " turn");
            // System.out.println("Balance before : " + players.get(turn));
            playerRoll(MonopolyLogic.turn);
            // System.out.println("Balance after : " + players.get(turn));
            // System.out.println("End turn\n\n");
            MonopolyLogic.turn = (MonopolyLogic.turn + 1) % players.size();
            System.out.println("up next:" + MonopolyLogic.turn);
            System.out.println("Player 0 position:" + positions.get(0) + " Player 1 position:" + positions.get(1));
            System.out.println(jailed.toString());
            System.out.println("turn of : " + MonopolyLogic.turn);
            round++;
            //repeat game
        }
        return getWinner();
    }

    public static int getWinner(){
        int max = 0;
        for(int i = 0; i < MonopolyLogic.players.size(); i++){
            if(MonopolyLogic.players.get(i) > MonopolyLogic.players.get(max)){
                max = i;
            }
        }
        return max;
    }

    /**
     * The rolling method used for rolling the dice.
     * @return The sum of the roll.
     */
    public static int rollDice(){
        // TODO change this to 2 different random calls to better simulate a dice.
        return random.nextInt(11) + 2;
    }

    /**
     * Checks to see if there is a new winner between rounds by checking if anyone has gone bankrupt.
     * @return true if a winner is found, false if not.
     */
    public static boolean checkForWinner(){
        //TODO figure out how to check if someone goes over int size, and figure out how to extend this to more than 2 players.
        if(MonopolyLogic.crossedInt){
            return true;
        }
        int count = 0;
        for(int i = 0; i < players.size(); i++){
            if(MonopolyLogic.players.get(i) > 0){
                count++;
            }
        }
        if(count<2){
            return true;
        }
        return false;
    }

    /**
     * Starts a player's turn by rolling the dice for them, updating their position on the board, and calling on exchange()
     * @param player - the index of the player who is rolling
     */
    public static void playerRoll(int player){
        System.out.println("Currently rolling player:" + MonopolyLogic.turn);
        System.out.println("player : " + player);

        if(MonopolyLogic.jailed.containsKey(MonopolyLogic.turn)){
            if(MonopolyLogic.jailed.get(MonopolyLogic.turn) < 3) {
                MonopolyLogic.jailed.put(MonopolyLogic.turn, MonopolyLogic.jailed.get(MonopolyLogic.turn) + 1);
                return;
            }
            System.out.println("Player : " + MonopolyLogic.turn + " is out of jail.");
            MonopolyLogic.jailed.remove(MonopolyLogic.turn);
        }
        int pos = MonopolyLogic.positions.get(player);
        int roll = rollDice();
        int currPos = (pos + roll);
        if(currPos >= 40){
            playerAdd(player, 200);
            currPos = currPos % 40;
        }
        //check if an event occurs
        event(currPos);
        MonopolyLogic.positions.set(player, currPos);
        //check if any rent is due
        exchange(currPos, player);
    }

    public static void event(int currPos){
        System.out.println("jail check for turn: " + turn );
        if(currPos == 30){
            System.out.println("worked");
        }
        else{
            System.out.println("didn't work");
        }
        if(currPos == 30){
            System.out.println("checking for jail");
            //Player is added to the jail list

            MonopolyLogic.jailed.put(turn, 0);
            System.out.println("Jail time for player: " + turn);
            //moving player to jail spot
            MonopolyLogic.positions.set(turn, 10);
            return;
        }
    }

    /**
     * This method basically looks into what the current player must do at the spot he landed
     * @param position - the position the player landed at
     * @param player - the index of the player who just rolled
     */
    public static void exchange(int position, int player){
        MonopolyCard card = MonopolyLogic.deck.get(position);
        int rent = card.getRent();
        int owner = card.getOwner();
        if(owner > -1 && player != owner) {
            // System.out.println("Balance before : " + players.get(turn));
            System.out.println("Roll number: " + MonopolyLogic.round);
            System.out.println("Player : " + MonopolyLogic.turn + " with balance : " + MonopolyLogic.players.get(MonopolyLogic.turn) + " is paying : " + rent + " to player : " + owner);
            System.out.println();
            // System.out.println("Balance before : " + players.get(turn));
            playerRemove(player, rent);
            playerAdd(owner, rent);
        }
    }

    public static void playerRemove(int player, int value){
        long total = MonopolyLogic.players.get(player);
        MonopolyLogic.players.set(player, total - value);
    }

    public static void playerAdd(int player, int value){
        long total = MonopolyLogic.players.get(player);
        MonopolyLogic.players.set(player, total + value);
        if (MonopolyLogic.players.get(player) >= Integer.MAX_VALUE){
            System.out.println("changing crossedInt to true");
            MonopolyLogic.crossedInt = true;
        }
    }

}
