package Lotto;

public class LottoCard {
    private generate[] mLottos;  // Corrected the access modifier to private
    private int mNum; // Number of Lotto instances

    public LottoCard(int n) {
        mNum = n;
        mLottos = new generate[mNum];  // Initialize the array with the provided number of Lotto instances
    }

    public boolean auto(int idx) {
        // Automatic number generation
        mLottos[idx] = new generate();
        return mLottos[idx].mIsValid;
    }

    public boolean manual(int idx, int a, int b, int c, int d, int e, int f) {
        mLottos[idx] = new generate(new int[]{a, b, c, d, e, f});
        return mLottos[idx].mIsValid;
    }

    public boolean manual(int idx, int lotto[]) {
        mLottos[idx] = new generate(lotto);
        return mLottos[idx].mIsValid;
    }

    public int[] get(int idx) {
        if (idx < 0 || idx >= mNum || mLottos[idx] == null) {
            return null;  // Invalid index
        }
        return mLottos[idx].getNumbers();
    }

    public void show() {
        for (int i = 0; i < mNum; i++) {
            if (mLottos[i] != null && mLottos[i].mIsValid) {
                System.out.println("Lotto numbers for instance " + i + ":");
                int[] numbers = mLottos[i].getNumbers();
                for (int j = 0; j < 6; j++) {
                    System.out.print(numbers[j] + ", ");
                }
                System.out.println();
            }
        }
    }
}
