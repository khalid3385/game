package monsters;

import player.Player;

public class ChickenJockey implements Monster {
    @Override
    public String getNaam() {
        return "Chicken Jockey";
    }

    @Override
    public int getSchade() {
        return 25;
    }

    @Override
    public void valAan(Player speler) {
        speler.decreaseHP(getSchade());
        System.out.println("💥 De Chicken Jockey valt aan! Je verliest " + getSchade() + " HP.");
    }

    @Override
    public void verwijder() {
        System.out.println("💨 De Chicken Jockey verdwijnt in het niets.");
    }

    @Override
    public void update(boolean correct) {
        if (!correct) {
            System.out.println("🐔💢 De Chicken Jockey wordt woedend en valt aan!");
        } else {
            System.out.println("🐔😴 De Chicken Jockey blijft stil.");
        }
    }
}
