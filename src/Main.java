public class Main {
    public static void main(String[] args) {
        Card[] deck = genCards();
        Card[] sorted = sort(deck);
        for (Card c : sorted) {
            System.out.println(c);
        }
    }

    public static Card[] genCards() {
        Card[] cards = new Card[52];
        for (int i = 2, k = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                cards[k] = new Card(Suit.values()[j], i);
                k++;
            }
        }
        return cards;
    }

    public static Card[] sort(Card[] input) {
        for(int i = 0; i < input.length; i++) {
            for(int j = 1; j < (input.length - i); j++) {
                if (input[j-1].compareTo(input[j]) > 0) {
                    Card temp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

    public static class Card implements Comparable<Card>{
        private Suit suit;
        private int rank; // 2 - 14

        public Card(Suit suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() {
            return suit;
        }

        public void setSuit(Suit suit) {
            this.suit = suit;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "suit=" + suit +
                    ", rank=" + rank +
                    '}';
        }

        @Override
        public int compareTo(Card o) {
            return (suit.getWeight() * 100 + rank) - (o.suit.getWeight() * 100 + o.rank);
        }
    }

    public enum Suit {
        DIAMONDS(4), CLUBS(3), HEARTS(2), SPADES(1);

        int weight;
        private Suit(int w) {
            weight = w;
        }

        public int getWeight() {
            return  weight;
        }
    }
}