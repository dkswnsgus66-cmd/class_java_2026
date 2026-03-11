package swing.ch09;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {

    private JLabel backgroundMap;
    private JLabel player;
    private int INIT_X = 200;
    private int INIT_Y = 200;
    private final int MOVE = 10;

    // 플레이어 상태 멤버변수
    private ImageIcon playerIconL;
    private ImageIcon playerIconR;
    private ImageIcon playerIconRU;
    private ImageIcon playerIconLU;

    // 플레이어 동작 멤버변수
    private JLabel playerMovedL;
    private JLabel playerMovedR;

    private JLabel playerMovedRU;
    private JLabel playerMovedLU;

    // 오른쪽위 왼쪽위움직임
    private int movePoint;

    public MyFrame() {
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
         playerIconL = new ImageIcon("images/playerL.png");
         playerIconR = new ImageIcon("images/playerR.png");
         playerIconRU = new ImageIcon("images/playerRDie.png");
         playerIconLU = new ImageIcon("images/playerLDie.png");

        playerMovedL = new JLabel(playerIconL);
        playerMovedL.setSize(100, 100);

        playerMovedR = new JLabel(playerIconR);
        playerMovedR.setSize(100, 100);

        playerMovedRU = new JLabel(playerIconRU);
        playerMovedRU.setSize(100, 100);

        playerMovedLU = new JLabel(playerIconLU);
        playerMovedLU.setSize(100,100);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    // 키를 눌렀을때
    @Override
    public void keyPressed(KeyEvent e) {

        int x = player.getX();
        int y = player.getY();

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            movePoint = KeyEvent.VK_LEFT;

            player.setIcon(playerIconL);
            player.setLocation(x - MOVE, y);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            movePoint = KeyEvent.VK_RIGHT;
            player.setIcon(playerIconR);
            player.setLocation(x + MOVE, y);

        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
           if(movePoint == KeyEvent.VK_RIGHT){
               player.setIcon(playerIconRU);
               player.setLocation(x, y - MOVE);
           } else if (movePoint == KeyEvent.VK_LEFT) {
               player.setIcon(playerIconLU);
               player.setLocation(x, y - MOVE);
           }


        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setLocation(x, y + MOVE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void addEventLisner() {

        this.addKeyListener(this); // 해당 클래스 주소를 KeyListener에게 줘서 연결하겠다
        // 필수
        // 키보드 이벤트를 받기 위해 프레임이 포커스를 가질수 있게 합니다.
        this.setFocusable(true);
        this.requestFocusInWindow();


    }

    private void setInitData() {

        setLayout(null); // 좌표기반
        add(backgroundMap);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
