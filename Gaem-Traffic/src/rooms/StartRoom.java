package rooms;

import hints.HintSystem;
import player.Player;

public class StartRoom extends Room {
    private final Player player;

    public StartRoom(HintSystem hintSystem, Player player) {
        super(hintSystem,"Start Room"); // ✅ hier geef je de naam door
        this.player = player;
    }

    @Override
    public void enter() {
        player.nextRoom();
        System.out.println("🎮 Welkom in het spel!");
        System.out.println("Gebruik /help voor commands.");
        System.out.println("Succes!\n");
    }

    @Override
    public void stelVraag() {
    }
}
