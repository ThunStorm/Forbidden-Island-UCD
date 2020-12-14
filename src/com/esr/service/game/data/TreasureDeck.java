package com.esr.service.game.data;

import com.esr.gui.updater.TreasureUpdater;
import com.esr.service.game.component.cards.handcards.TreasureCard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description
 * @Author William
 * @Date 2020/12/8
 * @Version 1.0
 **/
public class TreasureDeck {
    private ArrayList<Integer> treasureDeck;
    private ArrayList<Integer> discardPile;
    private ArrayList<Integer> NTreasureCards;
//    private ArrayList<Integer> displayedCards;
//    private int displayNum = 2;

    public TreasureDeck() {
        treasureDeck = new ArrayList<>();
        discardPile = new ArrayList<>();
//        displayedCards = new ArrayList<>();
        NTreasureCards = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            treasureDeck.add(i);
        }
        Collections.shuffle(treasureDeck);
//        System.out.println(floodDeck);
    }

    public ArrayList<Integer> getNTreasureCards(int n) {
        checkAvailability(n);
        NTreasureCards.clear();
        NTreasureCards.addAll(treasureDeck.subList(0, n));
        if (n > 0) {
            treasureDeck.subList(0, n).clear();
        }
        return NTreasureCards;
    }

    public ArrayList<Integer> getNNoRiseCards(int n) {
        checkAvailability(n);
        NTreasureCards.clear();
        int count = 0;
        for (int i = 0; i < treasureDeck.size(); i++) {
            if (treasureDeck.get(0) >= 25 && treasureDeck.get(0) <= 27){
                Discard(treasureDeck.get(0));
            }
            else {
                NTreasureCards.add(treasureDeck.get(0));
                count ++;
            }
            treasureDeck.remove(0);
            if (count >= n){
                break;
            }
        }
        return NTreasureCards;
    }

    public void Discard(int treasureID){
        discardPile.add(treasureID);
    }

// useless
    public void PutBack(){
        Collections.shuffle(discardPile);
        treasureDeck.clear();
        treasureDeck.addAll(discardPile);
        discardPile.clear();
    }

    private void checkAvailability(int n){
        if (treasureDeck.size() < n){
            Collections.shuffle(discardPile);
            treasureDeck.addAll(discardPile);
            discardPile.clear();
        }
    }

    //needed to check the number of the rest of cards
}
