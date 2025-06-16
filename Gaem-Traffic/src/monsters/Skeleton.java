package monsters;

import player.Player;

public class Skeleton implements Monster {
    @Override
    public String getNaam() {
        return "Skeleton";
    }

    @Override
    public int getSchade() {
        return 15;
    }

    @Override
    public void valAan(Player speler) {
        speler.decreaseHP(getSchade());
        System.out.println("💀 De Skeleton schiet een pijl! Je verliest " + getSchade() + " HP.");
    }

    @Override
    public void verwijder() {
        System.out.println("💨 De Skeleton verdwijnt in het niets.");
    }

    @Override
    public void update(boolean correct) {
        if (!correct) {
            System.out.println("💢 De Skeleton wordt woedend en valt aan!");
        } else {
            System.out.println("😴 De Skeleton blijft stil.");
        }
    }
}
