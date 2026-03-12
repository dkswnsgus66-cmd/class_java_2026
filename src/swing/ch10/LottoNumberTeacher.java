package swing.ch10;


import java.util.Arrays;
import java.util.Random;

/**
 * 역할 로또번호 생성 전달 전담클래스
 * <p>
 * SRP - 단일책임원칙
 * :클래스는 하나의 책임만 가져야 한다
 * 즉 이클래스는 오직 로또 번호 생성만 담는다
 */

public class LottoNumberTeacher {
    static final int LOTTO_NUMBER_COUNT = 6;

    public int[] createNumber() {
        int[] lottoNumber = new int[LOTTO_NUMBER_COUNT];
        Random random = new Random();

        // 이중 ,for while(set) , 셔플 {1 ,2 ,3 ~ 45}

        for (int i = 0; i < lottoNumber.length; i++) {

            // 1~ 45 사이의 랜덤 숫자 생성
            lottoNumber[i] = random.nextInt(45) + 1;


            for (int j = 0; j < i; j++) { // 처음에 배열 0번 1개만 있기에 비교할 대상이 없기에 실행할 필요없다 0 < 0 은 false

                // 다음에 반복 실행될때는 i += 1 이 되었기에 i는 1 이 들어가고 두번째 for에서 j < 1 로 이 되기에 j값은 0이된다

                if (lottoNumber[i] == lottoNumber[j]) {// j는 0 i 는 1 이되는 시점에서 배열이 비교가 되는 원리이다

                    // 중복 발견시점  i값을 되돌려서 같은자리를 다시 뽑게하고 인덱스 1 번배열에 다시 넣을수 있게된다
                    i--;
                    break; // 중복 발견시 즉시 안쪽 for 탈출
                }
            }
        }// end of for

        // 오름차순 정렬
        Arrays.sort(lottoNumber);

        return lottoNumber;
    }


    // 테스트 코드
    public static void main(String[] args) {

       LottoNumberTeacher random = new LottoNumberTeacher();
      int[] result = random.createNumber();
      // 무조건 처음부터 끝까지 반복시켜야 함
      for(int num : result){
          System.out.println(num);
      }
    }


}
