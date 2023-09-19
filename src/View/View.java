package View;

import javax.swing.JOptionPane;

public class View {
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public String askInfo(String message){
        return JOptionPane.showInputDialog(message);
    }

    public String askVariousInfo(String[] options, String message){
        return (String) JOptionPane.showInputDialog(null, message, "Input", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
}
