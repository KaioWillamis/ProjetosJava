package ui.custom.input;
import java.util.List;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberTextLimit {
    
    public final List<String> NUMBERS = List.of("1","2","3","4","5","6","7","8","9");

    @Override
    public void insertString(final int offs, final String str, final AttributeSet a) throws BadLocationException{
        if(isNull(str) || (!NUMBERS.contains(str))) return;

        if(getLength() + str.length() <= 1){
            super.insertString(offs, str, a);
        }
    }
}
