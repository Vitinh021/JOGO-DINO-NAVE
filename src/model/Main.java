package model;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import telas.TelaInicial;

public class Main {
    
    public static void main(String[]arg) throws IOException, LineUnavailableException{
        new TelaInicial().setVisible(true);
    }
}
