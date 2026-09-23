import domain.LottoNumber;
import domain.NumberGenerator;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
  private final List<LottoNumber> lottoNumbers;

  public FixedNumberGenerator(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  @Override
  public List<LottoNumber> generate() {
    return lottoNumbers;
  }
}
