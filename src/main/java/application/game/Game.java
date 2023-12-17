package application.game;

import java.util.List;

public class Game {

    private final List<Integer> numbers;

    public Game(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMatchingNumberCount(WinGame winGame) {
        int matchingNumberCount = (int) numbers.stream().filter(number -> winGame.hasNumberOf(number)).count();

        return matchingNumberCount;
    }

    public boolean hasBonusNumber(WinGame winGame) {
        for (int number : numbers) {
            if (winGame.isBonusNumber(number)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
