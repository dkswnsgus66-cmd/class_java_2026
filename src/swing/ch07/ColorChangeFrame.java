package swing.ch07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangeFrame extends JFrame implements ActionListener {

    private JButton button1;
    private JButton button2;
    private JPanel panel1;

    public ColorChangeFrame(){
        initData();
        setInitLayout();
        addEventListner();
    }

    private void initData() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        panel1 = new JPanel();
    }

    private void setInitLayout() { // 레이아웃 에 버튼들을 추가해줌
        setLayout(new BorderLayout());
        panel1.setBackground(Color.YELLOW);
        add(panel1);
        panel1.add(button1);
        panel1.add(button2);
        setVisible(true);
    }

    private void addEventListner() {
        // JButton 클래스 내에 만들어져 있는 메서드 이다.
        //
        // --> // 1. 이벤트 리스너 등록
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    // 운영체제와 약속되어 있는 추상 메서드를 오버라이드 했다.
    // 이벤트가 발생되면 이 메서드를 자동으로 수행해(콜백) 라고 미리 정해져있는 메서드 이다.
    // 내부 인수값으로 정보(객체)를 받을수 있다.
    // 단, 어떤 컴포넌트에 이벤트를 등록할지 미리 정해 주어야 한다

    @Override
    public void actionPerformed(ActionEvent e) {
        // 2. actionPerformed 메서드 콜백(호출되어) 동작하게 끔 설계 되어 있음
        System.out.println("actionPerformed() 메서드가 호출 되었다.");

        if(e.getSource() == button1){
            System.out.println("button1에 이벤트가 발생했습니다.");
            panel1.setBackground(Color.BLUE);
        }else if(e.getSource() == button2){
            System.out.println("button2에 이벤트가 발생 했습니다.");
            panel1.setBackground(Color.BLACK);

        }

        System.out.println(e.getSource()); // 각각의 버튼을 누를때마다 어떤버튼인지 구별해준다 Object 클래스로 있는 경우는 어떤 클래스가 들어올지 모르기 때문에 Object의 getSouce메서드를 활용

        JButton selectedButton = (JButton) e.getSource(); // JButton 변수에 들어오는 버튼을 주입 버튼 1번을 누르면 버튼1이 들어오고 2번을 누르면 버튼 2번이 들어온다.

        System.out.println(selectedButton.getText()); // 주입되어 들어온 버튼의 텍스트 출력



    }
}
