package commands;

import player.Player;
import rooms.Room;

public class CommandHandler {
    private static Player speler;
    private static Room huidigeKamer;
    private static AssistentCommand assistent;

    public static void setPlayer(Player p) {
        speler = p;
    }

    public static void setHuidigeKamer(Room kamer) {
        huidigeKamer = kamer;
    }

    public static boolean verwerk(String input) {
        if (!input.startsWith("/")) return false;

        switch (input.toLowerCase()) {
            case "/help":
                toonHelp();
                return true;
            case "/status":
                toonStatus();
                return true;
            case "/hintjoker":
                gebruikHintJoker();
                return true;
            case "/keyjoker":
                gebruikKeyJoker();
                return true;
            default:
                System.out.println("❌ Onbekende command.");
                return true;
        }
    }

    private static void toonHelp() {
        System.out.println("📖 Beschikbare commands:");
        System.out.println("/help       - Toon deze lijst met commands");
        System.out.println("/status     - Toon je huidige spelerstatus");
        System.out.println("/hintjoker  - Gebruik de Hint Joker");
        System.out.println("/keyjoker   - Gebruik de Key Joker (alleen in KeyJoker-kamer)");
    }

    private static void toonStatus() {
        if (speler == null) {
            System.out.println("⚠ Geen speler geladen.");
        } else {
            System.out.println(speler.getStatus());
        }
    }

    public static void setAssistent(AssistentCommand a) {
        assistent = a;}

    private static void gebruikHintJoker() {
        if (speler == null || huidigeKamer == null) {
            System.out.println("⚠ Joker kan niet worden gebruikt zonder speler of kamer.");
            return;
        }
        speler.getJokerContext().setJoker(new Joker.HintJoker());
        speler.getJokerContext().useJoker(huidigeKamer);
    }

    private static void gebruikKeyJoker() {
        if (speler == null || huidigeKamer == null) {
            System.out.println("⚠ Joker kan niet worden gebruikt zonder speler of kamer.");
            return;
        }
        speler.getJokerContext().setJoker(new Joker.KeyJoker());
        speler.getJokerContext().useJoker(huidigeKamer);
    }
}
