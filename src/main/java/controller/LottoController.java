package controller;

import domain.purchase.Lotto;
import domain.purchase.LottoNumber;
import domain.winning.LottoResult;
import domain.purchase.Lottos;
import domain.NumberGenerator;
import domain.purchase.PurchasePrice;
import domain.RandomNumberGenerator;
import domain.winning.RateOfReturn;
import domain.winning.WinningLotto;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        PurchasePrice purchasePrice = new PurchasePrice(inputView.getPurchasePrice());
        Lottos lottos = createLottos(purchasePrice.calculateLottoCount());
        outputView.printLottos(lottos);

        Lotto winningNumbers = toLotto(inputView.getWinningNumbers());
        LottoResult result = new WinningLotto(winningNumbers).match(lottos);
        outputView.printResult(result);

        RateOfReturn rateOfReturn = new RateOfReturn(result.calculateTotalPrize(), purchasePrice);
        outputView.printRateOfReturn(rateOfReturn.getValue());
    }

    private Lottos createLottos(int count) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(numberGenerator.generate()));
        }
        return new Lottos(lottoList);
    }

    private Lotto toLotto(String input) {
        String[] tokens = input.split(",");
        List<LottoNumber> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(new LottoNumber(parseNumber(token.trim())));
        }
        return new Lotto(numbers);
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
        }
    }
}
