package rooms;

import player.Player;
import hints.HintSystem;

public class SaveRoom extends Room {
    private final Player player;

    public SaveRoom(HintSystem hintSystem, Player player) {
        super(hintSystem, "Save Room");
        this.player = player;
    }

    @Override
    public void enter() {
        player.nextRoom();
        System.out.println("💾 Je bent in een Save Room!");
        System.out.println("Je voelt je opgeladen... +20 HP!");
        player.increaseHP(20);
        System.out.println("Nieuwe HP: " + player.getHP());
    }

    @Override
    public void stelVraag() {
    }
}
