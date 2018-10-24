import java.util.*;

class Cards {
    // create possible card combinations
    private static final String[] SUITS = {
        "H", "D", "C", "S"
    };
    private static final String[] RANKS = {
        "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"
    };

    private List<String> cards;

    public Cards() {
        this.cards = new LinkedList<>();
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length; j++) {
                this.cards.add(RANKS[j] + SUITS[i]);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public String drawCard() throws NoSuchElementException {
        if (this.cards.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.cards.remove(0);
    }

    public void returnCard(String card) {
        this.cards.add(card);
    }

    public void toString() {
        return String.join(" ", this.cards);
    }
}