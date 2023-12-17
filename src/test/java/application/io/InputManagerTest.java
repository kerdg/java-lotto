package application.io;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputManagerTest {

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0, 6, 7, 8})
    @DisplayName("GameCount가 0이하이거나 6이상일 때 IllegalArgumentException")
    void getGameCount_ThrowsIllegalArgumentException_WhenGameCountIsIllegal(int gameCount) {
        System.setIn(new ByteArrayInputStream(String.valueOf(gameCount).getBytes()));
        InputManager inputManager = new InputManager();

        assertThatThrownBy(() -> inputManager.getGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 게임 수 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("GameCount가 1이상 5이하일 때 유효한 값이다")
    void gameCountIsBetween1And5(int gameCount) {
        System.setIn(new ByteArrayInputStream(String.valueOf(gameCount).getBytes()));
        InputManager inputManager = new InputManager();

        assertThat(inputManager.getGameCount()).isEqualTo(gameCount);
    }
}