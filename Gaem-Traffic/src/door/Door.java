package door;

public class Door implements AnswerObserver {
    private boolean open = false;

    @Override
    public void update(boolean correct) {
        if (correct) {
            open = true;
            System.out.println("\n 🚪 De deur gaat open!");
        } else {
            open = false;
            System.out.println("🚪 De deur blijft gesloten.");
        }
    }

    public boolean isOpen() {
        return open;
    }
}
