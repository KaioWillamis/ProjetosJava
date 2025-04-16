package ui.custom.panel;
import javax.swing.JPanel;

public class SudokuSector extends JPanel{
    public SudokuSector(final List<NumberText> textFields){
        var dimension = new Dimension(width: 170, height: 170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(newBorder(black, thickness: 2, roundedCorners(true)));
        this.setVisible(true);
        textFields.forEach(this::add);
    }
}
