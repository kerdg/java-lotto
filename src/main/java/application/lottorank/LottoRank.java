package application.lottorank;

import java.util.Arrays;

public enum LottoRank {
    FIRST_PLACE("1", 6, false, 100_000_000),
    SECOND_PLACE("2", 5, true, 1_000_000),
    THIRD_PLACE("3", 5, false, 100_000),
    FOURTH_PLACE("4", 4, false, 10_000),
    FIFTH_PLACE("5", 3, false, 5_000),
    NONE("-", 0, false, 0);

    private final String rank;
    private final int matchingCount;
    private final boolean hasBonusNumber;
    private final int prize;

    LottoRank(String rank, int matchingCount, boolean hasBonusNumber, int prize) {
        this.rank = rank;
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static LottoRank findRankByMatchingNumberCountAndHasBonusNumber(int matchingNumberCount, boolean hasBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingCount == matchingNumberCount && lottoRank.hasBonusNumber == hasBonusNumber)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    @Override
    public String toString() {
        return String.format("(%s)등 - 당첨금액: %d원", rank, prize);
    }
}
