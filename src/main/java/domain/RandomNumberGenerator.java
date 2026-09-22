package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

  List<Integer> lotto = new ArrayList<>();

  public List<Integer> generate() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i <= 45; i++) {
      numbers.add(i);
    }

    Collections.shuffle(numbers);

    lotto = numbers.subList(0, 6);
    Collections.sort(lotto);

    return lotto;
  }
}
