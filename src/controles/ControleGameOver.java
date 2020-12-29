package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import telas.Fase;
import telas.GameOver;
import telas.TelaInicial;

public class ControleGameOver implements ActionListener, MouseListener {

    private GameOver game;

    public ControleGameOver(GameOver game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent me) {       
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (game.getVoltar() == me.getSource()) {
            try {
                new TelaInicial();
            } catch (IOException ex) {
                Logger.getLogger(ControleGameOver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ControleGameOver.class.getName()).log(Level.SEVERE, null, ex);
            }
            game.dispose();
        }
        
        if (game.getReiniciar() == me.getSource()) {
            try {
                new Fase(Fase.MOVER);
                game.dispose();  
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ControleGameOver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControleGameOver.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        if (me.getSource() == this.game.getVoltar()) {
            this.game.getVoltar().setIcon(new ImageIcon("src/imagens/voltar02.png"));
        }
        if (me.getSource() == this.game.getReiniciar()) {
            this.game.getReiniciar().setIcon(new ImageIcon("src/imagens/reiniciar02.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == this.game.getVoltar()) {
            this.game.getVoltar().setIcon(new ImageIcon("src/imagens/voltar01.png"));
        }
        if (me.getSource() == this.game.getReiniciar()) {
            this.game.getReiniciar().setIcon(new ImageIcon("src/imagens/reiniciar01.png"));
        }

    }

}

