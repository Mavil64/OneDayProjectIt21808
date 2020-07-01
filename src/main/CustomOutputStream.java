package main;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class CustomOutputStream extends OutputStream{

    private JTextArea ta_out;

    public CustomOutputStream(JTextArea ta_out) {
        this.ta_out = ta_out;
    }

    @Override
    public void write(int b) throws IOException {
        ta_out.append(String.valueOf((char)b));
        ta_out.setCaretPosition(ta_out.getDocument().getLength());
    }

}
