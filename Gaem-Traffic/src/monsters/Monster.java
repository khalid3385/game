package monsters;

import door.AnswerObserver;
import player.Player;

public interface Monster extends AnswerObserver {
    String getNaam();
    int getSchade();
    void valAan(Player speler);
    void verwijder();
}
