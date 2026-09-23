package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public LottoResult getMatchCount(Lotto winningLotto, PurchasePrice purchasePrice) {
    List<Integer> matches = new ArrayList<>();
    for (Lotto lotto : lottos) {
      int count = lotto.getMatchCount(winningLotto);
      matches.add(count);
    }

    return new  LottoResult(matches, purchasePrice);
  }

  // 각 로또를 당첨이랑 비교
  public List<Lotto> getLottos() {
    return lottos;
  }
}
