package application.ticket;

import application.game.GameGenerator;

public class TicketGenerator {

    private final GameGenerator gameGenerator;

    public TicketGenerator(GameGenerator gameGenerator) {
        this.gameGenerator = gameGenerator;
    }

    public Ticket generateTicket(int gameCount) {
        validGameCount(gameCount);

        Ticket ticket = new Ticket();
        while (!ticket.hasCountOfGames(gameCount)) {
            ticket.addGame(gameGenerator.generateGame());
        }

        return ticket;
    }

    private void validGameCount(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException("게임 수는 1이상이여야 합니다.");
        }
        if (gameCount >= 6) {
            throw new IllegalArgumentException("게임 수는 5이하이여야 합니다.");
        }
    }
}
