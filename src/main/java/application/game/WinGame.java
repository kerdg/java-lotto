package application.game;

import java.util.List;

public class WinGame {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinGame(int bonusNumber, List<Integer> numbers) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean hasNumberOf(int number) {
        return numbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }

    @Override
    public String toString() {
        return String.format("당첨번호: %s\n보너스 번호: [%d]", numbers.toString(), bonusNumber);
    }
}
