package view;
import domain.Lotto;
import domain.Lottos;
import java.util.List;

public class OutputView {
  public void printLottos(Lottos lottos) {
    List<Lotto> lotto = lottos.getLottos();
    int count = lotto.size();
    System.out.println(count + "개를 구매했습니다.");

    for (int i = 0; i < count; i++) {
      printLotto(lotto.get(i));
    }
  }

  private void printLotto(Lotto lotto) {
    System.out.println(lotto);
  }
}
