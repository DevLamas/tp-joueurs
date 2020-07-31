import javax.swing.*;

public class Interface extends JFrame {
    public Interface(){
        initUi();
    }

    private void initUi(){
        setTitle("Premier exemple");
        setSize(700,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        Interface ex = new Interface();
        ex.setVisible(true);
    }
}
