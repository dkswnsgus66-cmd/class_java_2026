package innerClass;

// 정적 내부클래스 연습
public class Spaceship {

    private Engine engine; // Engine 멤버변수 선언

    // 엔진을 추가한다.
    public void addEngine(Engine engine){
        this.engine = engine;
    }

    public void startSpaceShip(){
        if(engine == null){
            System.out.println("엔진을 먼저 장착해 주세요");
        }else {
            System.out.println("우주 여행을 출발 합니다.");
        }
    }

    // 논리적으로 강하게 그룹화 시킬때 내부 클래스로 사용할수 있다.
    // 정적 내부클래스 Engine
    // static은 다른 독립적인 메모리에 생성되기에 외부 클래스없이 생성가능


    public static class Engine {
        private static int engineCount = 0;
        private int serialNumber;

        public Engine() { // 엔진을 생성할때마다 serialNumber 1 증가 엔진 고유 넘버
            this.serialNumber = ++engineCount;
        }
        public void start(){ // 엔진 시동 거는 메서드
            System.out.println("Engine: " + serialNumber + " 번 엔진이 동작합니다.");
        }

    }// end of innerclass

} // end of SpaceShip
