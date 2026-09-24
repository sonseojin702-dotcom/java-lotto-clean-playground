package domain.winning;

import domain.purchase.Lotto;
import domain.purchase.Lottos;
import java.util.ArrayList;
import java.util.List;

/**
 * 당첨 번호 보관 및 구매한 로또와 비교
 */
public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public LottoResult match(Lottos lottos) {
        List<Integer> matchCounts = new ArrayList<>();
        for (Lotto purchasedLotto : lottos.getLottos()) {
            matchCounts.add(purchasedLotto.getMatchCount(lotto));
        }
        return new LottoResult(matchCounts);
    }
}
