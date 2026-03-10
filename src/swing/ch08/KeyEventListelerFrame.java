package swing.ch08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Key Listener 인터페이스를 구현하여 키보드 이벤트를 처리하는 클래스를 설계하고자 합니다.
 * 1. JFrame 을 상속받아 창을 만들고
 * 2. KeyListener 를 구현하여 `감시자` 자격을 갖춤
 */

public class KeyEventListelerFrame extends JFrame implements KeyListener {

    private JTextArea textArea;
    private final int FREAM_SIZE = 500;
    public KeyEventListelerFrame(){
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {

        setSize(FREAM_SIZE,FREAM_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // static 변수
        setResizable(false); // 사용자가 마우스 크기로 창 크기를 조절 못하게 고정하는 옵션
        textArea = new JTextArea();
    }

    private void setInitLayout() {

        setLayout(new BorderLayout()); // 전체 기본 레이아웃
        add(textArea);
        setVisible(true);
    }
    private void addEventListener() { // 감시자
        // 핵심개념
        // textArea 에게 키보드 입력이 들어오면 this(나) 한테 알려줘 라고 등록하는 과정
//        KeyListener 에게 this 해당 클래스 주소를 알려주는것 즉 KeyListener 인터페이스 와 연결해 주는것
        textArea.addKeyListener(this);

        // 종이컵 <-=---->

    }


    // -------------- KeyEventListener를 추상메서드를 재정의 구현
    // 키보드를 눌렀을때 호출
    @Override
    public void keyPressed(KeyEvent e) {

//        System.out.println(e.getSource() + "주소값");
        System.out.println(e.getKeyCode() + " : 키 코드");
        // 콘솔창에 화살표 뭐가 눌러 졌는지 구분해 보기
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            textArea.append("← 왼쪽 화살표\n"); // 이벤트 입력이 발생했을때 작성해둔  텍스트 출력 물론 JTextArea 안에서 텍스트가 나와야한다.
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            textArea.append("↑ 위쪽 화살표\n");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            textArea.append("→ 오른쪽 화살표\n");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            textArea.append("↓ 아래쪽 화살표\n");
        }

    }
    // 문자가 입력 되었을때 호출
    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Key Typed 호출됨");
    }
    // 어떤 키든 손을 땠을때 호출
    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Key Released 호출됨");
    }

    // 테스트 코드
    // 메인 쓰레드 (현재 단일쓰레드)
    public static void main(String[] args) {
        new KeyEventListelerFrame();
    }

}
