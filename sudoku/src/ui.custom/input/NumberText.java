package ui.custom.input;

import model.Space;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;
import javax.awt.Font;

public class NumberText {
    private final Space space;

    public NumberText(final Space space){
        this.space = space;
        var dimension = new Dimension(width 50, height: 50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Fonte(name: "Arial", PLAIN, size: 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!space.isFixed());
        if(space.isFixed()){
            this.setText(space.getActual().toString());
        }

        this.getDocument().addDocumentListener(new DocumentListener(){

            private void changeSpace(){
                if(getText.isEmpty()){
                    space.clearSpace();
                    return;
                }
                space.setAcual(Integer.parseInt(getText()));
            }

            @Override
            public void insertUpdate(final DocumentEvent e){
                changeSpace();
            }

            @Override
            public void removeUpdate(final DocumentEvent e){
                changeSpace();
            }

            @Override void changeUpdate(final DocumentEvent e){
                changeSpace();
            }
        });
    }
}
