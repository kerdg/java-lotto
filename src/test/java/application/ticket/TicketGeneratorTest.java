package application.ticket;

import application.RandomNumberGenerator;
import application.game.GameGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketGeneratorTest {

    private final TicketGenerator ticketGenerator;

    public TicketGeneratorTest() {
        this.ticketGenerator = new TicketGenerator(new GameGenerator(new RandomNumberGenerator()));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("gameCount 만큼의 게임을 포함한 티켓이 생성되어야 한다.")
    void generatedTicketHasExactGameCount(int gameCount) {
        Ticket ticket = ticketGenerator.generateTicket(gameCount);

        Assertions.assertThat(ticket.hasCountOfGames(gameCount)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("gameCount 1과 5사이여야 한다.")
    void gameCountMustBeBetween1And5(int gameCount) {
        Ticket ticket = ticketGenerator.generateTicket(gameCount);

        Assertions.assertThat(ticket.hasCountOfGames(gameCount)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    @DisplayName("gameCount가 0이하이면 IllegalArgumentException")
    void throwIllegalException_WhenGameCountIsLessThan0(int gameCount) {
        Assertions.assertThatThrownBy(() -> ticketGenerator.generateTicket(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 수는 1이상이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8})
    @DisplayName("gameCount가 6이상이면 IllegalArgumentException")
    void throwIllegalException_WhenGameCountIsMoreThan6(int gameCount) {
        Assertions.assertThatThrownBy(() -> ticketGenerator.generateTicket(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 수는 5이하이여야 합니다.");
    }
}