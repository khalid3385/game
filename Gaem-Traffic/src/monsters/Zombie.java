package monsters;

import player.Player;

public class Zombie implements Monster {
    @Override
    public String getNaam() {
        return "Zombie";
    }

    @Override
    public int getSchade() {
        return 10;
    }

    @Override
    public void valAan(Player speler) {
        speler.decreaseHP(getSchade());
        System.out.println("🧟 De Zombie bijt! Je verliest " + getSchade() + " HP.");
    }

    @Override
    public void verwijder() {
        System.out.println("💨 De Zombie verdwijnt in het niets.");
    }

    @Override
    public void update(boolean correct) {
        if (!correct) {
            System.out.println("💢 De Zombie wordt woedend en valt aan!");
        } else {
            System.out.println("😴 De Zombie blijft stil.");
        }
    }
}
