package innerClass;

public class OuterClass {


    private static int num = 10;

    // 클래스 파일 안에 내부에 클래스 선언 (중첩 클래스) // 인스턴스 내부 클래스

   static class InnerClass{
        public void disPlay(){
            System.out.println("num : " + num);
        }
    }


} // end of OuterClass
