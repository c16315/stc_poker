
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *@author c16315　長沼　あや
 * テスタークラス
 */

public class Main {
    //tester
    public static void main(String[] args){
        List<Card> cards=Card.newDeck();    //トランプ１セット用意
        
        //listの並びをランダムにする
        Collections.shuffle(cards);
        
        Player one=new Human("one");
        Player uno=new Cpu("first");
        
        /*手札*/
        for(int i=0;i<5;i++){
            one.drawIn(cards);
            uno.drawIn(cards);
        }
        
        /*playerの手札表示*/
        List<Card> one_card=one.getHand();
        for(Card name:one_card){
            System.out.print(name.getSuit().getSuitName() +""+ name.getRank().getId()+" ");
        }
        
        System.out.println();

        int d;
        int i=0;
        Scanner stdIn = new Scanner(System.in);
        

        /*引き直し*/
        System.out.print("捨てる場合は番号、捨てない場合は6>>");
        d=stdIn.nextInt();
        if(d!=6){
            int vallen = String.valueOf(d).length();
            int num=(int)Math.pow(10, vallen-1);

            for(i=num;i>=1;i/=10){
                int m=d/i;
                one.drawIn(m-1,cards);
                d=d-m*i;
            }
        }
        
        /*playerの手札表示*/
        one_card=one.getHand();
        System.out.print("player:");
        for(Card name:one_card){
            System.out.print(name.getSuit().getSuitName() +""+ name.getRank().getId()+" ");
        }
        System.out.println();
        
        one.Decision();
        
        /*cpuの手札表示*/
        System.out.print("cpu:");
        List<Card> uno_card=uno.getHand();
        for(Card name:uno_card){
            System.out.print(name.getSuit().getSuitName() +""+ name.getRank().getId()+" ");
        }
        System.out.println();
        
        uno.Decision();
        
        
        /*最大の数を比べて勝敗を判定する*/
        if(one.getStr()>uno.getStr()){
            System.out.println("プレイヤーの勝ち");
        }else if(one.getStr()<uno.getStr()){
            System.out.println("プレイヤーの負け");
        }else{
            if(one.max>uno.max && one.getStr()==0){
                System.out.println("プレイヤーの勝ち");
            }else if(one.max<uno.max && one.getStr()==0){
                System.out.println("プレイヤーの負け");
            }else{
                System.out.println("ドロー");
            }
        }
    }
}

