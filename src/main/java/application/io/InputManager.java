package application.io;

import java.util.Scanner;

public class InputManager {

    private final Scanner scanner;

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public int getGameCount() {
        InputView.printInputGameCountRequestMessage();
        int gameCount = scanner.nextInt();
        validGameCount(gameCount);

        return gameCount;
    }

    private void validGameCount(int gameCount) {
        if (gameCount < 1 || gameCount > 5) {
            throw new IllegalArgumentException("유효하지 않은 게임 수 입니다.");
        }
    }
}
