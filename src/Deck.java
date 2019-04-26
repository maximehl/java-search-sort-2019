import java.util.Arrays;
import java.util.Collections;

public class Deck {
    public Card[] allCards = new Card[13];
    public Card[] hand;

    public Deck(){
        for(int n = 2; n<15; n++){
            allCards[n-2] = new Card(n);
        }
    }

    public void swap(int first, int second){
        Card save;
        save = hand[first];
        hand[first] = hand[second];
        hand[second] = save;
    }

    public void dealHand(int numCards){
        hand = new Card[numCards];
        for(int n = 0; n<numCards; n++){
            hand[n] = allCards[n];
        }
        listHand();
    }

    public void listHand(){
        System.out.println();
        for(int n = 0; n<hand.length; n++){
            System.out.print(hand[n].name + " ");
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(Arrays.asList(allCards));
    }

    public void bubbleSortHand(){
        for(int n1 = 0; n1<hand.length; n1++){
            for(int n2 = 1; n2<hand.length-n1; n2++){
                if(hand[n2-1].value>hand[n2].value){
                    swap(n2-1, n2);
                }
            }
        }
    }

    public void selectionSortHand(){
        int lowIndex;
        for(int n1 = 0; n1<hand.length; n1++){
            lowIndex = n1;
            for(int n2 = n1; n2<hand.length; n2++){
                if(hand[n2].value<hand[lowIndex].value){
                    lowIndex = n2;
                }
            }
            swap(n1, lowIndex);
        }
    }

    public Card[] mergeSortHand(Card[] subArr, Card[] topHalf, Card[] bottomHalf){
        if(subArr.length==0){
            Card[] retArr = new Card[topHalf.length + bottomHalf.length];
            int j = 0;
            int k = 0;
            while(j<topHalf.length||k<bottomHalf.length){
                if(j==topHalf.length){
                    retArr[j+k] = bottomHalf[k];
                    k++;
                }else if(k==bottomHalf.length){
                    retArr[j+k] = topHalf[j];
                    j++;
                }else if(topHalf[j].value>bottomHalf[k].value){
                    retArr[j+k] = bottomHalf[k];
                    k++;
                }else{
                    retArr[j+k] = topHalf[j];
                    j++;
                }
            }
            return retArr;
        }
        if(subArr.length<2){
            return subArr;
        }else {
            return mergeSortHand(new Card[0], mergeSortHand(Arrays.copyOfRange(subArr, 0, subArr.length / 2), new Card[0], new Card[0]), mergeSortHand(Arrays.copyOfRange(subArr, subArr.length / 2, subArr.length), new Card[0], new Card[0]));
        }
    }

    public int binarySearch(int val){
        int uIndex = hand.length;
        int bIndex = 0;
        int mIndex = (uIndex/2);
        while(uIndex!=bIndex&&hand[mIndex].value!=val){
            mIndex = (uIndex+bIndex)/2;
            if(hand[mIndex].value>val){
                uIndex = mIndex;
            }else{
                bIndex = mIndex+1;
            }
        }
        if(hand[mIndex].value==val){
            return mIndex;
        }else{
            return hand.length;
        }
    }
}
