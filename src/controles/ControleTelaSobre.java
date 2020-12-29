package controles;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import telas.TelaInicial;
import telas.TelaSobre;


public class ControleTelaSobre implements MouseListener {
    
    private final TelaSobre telaSobre;
    
    public ControleTelaSobre (TelaSobre sobre){
        telaSobre = sobre;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.telaSobre.getVoltar()){
            try {
                new TelaInicial();
            } catch (IOException ex) {
                Logger.getLogger(ControleTelaSobre.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ControleTelaSobre.class.getName()).log(Level.SEVERE, null, ex);
            }
            telaSobre.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
         if (me.getSource() == this.telaSobre.getVoltar()) {
            this.telaSobre.getVoltar().setIcon(new ImageIcon("src/imagens/voltar02.png"));
        }      
    }

    @Override
    public void mouseExited(MouseEvent me) {
         if (me.getSource() == this.telaSobre.getVoltar()) {
            this.telaSobre.getVoltar().setIcon(new ImageIcon("src/imagens/voltar01.png"));
        }       
    }

   
    
    
}
