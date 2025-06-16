package rooms;

import door.AnswerObserver;
import door.AnswerSubject;
import hints.HintSystem;
import interfaces.Questionable;
import interfaces.Hintable;
import monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Questionable, Hintable, AnswerSubject {
    protected String naam;
    protected final HintSystem hintSystem;
    protected Monster monster = null;
    protected boolean monsterGeactiveerd = false;
    private boolean hintJokerGebruikt = false;

    private final List<AnswerObserver> observers = new ArrayList<>();

    public Room(HintSystem hintSystem, String naam) {
        this.hintSystem = hintSystem;
        this.naam = naam;
    }

    // Observer pattern implementatie
    @Override
    public void addObserver(AnswerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AnswerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(boolean correct) {
        for (AnswerObserver o : observers) {
            o.update(correct);
        }
    }

    public abstract void enter();

    @Override
    public void vraagOmHint() {
        System.out.println("Deze kamer heeft geen hint.");
    }

    public void revealHintJoker() {
        System.out.println("🎁 Joker gebruikt! Je krijgt een hint:");
        hintSystem.toonHintAlsGewenst("ja");
    }

    protected void spawnMonsterIfChance(Monster monsterOptie, double kans) {
        if (Math.random() < kans) {
            this.monster = monsterOptie;
            System.out.println("👹 Een " + monster.getNaam() + " staat in deze kamer!");
        }
    }

    public void gebruikHintJoker() {
        if (!hintJokerGebruikt) {
            revealHintJoker();
            hintJokerGebruikt = true;
        } else {
            System.out.println("❌ Hint Joker is al gebruikt in deze kamer.");
        }
    }
}
