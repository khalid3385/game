package rooms;

import door.*;
import hints.HintSystem;
import player.Player;
import vraag.VraagStrategie;

import java.util.Scanner;

public class NormalRoom extends Room {
    private final VraagStrategie vraagStrategie;
    private final Player player;

    public NormalRoom(HintSystem hintSystem, VraagStrategie strategie, Player player) {
        super(hintSystem, "Normal Room");
        this.vraagStrategie = strategie;
        this.player = player;
    }

    @Override
    public void enter() {
        player.nextRoom();
        System.out.println("⚪ Je bent in een normale kamer.");
        spawnMonsterIfChance(new monsters.Zombie(), 0.25);

        addObserver(new Door());
        addObserver(new StatusDisplay());
        if (monster != null) addObserver(monster);

        stelVraag();
    }

    public void stelVraag() {
        Scanner scanner = new Scanner(System.in);
        int pogingen = 0;
        boolean juist = false;

        while (pogingen < 2 && !juist) {
            vraagStrategie.stelVraag();

            String antwoord = scanner.nextLine().trim();
            if (!commands.CommandHandler.verwerk(antwoord)) {
                juist = vraagStrategie.controleerAntwoord(antwoord);
                notifyObservers(juist);
            }

            if (!juist && pogingen == 0) {
                if (monster != null && !monsterGeactiveerd) {
                    monster.valAan(player);
                    monsterGeactiveerd = true;
                }

                System.out.println("Wil je een hint? (ja/nee)");
                String hintAntwoord = scanner.nextLine().trim();
                hintSystem.toonHintAlsGewenst(hintAntwoord);
            }

            pogingen++;
        }
    }
}
