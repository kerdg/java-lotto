package application;

import application.game.GameGenerator;
import application.game.WinGame;
import application.game.WinGameGenerator;
import application.io.InputManager;
import application.io.OutputView;
import application.lottoresult.LottoResult;
import application.lottoresult.LottoResultGenerator;
import application.ticket.Ticket;
import application.ticket.TicketGenerator;

public class LottoService {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        GameGenerator gameGenerator = new GameGenerator(randomNumberGenerator);
        WinGameGenerator winGameGenerator = new WinGameGenerator(randomNumberGenerator);
        TicketGenerator ticketGenerator = new TicketGenerator(gameGenerator);
        LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();

        Ticket ticket = ticketGenerator.generateTicket(inputManager.getGameCount());

        OutputView.printBuyResult(ticket);

        WinGame winGame = winGameGenerator.generateGame();
        OutputView.printLotteryResult(winGame);

        LottoResult lottoResult = lottoResultGenerator.getLottoResult(winGame, ticket);
        lottoResult.printResult();
    }
}
