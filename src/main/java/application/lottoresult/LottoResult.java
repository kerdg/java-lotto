package application.lottoresult;

import application.lottorank.LottoRank;
import application.io.OutputView;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, LottoRank> gameResults;

    public LottoResult(Map<Integer, LottoRank> gameResults) {
        this.gameResults = gameResults;
    }

    public void printResult() {
        OutputView.printLottoResult(gameResults);
    }
}
