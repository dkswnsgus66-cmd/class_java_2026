package swing.ch07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame implements ActionListener {
    // 이전에 했던 코드 작성

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JPanel panel1;


    public ColorFrame() {
        initData();
        setInitLayout();
        addEventLisner();
    }

    private void initData() { // 데이터를 여러개 넣는데 도화지 설정하는 메서드라고 생각하자
        // 들어갈 데이터 생성 도화지도 같이 만들어준다
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        button3 = new JButton("button3");
        button4 = new JButton("button4");
        button5 = new JButton("button5");
        button6 = new JButton("button6");
        button7 = new JButton("button7");
        panel1 = new JPanel();
    }

    public void setInitLayout() {

        setLayout(new BorderLayout()); // 레이아웃을 Border단위로 등록 FlowLayout 은 해당 줄영역만 생성
        panel1.setBackground(Color.ORANGE); // 패널 색깔 넣기
        add(panel1);
        panel1.add(button1); // 그 패널에 버튼넣기 패널이 제대로 생성 못하면 버튼은 메모리에 올라가지만 패널안에만 존재하기에 볼수없음.
        panel1.add(button2); // add 는 생성한 객체를 해당 영역에 추가 지금은 panel1에 객체를 추가한다는것
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        setVisible(true);
    }

    private void addEventLisner() {// addActionListener 메서드에 이 클래스 주소 등록 ActionEvent 에등록하는 메서드
        button1.addActionListener(this); // 인터 페이스로 ActionListener 를 등록했기에 addActionListener메서드 사용
        button2.addActionListener(this); // 이벤트 인터페이스 종류 ActionListener 말고도 키보드, 마우스등도 있다
        button3.addActionListener(this); // button3 주소를 ActionListener 이벤트 영역에 추가 하겠다.
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // ActionEvent e 는 쉽게말해 이벤트가 발생한 객체에 한해서 정보를 전달해주는 역할


        if (e.getSource() == button1) { //e.getSource() addEventLisner등록된것들중 이벤트 클릭이 발생한 것만 들고온다 Object 클래스를 쓰는 이유는 이게 버튼이 들어올수 있고 다른 클래스가 들어올수도
            // 있기때문
            panel1.setBackground(Color.RED); // e.getSource()가 button1 일때 만약 서로다른 클래스의 이벤트 리스너에 등록해서 구분 짓고싶다면 instanceof를 쓴다
        } else if (e.getSource() == button2) {
            panel1.setBackground(Color.ORANGE);
        } else if (e.getSource() == button3) {
            panel1.setBackground(Color.YELLOW);
        } else if (e.getSource() == button4) {
            panel1.setBackground(Color.GREEN);
        } else if (e.getSource() == button5) {
            panel1.setBackground(Color.BLUE);
        } else if (e.getSource() == button6) {
            panel1.setBackground(Color.CYAN);
        } else if (e.getSource() == button7) {
            panel1.setBackground(Color.PINK);
        }

    }
}
