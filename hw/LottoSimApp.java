package hw;

import Lotto.LottoCard;
public class LottoSimApp {
    public static void main(String[] args) {
        // 1st Purchase: 2,000원어치 수동 구매
        LottoCard lottoCard1 = new LottoCard(2);  // 2 Lotto instances
        int[] lottoNumbers1A = {5, 10, 15, 20, 25, 30};  // Manual Lotto numbers for Lotto instance 0
        int[] lottoNumbers1B = {1, 2, 3, 4, 5, 6};  // Manual Lotto numbers for Lotto instance 1

        // Set manual Lotto numbers for Lotto instances in LottoCard 1
        lottoCard1.manual(0, lottoNumbers1A);
        lottoCard1.manual(1, lottoNumbers1B);

        // Display Lotto numbers for LottoCard 1
        System.out.println("Lotto numbers for LottoCard 1:");
        lottoCard1.show();

        // 2nd Purchase: 5,000원어치 자동 구매
        LottoCard lottoCard2 = new LottoCard(5);  // 5 Lotto instances

        // Set automatic Lotto numbers for Lotto instances in LottoCard 2
        for (int i = 0; i < 5; i++) {
            lottoCard2.auto(i);
        }

        // Display Lotto numbers for LottoCard 2
        System.out.println("\nLotto numbers for LottoCard 2:");
        lottoCard2.show();
    }
}
