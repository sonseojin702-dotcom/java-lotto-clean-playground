package domain;

public class LottoNumber implements Comparable<LottoNumber> {
  private final int value;

  public LottoNumber(int value) {
    validate(value);
   this.value = value;
  }

  private void validate(int value) {
    if(value < 1 || value > 45) {
      throw new IllegalArgumentException("로또의 범위는 1~45 사이여야 합니다.");
    }
  }

  @Override
  public int compareTo(LottoNumber other){
    return Integer.compare(this.value, other.value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
