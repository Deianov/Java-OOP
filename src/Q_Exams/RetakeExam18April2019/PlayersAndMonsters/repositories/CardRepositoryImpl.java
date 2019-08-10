package Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.cards.interfaces.Card;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.interfaces.CardRepository;

import java.util.*;

public class CardRepositoryImpl implements CardRepository {
    private Map<String, Card> cards;

    public CardRepositoryImpl() {
        this.cards = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.cards.values().size();
    }

    @Override
    public List<Card> getCards() {
        return Collections.unmodifiableList(new ArrayList<>(this.cards.values()));
    }

    @Override
    public void add(Card card) {
        if (card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        if(this.cards.containsKey(card.getName())){
            throw new IllegalArgumentException(String.format(
                    "Card %s already exists!", card.getName()));
        }
        this.cards.put(card.getName(), card);
    }

    @Override
    public boolean remove(Card card) {
        if(card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        if (this.cards.containsKey(card.getName())){
            this.cards.remove(card.getName());
            return true;
        }
        return false;
    }

    @Override
    public Card find(String name) {
        Card card = this.cards.get(name);
        return card;
    }
}
