package application.game;

import application.RandomNumberGenerator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameGenerator {

    private final RandomNumberGenerator randomNumberGenerator;

    public GameGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Game generateGame() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != 6) {
            int randomNumber = randomNumberGenerator.generateRandomNumber(1, 45);
            numbers.add(randomNumber);
        }

        return new Game(numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
