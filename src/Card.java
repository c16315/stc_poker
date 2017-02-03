
import java.util.ArrayList;
import java.util.List;

/**
 *  手札
 * @author c16315　長沼あや
 * 先生が作ったcardクラス
 */

public class Card {

    
    public enum Suit {
        Diamond(0),Spade(1),Clovar(2),Heart(3);

        private int id;
        
        private String[] SuitName={"♢","♠","♣","♡"};

        Suit(int id){
            this.id=id;
        }
        
        int getId(){
            return id;
        }
        
        String getSuitName(){
            return SuitName[id];
        }
    }
    
    public enum Rank {
        A(1),Two(2),Three(3),Four(4),Five(5),Six(6),Seven(7),Eight(8),Nine(9),Ten(10),J(11),Q(12),K(13);

        private int id;

        Rank(int id){
            this.id=id;
        }
        
        int getId(){
            return id;
        }
    }
    
    static final List<Card> deck=new ArrayList<>();
    
    private final Suit suit;
    private final Rank rank;
    
    Card(Suit suit,Rank rank){
        this.suit=suit;
        this.rank=rank;
    }
    
    static{
        for(Suit suit:Suit.values()){
            for(Rank rank:Rank.values()){
                deck.add(new Card(suit,rank));
            }
        }
    }
    
    public static ArrayList<Card> newDeck(){
        return new ArrayList<Card>(deck);
    }
    
    Suit getSuit(){
        return suit;
    }
   
    Rank getRank(){
        return rank;
    }
}
