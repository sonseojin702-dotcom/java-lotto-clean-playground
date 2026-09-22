package domain;

import java.util.List;

public class Lottos {
  private List<Lotto> lottos;
  private Lotto winningLotto;
  private List<Integer> matchCounts;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
    this.winningLotto = winningLotto;
  }

  // 각 로또를 당첨이랑 비교
  public List<Lotto> getLottos() {
    return lottos;
  }
}
