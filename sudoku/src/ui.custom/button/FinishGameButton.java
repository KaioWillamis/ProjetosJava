package ui.custom.button;
import java.swing.JButton;
import java.awr.event.ActionListener;

public class FinishGameButton extends JButtton{
    
    public FinishGameButton(final ActionListener actionListener){
        this.setText("Concluir");
        this.addActionListener(actionListener);
    }
}
