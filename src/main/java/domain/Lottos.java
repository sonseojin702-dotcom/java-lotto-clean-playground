package domain;

import java.util.ArrayList;
import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public LottoResult getMatchCount(Lotto winningLotto, PurchasePrice purchasePrice) {
        List<Integer> matches = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int count = lotto.getMatchCount(winningLotto);
            matches.add(count);
        }

        return new LottoResult(matches, purchasePrice);
    }
}
