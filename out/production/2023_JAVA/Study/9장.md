# 9장  GUI 기초

# GUI 개발

- java.awt : 부모 클래스 제공
- java.awt.event : 컴포넌트 이벤트 처리
- javax.swing : 버튼, 텍스트 필드 등

# 프레임 생성

## 프레임 생성 1

- 종료되지 않음 → 멀티 윈도우를 담당하는 새로운 스레드가 하나 생성된다.
- main이 종료 되더라도 윈도우는 없어지지 않는다.

```java
import javax.swing.*;

public class FrameTest{
	public static void main(String[] args){
	
		JFrame f =new JFrame("Frame Test");
		f.setTitle("My Frame");
		f.setSize(300,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
```

## 프레임 생성 2

- main()메소드가 MyFrame 클래스 안에 정의 되었고 클래스 선언 → 정적 메소드는 객체를 생성하지 않아도 호출 가능~!

```java
import javax.swing.*;

public class MyFrame extends JFrame{
	**public MyFrmae(){
	
		f.setTitle("My Frame");
		f.setSize(300,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}**
	public static void main(String[] args){
		MyFrame f = new MyFrame();	
}
}
```

## 프레임에 버튼 추가하기

```java
import javax.swing.*;

public class MyFrame extends JFrame{
	public MyFrmae(){
	
		f.setTitle("My Frame");
		f.setSize(300,200);
		
		setLayout(new FlowLayout());
		**JButton button = new JButton("버튼");
		add(button);**

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		MyFrame f = new MyFrame();	
}
}
```

# 컨테이너 살펴보기

- JFrame은 아래 그림과 같이 수많은 조상 클래스들을 가지고 있다.
- 그래서 많이 쓸 수 있다!

## 중요 메소드

1. add
2. serLocation(x,y), setSize(w,h)
3. setIconImage(IconImage) : 제목줄에 표시할 아이콘을 설정
4. setTitle : 타이틀 바의 제목을 변경한다.
5. setResizable(blooean) : 사용자가 크기를 조절 할 수 있는지를 설정한다.
6. setLayout() : 프레임의 배치 관리자를 설정한다.

```java
import javax.swing.*;

public class MyFrame extends JFrame{
	public MyFrmae(){
	
		f.setTitle("My Frame");
		f.setSize(300,200);
		
		setLayout(new FlowLayout());

		**getContentPane().setBackground(Color yellow);**
		JButton button = new JButton("버튼");
		add(button);

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		MyFrame f = new MyFrame();	
}
}
```

# JPanel 클래스

- 패널은 컴포넌트들을 부착할 수 있도록 설계된 컨테이너 중의 하나이다.
- 별도의 패널을 쓰는 것이 유지보수 및 배치 관리에 유리한 경우가 많다.
- 예를 들어서 프레임에 2장 패널을 부착하고 각 패널의 배경색을 다르게 할 수 있다.

## 클래스

1. add
2. remove
3. setBackground

# 배치 관리자

- 컨테이너 안의 각 컴포넌트의 위치와 크기를 결정하는 작업

## 종류

1. Flow : 컨테이너에 추가되는 순서대로 컴포넌트를 부착한다. 위쪽에서 아래쪽으로 왼쪽에서 오른쪽으로 배치한다. 패널의 기본 배치 관리자.
2. BorderLayout : 컨테이너의 영역을 동서남북, 중앙의 5개의 영역으로 구분하여 이 영역에 컴포넌트를 배치한다. 프레임의 기본 배치 관리자이다.
3. GridLayout : 컨테이너의 공간을 동일한 크기의 격자로 나누고 이 격자에 컴포넌트를 배치한다.
4. CardLayout : 컨테이너에 컴포넌트를 카드처럼 겹치게 쌓아서 배치한다.

## 설정

- 생성자를 이용하는 방법
    - `JPanel panel = new JPanel(new BorderLayout());`
- setLayout() 메소드 이용
    - panel.setLayout(new FlowLayout());
- 컴포넌트들을 왼쪽에서 오른쪽으로 버튼을 배치한다.
- 패널과 애플릿의 디폴트 배치 관리자이다.
    - FlowLayout()
    - FlowLayout(int align) //align은 정렬 방법을 지정한다.
    - FlowLayout(int align. int hGap, int vGap); //간격을 지정한다.

