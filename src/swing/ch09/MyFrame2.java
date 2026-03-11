package swing.ch09;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame2 extends JFrame {

    private JLabel backgroundMap;
    private JLabel player;
    private int INIT_X = 200;
    private int INIT_Y = 200;
    private final int MOVE = 10;

    // 이동 가능한 범위
    private final int MAX_X = 1000 - 100;
    private final int MAX_Y = 600 - 100;
    private final int MIN_POS = 0;


    // 플레이어 상태 멤버변수
    ImageIcon playerIconL = new ImageIcon("images/playerL.png");
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");
    private ImageIcon playerIconRU;
    private ImageIcon playerIconLU;

    // 플레이어 동작 멤버변수
    private JLabel playerMovedL;
    private JLabel playerMovedR;

    private JLabel playerMovedRU;
    private JLabel playerMovedLU;

    // 오른쪽위 왼쪽위움직임
    private int movePoint;

    public MyFrame2() {
        initData();
        setInitData();
        addEventLisner();
    }

    private void initData() {
        setTitle("이미지 사용연습");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 이미지 이콘 에서 배경 사진 넣음
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");// 배경이미지 생성
        backgroundMap = new JLabel(backgroundIcon); // 객체에 배경이미지 넣음
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        // 플레이어 설정
        ImageIcon playerIcon = new ImageIcon("images/playerL.png");

        player = new JLabel(playerIcon);
        player.setSize(100, 100);
        player.setLocation(INIT_X, INIT_Y);
        backgroundMap.add(player);


        // 플레이어 동작 이미지 생성
        playerIconRU = new ImageIcon("images/playerRDie.png");
        playerIconLU = new ImageIcon("images/playerLDie.png");

        playerMovedL = new JLabel(playerIconL);
        playerMovedL.setSize(100, 100);

        playerMovedR = new JLabel(playerIconR);
        playerMovedR.setSize(100, 100);

        playerMovedRU = new JLabel(playerIconRU);
        playerMovedRU.setSize(100, 100);

        playerMovedLU = new JLabel(playerIconLU);
        playerMovedLU.setSize(100, 100);

    }


    private void addEventLisner() {

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                int x = player.getX();
                int y = player.getY();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        y -= MOVE;
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setIcon(playerIconL);
                        x -= MOVE;
                        break; // break를 안쓰면 코드가 동시에 수행됨
                    case KeyEvent.VK_DOWN:
                        y += MOVE;
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setIcon(playerIconR);
                        x += MOVE;
                        break;
                    default:
                        return;
                }



                // 배경 밖으로 나가지 않게 범위설정 (최댓값 제한)
                //
                x = Math.max(MIN_POS,Math.min(x,MAX_X));
                y = Math.max(MIN_POS,Math.min(y,MAX_Y));


                player.setLocation(x, y);
            } // end of keypressed

        });
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void setInitData() {

        setLayout(null); // 좌표기반
        add(backgroundMap);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MyFrame2();
    }
}
