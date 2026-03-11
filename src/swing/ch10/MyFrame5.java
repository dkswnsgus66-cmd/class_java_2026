package swing.ch10;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame5 extends JFrame {

    /**
     * 플레이어 이동 + 적군 자동이동(Thread)활용
     * - Thread : 적군을 백그라운드에서 자동으로 움직이게 하는 별도 작업자
     * - Runnerable : Thread가 실행할 작업을 정의하는 인터페이스
     */

    // 배경 and 플레이어
    private JLabel backgroundMap;
    private JLabel player;
    private int INIT_X = 200;
    private int INIT_Y = 200;


    //  적군--------------------
    private JLabel enemy;
    private ImageIcon enemyIconL = new ImageIcon("images/enemyL.png");
    private ImageIcon enemyIconR = new ImageIcon("images/enemyR.png");

    // === 이동설정 ==============
    private final int ENEMY_STEP = 5;
    private final int MOVE = 10;
    private final int DELAY_MS = 50; // 적군 이동간격(ms) - 숫자가 작을수록 빠름


    //  범위 제한
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

    public MyFrame5() {
        initData();
        setInitData();
        addEventLisner();
        startEnemyThread();
    }

    private void startEnemyThread() {

        Runnable enemyTask = new Runnable() { // 익명클래스 원래 인터페이스는 객체생성 불가능
            @Override
            public void run() {

                boolean step = true; // true = 오른쪽으로 이동


                while (true) { // 게임이 끝날때까지 계속반복

                    int x = enemy.getX();

                    if (step) {
                        x += ENEMY_STEP;
                        enemy.setIcon(enemyIconR);
                    } else { // step == flase 로 바뀌면서 동작
                        x -= ENEMY_STEP;
                        enemy.setIcon(enemyIconL);
                    }
                    if (x >= 800) {
                        // 오른쪽 끝 약(800)에 닿으면 방향전환
                        step = false;
                    }
                    if (x <= 100) { //
                        // 왼쪽 끝 (0) 가까이에 닿으면 방향전환
                        step = true;
                    }
                    // 변경된 x 값을 다시 설정
                    enemy.setLocation(x, enemy.getY());
                    try {
                        Thread.sleep(DELAY_MS);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


//                while (true) {
//                    while (step) {
//                        x += ENEMY_STEP;
//                        enemy.setLocation(x,enemy.getY());
//                        try {
//                            Thread.sleep(DELAY_MS);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        if (enemy.getX() == 800) {
//                            step = false;
//                        }
//                    }
//                    while (step == false) {
//                        x -= ENEMY_STEP;
//                        enemy.setLocation(x, enemy.getY());
//                        try {
//                            Thread.sleep(DELAY_MS);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        if (enemy.getX() == 100) {
//                            step = true;
//                        }
//                    }
//                } // end of while 반복
            }
        };

        Thread thread = new Thread(enemyTask);
        thread.start();

    }

    private void initData() {
        setTitle("이미지 사용연습");
        setSize(1000, 640);
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


        // 적군 설정 - 하단 중앙에서 시작
        enemy = new JLabel(enemyIconR); // 처음에 오른쪽을 바라봄
        enemy.setSize(100, 100);
        enemy.setLocation(100, 500);


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
                x = Math.max(MIN_POS, Math.min(x, MAX_X));
                y = Math.max(MIN_POS, Math.min(y, MAX_Y));

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
        backgroundMap.add(enemy);
        backgroundMap.add(player);

    }

    public static void main(String[] args) {
        new MyFrame5();
    }
}
