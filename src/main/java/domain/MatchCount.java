package domain;

public class MatchCount {
  private final int value;

  public MatchCount(int value) {
    validate(value);
    this.value = value;
  }

  private void validate(int value) {
    if(value < 0 ||  value > 6) {
      throw new IllegalArgumentException("일치 개수는 0~6이어야 합니다.");
    }
  }

  public int getValue() {
    return value;
  }
}
