package Lotto;
import java.util.Random;

public class generate {
    int mLottoNumber[] = new int[6];
    boolean mIsValid = true;

    public generate() {
        Random rd = new Random();

        for (int i = 0; i < 6; i++) {
            mLottoNumber[i] = (rd.nextInt(45) + 1);
        }
        verifyNumbers();
    }

    public generate(int lotto[]) {
        mLottoNumber = lotto;
        verifyNumbers();
    }
    public generate(int a, int b, int c, int d, int e, int f) {
        mLottoNumber = new int[]{a, b, c, d, e, f};
        verifyNumbers();
    }

    private void verifyNumbers() {
        if (mLottoNumber.length != 6) {
            mIsValid = false;
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (mLottoNumber[i] < 1 || mLottoNumber[i] > 45) {
                mIsValid = false;
                return;
            }
            for (int j = 0; j < i; j++) {
                if (mLottoNumber[i] == mLottoNumber[j]) {
                    mIsValid = false;
                    return;
                }
            }
        }
    }

    public void show() {
        if (mIsValid) {
            for (int i = 0; i < 6; i++) {
                System.out.print("[" + mLottoNumber[i] + "]");
            }
        } else {
            System.out.print("오류메시지");
        }
    }

    public int[] getNumbers() {
        if (mIsValid) {
            return mLottoNumber;
        } else {
            return null;
        }
    }
}
