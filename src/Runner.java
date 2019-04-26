public class Runner {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffleDeck();
        d.dealHand(7);
        d.bubbleSortHand();
        d.listHand();

        d.shuffleDeck();
        d.dealHand(7);
        d.selectionSortHand();
        d.listHand();

        d.shuffleDeck();
        d.dealHand(7);
        d.hand = d.mergeSortHand(d.hand, new Card[0], new Card[0]);
        d.listHand();
        System.out.println("\nSearching for the queen...");
        System.out.println("desired index: " + d.binarySearch(12));
    }
}
