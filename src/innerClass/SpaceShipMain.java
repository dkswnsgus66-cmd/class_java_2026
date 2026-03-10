package innerClass;

public class SpaceShipMain {

    public static void main(String[] args) {

        // 정적 내부 클래스라서 바로 생성 가능함
        Spaceship.Engine spaceShipEngine = new Spaceship.Engine();// . 연산자로 내부클래스의 생성자까지 생성해 준다 static 이라 외부 클래스를 생성 안해도 된다. 엔진과 엔진 시리얼 넘버가 생성됨
        Spaceship spaceship = new Spaceship();  // 우주선 생산

        spaceShipEngine.start(); // 생성한 엔진을 시동해 본다
        spaceship.addEngine(spaceShipEngine); // 생성한 엔진을 넣어준다
        spaceship.startSpaceShip(); // 엔진을 넣어 출발한다.




    } // end of main

} // end of class
