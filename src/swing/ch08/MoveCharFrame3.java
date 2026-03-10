package swing.ch08;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// 키 리스너를 구현하여 키보드 입력을 받아서 라벨을 움직이는 클래스
public class MoveCharFrame3 extends JFrame {
    int count = 0;
    private JLabel label;
    private final int MOVE_STEP = 10;
    private int moveSize = 0;
    private final int INIT_X = 225;
    private final int INIT_Y = 200;
    private final int FRAME_SIZE = 500;

    public MoveCharFrame3() {
        // setTitle("방향키로 움직이기 연습 Count: " + count);
        // setTitle 을 여기에 넣으면 한번 호출되고 메서드가 꺼지기 때문에 count 갱신이 안된다
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {

        setSize(FRAME_SIZE, FRAME_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        label = new JLabel("★"); // 초기 라벨의 모습
        // label.setFont(new Font("맑은 고딕",Font.BOLD,30));
        label.setSize(50, 50);// 라벨 자체의 크기
        label.setLocation(INIT_X, INIT_Y); // 초기 시작위치 (중앙부근)
    }

    private void addEventListener() {
        // 1. 프레임에 키 리스너를 등록 (나 자신을 리스너로 임명)

        // KeyAdapter 를 구현 클래스로 생성
        this.addKeyListener(new KeyAdapter() { // 추상 메서드를 일반 메서드로 구현해줬다
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });


        // 필수
        // 키보드 이벤트를 받기 위해 프레임이 포커스를 가질수 있게 합니다.
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void setInitLayout() {
        setLayout(null); // 좌표를 움직이기 위해서 기본 레이아웃을 제거합니다.
        add(label);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MoveCharFrame3();
    }
} // end of class