# BorderLayout

- 컴포넌트들이 5개의 영역인 상하좌우중앙
- North, South, East, West, Center
- ex) add(btn1, “North”)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/65d47488-3ffd-440e-b655-cb7516b09d13/b14cc3a1-5192-4200-8df6-d2e72c59cbcb/Untitled.png)

## GridLayout

- 격자 모습으로 배치한다.

### 격자 배치 방법

- GridLayout()
- GridLayout(int rows, int cols)
- GridLayout(int rows, int cols, int hGap, int vGap)

## CardLayout

- 한 번에 하나의 컴포넌트만 볼 수 있게 배치하는 관리자
    - next(container) : 주어진 컨테이너의 다음 카드로 이동한다
    - previous(container) : 주어진 컨테이너의 다음 카드로 이동한다
    - first(container) : 주어진 컨테이너의 다음 카드로 이동한다
    - last(container) : 주어진 컨테이너의 마지막 카드로 이동한다.

### cardLayout

```java
import javax.swing.*;

public class MyFrame extends JFrame{
	Jbutoon b1,b2,b3;
	Container cPane;
	CardLayout layoutm;

	public MyFrmae(){
	
		f.setTitle("My Frame");
		f.setSize(300,200);
		
		cPane = getContentPane();
		layoutm = new CardLayout();

		setLayout(layoutm);

		JButton b1 = new JButton("버튼");
		JButton b2 = new JButton("버튼");
		JButton b3 = new JButton("버튼");

		add(b1);
		add(b2);
		add(b3);

		b1.addActionListener(e->layoutm.next(cPane));
		b2.addActionListener(e->layoutm.next(cPane));
		b3.addActionListener(e->layoutm.next(cPane));
		

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		MyFrame f = new MyFrame();	
}
}
```

## 절대 위치로 배치

1. 배치 관리자를 null 설정한다.
    - setlayout(null);
2. add() 메소드를 사용하여 컴포넌트를 컨테이너에 추가한다
    - Button b = button(”Button #1”);
    - add(b);
3. setSize(w,h)와 setLocation(x,y)을 사용하여 컴포넌트의 위치와 크기를 지정한다. 아니면 setBounds(x,y,w,h)를 사용하여 위치와 크기를 동시에 지정해도 된다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/65d47488-3ffd-440e-b655-cb7516b09d13/b0444697-0b56-4e98-a421-73c57485f015/Untitled.png)

# 기초 컴포넌트

- 레이블 : 텍스트를 표시할 수 있는 공간
    - 편집 불가한 텍스트 표시
    - 레이블의 폰트 변경하기

      ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/65d47488-3ffd-440e-b655-cb7516b09d13/cf3669e2-669f-46a9-bfb1-7e3eff4bb050/Untitled.png)

    - 레이블에 이미지 표시하기

      ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/65d47488-3ffd-440e-b655-cb7516b09d13/09e443be-c8fe-42b6-ae88-c99a00d6450a/Untitled.png)

- 텍스트필드 : 사용자가 한 줄의 텍스트를 입력할 수 있는 공간
    - 입력이 가능한 한 줄의 텍스트 필드를 만드는 데 사용
    - 만일 패스워드 필드를 사용하고 싶다면 pannel.add(new JPasswordField(20)); 으로 쓰면 된다.

  ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/65d47488-3ffd-440e-b655-cb7516b09d13/bea041b4-9fe3-446e-a3ae-63d41cf12477/Untitled.png)

- 버튼 : 클릭되면 어떤 동작을 실행하는 버튼

# 버튼

- 사용자가 클릭했을 경우 이벤트를 발생하여 원하는 동작을 하게 하는데 이용한다.

## 종류

1. JButton : 가장 일반적인 버튼이다
2. JCheckbox : 체크박스 버튼
3. JRadioButton : 라디오 버튼으로 그룹 중의 하나의 버튼만 체크할 수 있다.
4. JtoggleButton : 2가지 상태를 가지고 토글이 가능한 버튼이다.
