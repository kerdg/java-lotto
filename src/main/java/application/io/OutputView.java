package application.io;

import application.lottorank.LottoRank;
import application.game.WinGame;
import application.ticket.Ticket;
import java.util.Map;

public class OutputView {

    public static void printGameResult(int gameNumber, int price) {
        System.out.println("게임 " + gameNumber + ". " + price + "원");
    }

    public static void printBuyResult(Ticket ticket) {
        System.out.println("\n=========구매내역=========");
        System.out.println(ticket.toString());
    }

    public static void printLotteryResult(WinGame winGame) {
        System.out.println("=========추첨결과=========");
        System.out.println(winGame.toString());
    }

    public static void printLottoResult(Map<Integer, LottoRank> gameResults) {
        System.out.println("\n=========당첨결과=========");
        for (int gameNumber = 1; gameNumber <= gameResults.size(); gameNumber++) {
            System.out.println("게임 " + gameNumber + ". " + gameResults.get(gameNumber).toString());
        }
    }
}
