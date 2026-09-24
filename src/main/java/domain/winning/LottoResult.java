package domain.winning;

import domain.purchase.PurchasePrice;
import java.util.List;

public class LottoResult {
    private int winning3 = 0;
    private int winning4 = 0;
    private int winning5 = 0;
    private int winning6 = 0;
    private final double rateOfReturn;

    public LottoResult(List<Integer> matches, PurchasePrice purchasePrice) {
        for (Integer number : matches) {
            calculateCounts(number);
        }
        this.rateOfReturn = calculateRateOfReturn(purchasePrice);
    }

    private void calculateCounts(int number) {
        if (number == 3) {
            winning3 += 1;
            return;
        }
        if (number == 4) {
            winning4 += 1;
            return;
        }
        if (number == 5) {
            winning5 += 1;
            return;
        }
        if (number == 6) {
            winning6 += 1;
        }
    }

    private double calculateRateOfReturn(PurchasePrice price) {
        int revenue = winning3 * 5000;
        revenue += winning4 * 50000;
        revenue += winning5 * 1500000;
        revenue += winning6 * 2000000000;
        double rate = (double) revenue / price.getAmount();
        return Math.floor(rate * 100) / 100;
    }

    public int getWinning3() {
        return winning3;
    }

    public int getWinning4() {
        return winning4;
    }

    public int getWinning5() {
        return winning5;
    }

    public int getWinning6() {
        return winning6;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
