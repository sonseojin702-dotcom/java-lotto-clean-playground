package domain.purchase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchasePriceTest {
    @Test
    @DisplayName("String을 Int로 변환한다.")
    void convertStringToInt() {
        String amountString = "100";
        int amount = Integer.parseInt(amountString);
        assertEquals(amount, 100);
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 때 오류가 발생한다.")
    void errorWhenPurchasePriceIsNotNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PurchasePrice("@")
        );

        assertEquals("구입 금액은 숫자로 입력되어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 null일 때 오류가 발생한다.")
    void errorWhenPurchasePriceIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PurchasePrice("")
        );

        assertEquals("구입 금액은 숫자로 입력되어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 빈칸일 때 오류가 발생한다.")
    void errorWhenPurchasePriceIsBlank() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PurchasePrice(" ")
        );

        assertEquals("구입 금액은 숫자로 입력되어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원일 때 오류가 발생하지 않는다.")
    void safeWhenPurchasedPriceIs1000() {
        PurchasePrice purchasePrice = new PurchasePrice("1000");
        assertEquals(1000, purchasePrice.getAmount());
    }

    @Test
    @DisplayName("구입 금액이 999원일 때 오류가 발생한다.")
    void errorWhenPurchasedPriceIs999() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PurchasePrice("999")
        );
        assertEquals("로또 최소 구매 금액은 1000원입니다.",  exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("구매 가격에 따른 로또 장수를 반납한다.")
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "3000, 3",
            "10000, 10"
    })
    void returnLottoCountBasedOnPurchasePrice(String amount, int expected) {
        PurchasePrice purchasePrice = new PurchasePrice(amount);
        assertEquals(expected, purchasePrice.calculateLottoCount());
    }
}
