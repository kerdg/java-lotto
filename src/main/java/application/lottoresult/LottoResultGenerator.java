package application.lottoresult;

import application.lottorank.LottoRank;
import application.game.WinGame;
import application.ticket.Ticket;
import java.util.Map;

public class LottoResultGenerator {

    public LottoResult getLottoResult(WinGame winGame, Ticket ticket) {
        Map<Integer, LottoRank> gameResults = ticket.getGameResults(winGame);

        return new LottoResult(gameResults);
    }
}
