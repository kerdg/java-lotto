package application.ticket;

import application.lottorank.LottoRank;
import application.game.WinGame;
import application.game.Game;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ticket {

    private final Map<Integer, Game> gameList;

    public Ticket() {
        this.gameList = new LinkedHashMap<>();
    }

    public void addGame(Game game) {
        gameList.put(gameList.size() + 1, game);
    }

    public boolean hasCountOfGames(int gameCount) {
        return gameList.size() == gameCount;
    }

    public Map<Integer, LottoRank> getGameResults(WinGame winGame) {
        Map<Integer, LottoRank> gameResults = new LinkedHashMap<>();
        for (Integer gameNumber : gameList.keySet()) {
            int matchingNumberCount = gameList.get(gameNumber).getMatchingNumberCount(winGame);
            boolean hasBonusNumber = gameList.get(gameNumber).hasBonusNumber(winGame);
            LottoRank lottoRank = LottoRank.findRankByMatchingNumberCountAndHasBonusNumber(matchingNumberCount,
                    hasBonusNumber);
            gameResults.put(gameNumber, lottoRank);
        }

        return gameResults;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int gameNumber : gameList.keySet()) {
            stringBuilder.append(String.format("게임 %d. %s\n", gameNumber, gameList.get(gameNumber).toString()));
        }
        return "=========Ticket=========\n" + stringBuilder.toString();
    }
}
