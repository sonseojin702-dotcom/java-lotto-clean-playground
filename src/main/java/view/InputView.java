package view;

import java.util.Scanner;

public class InputView {
  Scanner scanner = new Scanner(System.in);

  public String getPurchasePrice() {
    System.out.println("구입금액을 입력해 주세요.");
    String purchasePrice = scanner.nextLine();
    return purchasePrice;
  }

  public String getWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String winningNumbers = scanner.nextLine();
    return winningNumbers;
  }
}
