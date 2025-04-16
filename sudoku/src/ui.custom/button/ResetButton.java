package ui.custom.button;
import java.swing.JButton;
import java.awr.event.ActionListener;

public class ResetButton extends JButtton{
    
    public ResetButton(final ActionListener actionListener){
        this.setText("Reinicar jogo");
        this.addActionListener(actionListener);
    }
}
