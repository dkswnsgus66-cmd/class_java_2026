package swing.ch08;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 키 리스너를 구현하여 키보드 입력을 받아서 라벨을 움직이는 클래스
public class MoveCharFrame2 extends JFrame {
    int count = 0;
    private JLabel label;
    private final int MOVE_STEP = 10;
    private int moveSize = 0;
    private final int INIT_X = 225;
    private final int INIT_Y = 200;
    private final int FRAME_SIZE = 500;

    public MoveCharFrame2() {
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
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 쓰레드를 쓰면 좌위 우위 동시에 움직이수있다 (대각선 이동가능)
                label.setText("☆");
                int keyCode = e.getKeyCode();
                System.out.println(keyCode);

                int x = label.getX(); // 현재 자신의 x 좌표값을 반환해 주고있다
                int y = label.getY(); // 현재 자신의 y 좌표값을 반환해 주고있다.
                if (keyCode == KeyEvent.VK_LEFT) {
                    label.setLocation(x - MOVE_STEP, y);
                    label.setSize(50 - moveSize, 50 - moveSize);
                    count++;
                } else if (keyCode == KeyEvent.VK_UP) {
                    label.setLocation(x, y - MOVE_STEP);
                    label.setSize(50 + moveSize, 50 + moveSize);
                    count++;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    label.setLocation(x + MOVE_STEP, y);
                    label.setSize(50 + moveSize, 50 + moveSize);
                    count++;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    label.setLocation(x, y + MOVE_STEP);
                    label.setSize(50 - moveSize, 50 - moveSize);
                    count++;
                } else if (keyCode == 27) {
                    label.setLocation(INIT_X, INIT_Y);
                }
                moveSize = moveSize + 2;

                setTitle("방향키로 움직이기 연습 Count: " + count);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("★");
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
        new MoveCharFrame2();
    }
} // end of class
