package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import telas.Fase;
import telas.TelaInicial;
import telas.TelaSobre;


public class ControleTelaInicial implements ActionListener, MouseListener {

    private TelaInicial telaInicial;
    private Clip clip;

    public ControleTelaInicial(TelaInicial tela, Clip clip) {
        telaInicial = tela;
        this.clip = clip;
    }

    @Override
    public void actionPerformed(ActionEvent me) {       
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if (telaInicial.getJogar() == me.getSource()) {
            try {
                clip.stop();
                new Fase(Fase.MOVER);
                telaInicial.dispose();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ControleTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControleTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
                
 
        }
        
        if (telaInicial.getSair() == me.getSource()) {
            System.exit(0);
        }

        if (telaInicial.getSobre() == me.getSource()){
            clip.stop();
            new TelaSobre();
            telaInicial.dispose();
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
        if (me.getSource() == this.telaInicial.getJogar()) {
            this.telaInicial.getJogar().setIcon(new ImageIcon("src/imagens/jogar02.png"));
        }
        if (me.getSource() == this.telaInicial.getSair()) {
            this.telaInicial.getSair().setIcon(new ImageIcon("src/imagens/sair02.png"));
        }
        if (me.getSource() == this.telaInicial.getSobre()) {
            this.telaInicial.getSobre().setIcon(new ImageIcon("src/imagens/sobre02.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
         if (me.getSource() == this.telaInicial.getJogar()) {
            this.telaInicial.getJogar().setIcon(new ImageIcon("src/imagens/jogar01.png"));
        }
        if (me.getSource() == this.telaInicial.getSair()) {
            this.telaInicial.getSair().setIcon(new ImageIcon("src/imagens/sair01.png"));
        }
        if (me.getSource() == this.telaInicial.getSobre()) {
            this.telaInicial.getSobre().setIcon(new ImageIcon("src/imagens/sobre01.png"));
        }       
    }

}
