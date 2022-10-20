import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Current WIP as we are still deciding what java GUI framework to use
//currently testing swing as the gui

public class GUI {
    public GUI(){
        JFrame frame = new JFrame();//creating main frame
        JPanel panel = new JPanel();//creating panel inside the frame

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0,1));
    }   

    public static void main(String args[]){

    }
}
