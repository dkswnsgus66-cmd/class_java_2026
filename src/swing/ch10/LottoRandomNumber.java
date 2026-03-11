package swing.ch10;

import java.util.Arrays;
import java.util.Random;

public class LottoRandomNumber {
    private int lottoNumber[] = new int[6];

    public void makeNumber() {
        Random random = new Random(); // 난수 생성

        // 객체 생성
        for (int i = 0; i < lottoNumber.length; i++) {
            int resultNumber = random.nextInt(45) + 1; // 난수 범위
            lottoNumber[i] = resultNumber; // 배열에 숫자 넣기
            // lottoNumber[0] = 숫자들어감


            // 같은 숫자 중복방지
            for (int j = 0; j < i; j++) {// 배열 범위가 같으면
                if (lottoNumber[j] == lottoNumber[i]) {
                    i--; // i-- 를 넣으면 이전 배열에 숫자를 다시 넣을수 있다
                    break;
                }
            }
        }
        Arrays.sort(lottoNumber);
    }
    // 배열 정리 메서드
    public void sortRandomNumber() {


    }
    // 출력한 숫자 넣기
    public int[] getNumber() {

        return lottoNumber;
    }

}