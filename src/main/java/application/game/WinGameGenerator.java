package application.game;

import application.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinGameGenerator {

    private final RandomNumberGenerator randomNumberGenerator;

    public WinGameGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public WinGame generateGame() {
        Set<Integer> distinctNumbers = new HashSet<>();
        while (distinctNumbers.size() != 7) {
            int randomNumber = randomNumberGenerator.generateRandomNumber(1, 45);
            distinctNumbers.add(randomNumber);
        }

        Iterator<Integer> iterator = distinctNumbers.iterator();
        List<Integer> gameNumbers = new ArrayList<>();
        int bonusNumber = iterator.next();
        while (iterator.hasNext()) {
            gameNumbers.add(iterator.next());
        }

        return new WinGame(bonusNumber, gameNumbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
