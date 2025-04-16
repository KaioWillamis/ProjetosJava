package ui.custom.button;
import java.swing.JButton;

public class buttonCheckgameStatusButton extends JButtton{
    
    public CheckGameStatusButton(final ActionListener){
        this.setText("Verificar jogo");
        this.addActionListener(actionListener);
    }
}
