package domain;

import java.util.List;

public class Lottos {
  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  // 각 로또를 당첨이랑 비교
  public List<Lotto> getLottos() {
    return lottos;
  }
}
