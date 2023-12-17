package application.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {

    @Test
    @DisplayName("matchingNumberCount가 0인 경우")
    void getMatchingNumberCount_MatchingNumberCountIs0() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(11, 12, 13, 14, 15, 16);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        int matchingNumberCount = game.getMatchingNumberCount(winGame);

        assertThat(matchingNumberCount).isEqualTo(0);
    }

    @Test
    @DisplayName("matchingNumberCount가 1인 경우")
    void getMatchingNumberCount_MatchingNumberCountIs1() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 12, 13, 14, 15, 16);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        int matchingNumberCount = game.getMatchingNumberCount(winGame);

        assertThat(matchingNumberCount).isEqualTo(1);
    }

    @Test
    @DisplayName("matchingNumberCount가 2인 경우")
    void getMatchingNumberCount_MatchingNumberCountIs2() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 13, 14, 15, 16);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        int matchingNumberCount = game.getMatchingNumberCount(winGame);

        assertThat(matchingNumberCount).isEqualTo(2);
    }

    @Test
    @DisplayName("matchingNumberCount가 3인 경우")
    void getMatchingNumberCount_MatchingNumberCountIs3() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 14, 15, 16);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        int matchingNumberCount = game.getMatchingNumberCount(winGame);

        assertThat(matchingNumberCount).isEqualTo(3);
    }

    @Test
    @DisplayName("matchingNumberCount가 4인 경우")
    void getMatchingNumberCount_MatchingNumberCountIs4() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 15, 16);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        int matchingNumberCount = game.getMatchingNumberCount(winGame);

        assertThat(matchingNumberCount).isEqualTo(4);
    }

    @Test
    @DisplayName("matchingNumberCount가 5인 경우")
    void getMatchingNumberCount_MatchingNumberCountIs5() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 16);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        int matchingNumberCount = game.getMatchingNumberCount(winGame);

        assertThat(matchingNumberCount).isEqualTo(5);
    }

    @Test
    @DisplayName("matchingNumberCount가 6인 경우")
    void getMatchingNumberCount_MatchingNumberCountIs6() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        int matchingNumberCount = game.getMatchingNumberCount(winGame);

        assertThat(matchingNumberCount).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 번호가 있는 경우")
    void hasBonusNumber_true() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 45);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        boolean hasBonusNumber = game.hasBonusNumber(winGame);

        assertThat(hasBonusNumber).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 있는 경우")
    void hasBonusNumber_false() {
        int bonusNumber = 45;
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinGame winGame = new WinGame(bonusNumber, winNumbers);
        Game game = new Game(userNumbers);

        boolean hasBonusNumber = game.hasBonusNumber(winGame);

        assertThat(hasBonusNumber).isFalse();
    }
}