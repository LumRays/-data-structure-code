import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {
    public static final String[] SUITS = {"♠", "♥", "♣", "♦"};
    public static List<Card> buyCards() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j,SUITS[i]);
                cardList.add(card);
            }
            System.out.println();
        }
        return cardList;
    }

    public static void shuffle(List<Card> cardList) {
        for (int i = cardList.size() - 1; i > 0; i--) {
            Random random = new Random();
            int index = random.nextInt(i);//[0,i)
            swap(cardList,i,index);
        }
    }

    private static void swap(List<Card> cardList,int x,int y) {
        Card tmp = cardList.get(x);
        cardList.set(x,cardList.get(y));
        cardList.set(y,tmp);
    }

    public static void main(String[] args) {
        List<Card> cardList = buyCards();
        System.out.println(cardList);

        System.out.println("洗牌：");
        shuffle(cardList);
        System.out.println(cardList);
        System.out.println("揭牌：");

        List<Card> hand0 = new ArrayList<>();

        List<Card> hand1 = new ArrayList<>();

        List<Card> hand2 = new ArrayList<>();
        //此时定义了一个二维数组
        List<List<Card>> hands = new ArrayList<>();
        hands.add(hand0);
        hands.add(hand1);
        hands.add(hand2);

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 3; j++) {
                Card card = cardList.remove(0);
                hands.get(j).add(card);
            }

        }

        System.out.println("第一个玩家的手牌：");
        System.out.println(hand0);

        System.out.println("第二个玩家的手牌：");
        System.out.println(hand1);

        System.out.println("第三个玩家的手牌：");
        System.out.println(hand2);

        System.out.println("剩下的牌：");
        System.out.println(cardList);
    }
}
