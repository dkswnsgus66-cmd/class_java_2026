package swing.ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame10 extends JFrame implements ActionListener {


    private JPanel panel;
    private JButton button;
    private JLabel textBox;
    private LottoPanel lottoPanel;
    private LottoPanel[] lottoPanels;

    // 로또 넘버 클래스 멤버변수
    private LottoRandomNumber lottoNumber;

    private FlowLayout leftLayout = new FlowLayout(FlowLayout.LEFT);
    // 로또넘버 멤버변수
//    private LottoNumber lottoNumber;

    public LottoFrame10() {
        initData();
        setInitData();
        actionEvent();
    }

    private void initData() {

        // 패널 생성
        panel = new JPanel();
        // 버튼생성
        button = new JButton("Game start");
        // 텍스트 라벨생성
        textBox = new JLabel("Game start 버튼을 눌러주세요", JLabel.CENTER);
        lottoPanel = new LottoPanel();

        // 로또 패널 5개
        lottoPanels = new LottoPanel[5];
        for (int i = 0; i < 5; i++) {
            lottoPanels[i] = new LottoPanel();
        }

    }


    private void setInitData() {

        setTitle("Lotto Game");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        // 패널 설정
        panel.setLayout(null);
        panel.setSize(800, 800);
        add(panel);
        panel.add(button, BorderLayout.NORTH);
        panel.add(textBox, BorderLayout.CENTER);
        // 버튼 설정
        button.setSize(800, 30);
        // 텍스트 라벨 설정
        textBox.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        textBox.setSize(800, 800);
        textBox.setForeground(Color.GRAY);

        // 로또 패널
        lottoPanel.setSize(180, 180);
        lottoPanels[0].setSize(180, 180);
        lottoPanels[1].setSize(180, 180);
        lottoPanels[2].setSize(180, 180);
        lottoPanels[3].setSize(180, 180);
        lottoPanels[4].setSize(180, 180);
        setVisible(true);

        // JFREAM
        //  |
        //  루트 패널 (그리드)
        ///   Panel  < ---- 버튼
        ///   Panel  <----- (배치 관리자 null)
        ///     라벨 () <-- 크기 , 위치 (좌표)

        // 로또번호 배치장소
//        panel2.add(lottoNumber,BorderLayout,CENTER);


    }

    private void actionEvent() {

        button.addActionListener(this);

    }


    static class LottoPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            //super.paintComponent(g);
//             super.paintComponent(g); // 배경색 초기화
//             System.out.println("1111111111111111");
            g.drawOval(0, 100, 80, 80);
            g.setColor(Color.yellow);
            g.fillOval(0, 100, 80, 80);
        }


    } //




    @Override
    public void actionPerformed(ActionEvent e) {

        // 텍스트를 제거하면 새로운 텍스트가 계속 생성된다.

        if (e.getSource() == button) {

            // 사용했던 로또번호 제거
//                panel2.remove(lottoNumber);
            // 패널 생성
            // 패널2에 생성된 텍스트 제거
//                panel2.setLayout(null);
            panel.remove(textBox);
            panel.revalidate();
            panel.repaint();

            lottoPanel.setLocation(0, 250);
            lottoPanels[0].setLocation(130, 250);
            lottoPanels[1].setLocation(260, 250);
            lottoPanels[2].setLocation(390, 250);
            lottoPanels[3].setLocation(520, 250);
            lottoPanels[4].setLocation(650, 250);

            panel.add(lottoPanel);
            panel.add(lottoPanels[0]);
            panel.add(lottoPanels[1]);
            panel.add(lottoPanels[2]);
            panel.add(lottoPanels[3]);
            panel.add(lottoPanels[4]);
            // 로또 번호 생성해서 맴버변수 삽입
//           lottoNumber = new LottoNumber();
            // 로또패널 왼쪽부터 숫자 출력
//                lottoPanel.setLayout(leftLayout);
            // 로또번호 로또 패널에 추가 (동그라미에 숫자삽입)
//                lottoPanel.add(lottoNumber);
//                textBox.add(lottoPanel);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new LottoFrame10();
    }

}
