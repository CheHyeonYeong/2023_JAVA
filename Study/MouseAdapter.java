package Study;

import java.awt.event.*;

public abstract class MouseAdapter implements MouseListener, MouseWheelListener, MouseMotionListener {
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){  }  //사용자가 컴포넌트에서 손을 떼었을 때
    public void mouseEntered(MouseEvent e){  } //마우스 커서가 컴포넌트로 들어가면
    public void mouseExited(MouseEvent e){  } //마우스 커서가 컴포넌트에서 나가면
    public void mouseWheelMoved(MouseWheelEvent e){  } //마우스 커서가 컴포넌트에서 나가면

    public void mouseDragged(MouseEvent e){  } //마우스를 드래그하면 호출
    public void mouseMoved(MouseEvent e){  }  //마우스가 클릭되지 않고 이동하는 경우
}
