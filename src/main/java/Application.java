import domain.*;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {
  public static void main(String[] args) {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    String value = inputView.getPurchasePrice();
    PurchasePrice purchasePrice = new PurchasePrice(value);
    int count = purchasePrice.calculateLottoCount(); //로또 개수

    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      Lotto lotto  = new Lotto(new RandomNumberGenerator());
      lottos.add(lotto);
    }

    Lottos output = new Lottos(lottos);
    outputView.printLottos(output);
  }

}
