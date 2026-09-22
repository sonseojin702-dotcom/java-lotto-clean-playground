package domain;

import java.util.List;

public class Lotto {
  private final List<Integer> numbers;
  NumberGenerator numberGenerator;

  public Lotto(NumberGenerator numberGenerator) {
    this.numberGenerator = new RandomNumberGenerator();
    this.numbers = numberGenerator.generate();
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
