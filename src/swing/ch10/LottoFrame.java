package lotto;

import swing.ch10.LottoRandomNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton button;
    private JLabel textBox;
    private LottoPanel lottoPanel;


    public LottoFrame() {
        initData();
        setInitData();
        actionEvent();
    }

    private void initData() {
        panel = new JPanel();
        button = new JButton("Game start");
        textBox = new JLabel("Game start 버튼을 눌러주세요", JLabel.CENTER);
        lottoPanel = new LottoPanel();
    }

    private void setInitData() {
        setTitle("Lotto Game");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel.setLayout(null);
        add(panel);

        button.setBounds(0, 0, 800, 50);
        panel.add(button);
        // 배치와 크기를 한번에 지정
        textBox.setBounds(0, 80, 800, 100);
        textBox.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        textBox.setForeground(Color.GRAY);
        panel.add(textBox);

        lottoPanel.setBounds(50, 180, 700, 150);
        panel.add(lottoPanel);
        lottoPanel.setVisible(false);

        setVisible(true);
    }

    private void actionEvent() {
        button.addActionListener(this);
    }


    static class LottoPanel extends JPanel {
        private int[] numbers;

        // 외부인수로 해당 numbers를 받아 해당 멤버변수에 넣음
        public void setNumbers(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 그림 6개를 그려서 안에 숫자를 넣어라
            // numbers null 체크
            if (numbers == null) {
                return;
            }
            // numbers 배열 길이만큼 x 에 값 넣기
            for (int i = 0; i < numbers.length; i++) {
                //
                int x = 20 + i * 110; // x 값 위치가 반복할때마다 변하게 하기 랜덤 숫자 배열길이만큼
                int y = 30;

                int num = numbers[i]; // 배열 0 ~ 5 까지 순서대로 동작

                if(num <= 10){ // 만약 0번 부터 ~ 5 번까지 봤을때 숫자 10 이하면 노란색
                    g.setColor(Color.YELLOW);
                } else if(num <= 20){// 만약 0번 부터 ~ 5 번까지 봤을때 숫자 20 이하면 파란색
                    g.setColor(Color.BLUE);
                } else if(num <= 30){// 만약 0번 부터 ~ 5 번까지 봤을때 숫자 30 이하면 빨간색
                    g.setColor(Color.RED);
                } else if(num <= 40){// 만약 0번 부터 ~ 5 번까지 봤을때 숫자 40 이하면 회색
                    g.setColor(Color.GRAY);
                } else {// 만약 0번 부터 ~ 5 번까지 봤을때 그 이외 숫자면 초록색
                    g.setColor(Color.GREEN);
                }

                g.fillOval(x, y, 80, 80);

                g.setColor(Color.BLACK);
                g.drawOval(x, y, 80, 80);

                g.setFont(new Font("맑은 고딕", Font.BOLD, 24));
                // 그림에 숫자넣는 코드 그림을 기준으로 위치 정하기
                g.drawString(String.valueOf(num), x + 28, y + 48);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            LottoRandomNumber lottoRandomNumber = new LottoRandomNumber(); // 객체 생성
            lottoRandomNumber.makeNumber(); // 메서드 호출하여 랜덤숫자 생성
//            lottoRandomNumber.sortRandomNumber();// 오름차순 정렬
            // 메서드를 setNumber메서드를 직접 추가하여 만듬
            // lottoPanel 의 setNumber메서드 호출 lottoRandomNumber.getNumber() lottoRandomNumber 클래스의 숫자를 넣음
            lottoPanel.setNumbers(lottoRandomNumber.getNumber());
            lottoPanel.setVisible(true);
            panel.remove(textBox);
            panel.revalidate();
            panel.repaint();
            lottoPanel.repaint();

        }
    }

    public static void main(String[] args) {
        new LottoFrame();
    }
}