package monsters;

import player.Player;

public class Creeper implements Monster {
    @Override
    public String getNaam() {
        return "Creeper";
    }

    @Override
    public int getSchade() {
        return 5;
    }

    @Override
    public void valAan(Player speler) {
        speler.decreaseHP(getSchade());
        System.out.println("💥 De Creeper explodeert! Je verliest " + getSchade() + " HP.");
    }

    @Override
    public void verwijder() {
        System.out.println("💨 De Creeper verdwijnt in het niets.");
    }

    @Override
    public void update(boolean correct) {
        if (!correct) {
            System.out.println("💢 De Creeper wordt woedend en valt aan!");
        } else {
            System.out.println("😴 De Creeper blijft AFK");
        }
    }
}
