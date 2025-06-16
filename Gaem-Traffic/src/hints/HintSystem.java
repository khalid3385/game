package hints;

import java.util.List;
import java.util.Random;

public class HintSystem {
    private List<HintProvider> hintProviders;
    private Random random = new Random();

    public HintSystem(List<HintProvider> hintProviders) {
        this.hintProviders = hintProviders;
    }

    public String geefHint() {
        HintProvider gekozenProvider = hintProviders.get(random.nextInt(hintProviders.size()));
        return gekozenProvider.geefHint();}

    public void toonHintAlsGewenst(String antwoord) {
        if (antwoord.trim().equalsIgnoreCase("ja")) {
            HintProvider gekozenProvider = hintProviders.get(random.nextInt(hintProviders.size()));
            System.out.println("Hint: " + gekozenProvider.geefHint());
        } else {
            System.out.println("Geen hint. Succes verder!");
        }
    }

}


