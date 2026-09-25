package domain.purchase;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return new Lotto(lottoNumbers);
    }

    public int countMatches(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber number : numbers) {
            count += winningLotto.match(number);
        }

        return count;
    }

    private int match(LottoNumber number) {
        if (numbers.contains(number)) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
