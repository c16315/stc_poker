
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c16315
 */
public class Player {
    
    String name;              //playerの名前を入れるための変数
    private List<Card> hand;  //playerの手札を入れるための変数
    
    int i,j;                //for分用
    int max=0,maximum=0;    //比較用
    int str=0;              //役物用
    int count=0;            //判定するときに使う変数
    
    
    public Player(String name){
        this.name=name;
        hand = new ArrayList<>();
    }
    
    
    //カード捨てるためのメソッド
    Card drawOut(int index){
        return hand.remove(index);
    }
    
    //カードを引くためのメソッド
    void drawIn(List<Card> deck){
        //山札から一枚引く
        hand.add(deck.remove(0));
    }
    
    //カードを入れ替えるためのメソッド
    void drawIn(int index,List<Card> deck){
        //山札から一枚引く
        hand.set(index,deck.remove(0));
    }
    
    //playerたちの手札
    List getHand(){
        return new ArrayList<Card>(hand);
    }
    
    
    void setHand(List hand){
        this.hand=hand;
    }
    
    int getStr(){
        return str;
    }
    
    void setStr(int set){
        this.str=str;
    }
    
    int getMax(){
       return max; 
    }
    
    void setMax(int max){
        this.max=max;
    }

    /*判定するためのメソッド*/
    void Decision(){
        int three=0;      //スリーカード用の変数
        int four=0;       //フォーカード用の変数
        
        /*手札に同じ数があるか調べる*/
        for(i=0;i<4;i++){
            count=0;
            if(three==hand.get(i).getRank().getId() || four==hand.get(i).getRank().getId()){
                break;
            }
            for(j=i+1;j<5;j++){
                if(i != j && hand.get(i).getRank().getId()==hand.get(j).getRank().getId()){
                    /*同じ数だったらカウントする*/
                    count++;
                }
                max=Check(hand.get(i).getRank().getId(),max);
            }
            
            /*countから適応する役柄を表示するためにstrの中に数字を入れる*/
            switch(count){
                case 1:
                    if(str==1){
                        str=2;      
                    }else{
                        str=1;      
                    }
                    break;
                case 2:
                    str=3;
                    three=hand.get(i).getRank().getId();
                    break;
                case 3:
                    str=4;
                    four=hand.get(i).getRank().getId();
                    break;
            }
        }
        
        /*役柄を表示する*/
        switch(str){
            case 0:
                System.out.println(max);
                break;
            case 1:
                System.out.println("one pair");
                break;
            case 2:
                System.out.println("two pair");
                break;
            case 3:
                System.out.println("three card");
                break;
            case 4:
                System.out.println("four card");
                break;
        }
        System.out.println();
    }
    
    /*変数maxに大きい数を入れるためのメソッド*/
    int Check(int a,int b){
        int big=0;
        if(a>b){
            big=a;
        }else{
            big=b;
        }
        return big;
        
    }
    
}
