package rooms;

import door.*;
import hints.HintSystem;
import player.Player;
import vraag.VraagStrategie;

import java.util.Scanner;

public class BossRoom extends Room {
    private final VraagStrategie vraagStrategie;
    private final Player player;

    public BossRoom(HintSystem hintSystem, VraagStrategie strategie, Player player) {
        super(hintSystem, "Boss Room");
        this.vraagStrategie = strategie;
        this.player = player;
    }

    @Override
    public void enter() {
        player.nextRoom();
        System.out.println("🔥 Je betreedt de BOSS KAMER!");
        this.monster = new monsters.ChickenJockey();
        System.out.println("👑 De eindbaas verschijnt: " + monster.getNaam());

        addObserver(new Door());
        addObserver(new StatusDisplay());
        addObserver(monster);

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
                if (!monsterGeactiveerd) {
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
