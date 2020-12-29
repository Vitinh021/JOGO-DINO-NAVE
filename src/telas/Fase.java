package telas;

import controles.ControleFase;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Asteroide;
import model.ThreadFase;

public class Fase extends JFrame {

    private JButton play;
    public static final int MOVER = 2;
    private JLabel fundo, personagem, amostraDaPontuacao;
    private ArrayList<Asteroide> asteroides;
    private int pontuacao;
    private JPanel painel; 
    
    public Fase(int opcao1) throws LineUnavailableException, IOException {     
        
        this.setSize(1244, 650);
        this.setLocation(0, 100);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        
        if (opcao1 == MOVER) {
            addKeyListener(new ControleFase(this));
        }
        
        asteroides = new ArrayList<Asteroide>();
        
        painel = new JPanel();
        painel.setSize(1244, 650);
        painel.setLocation(0, 0);
        painel.setLayout(null);
        painel.setVisible(true);

        ImageIcon imagemFundo = new ImageIcon("src/imagens/fundo1.jpg");
        fundo = new JLabel(imagemFundo);
        fundo.setBounds(-5, -25, fundo.getIcon().getIconWidth(), fundo.getIcon().getIconHeight());
        
        ImageIcon imagemPersonagem = new ImageIcon("src/imagens/personagem08.png");
        personagem = new JLabel(imagemPersonagem);
        personagem.setSize(personagem.getIcon().getIconWidth(), personagem.getIcon().getIconHeight());
        personagem.setLocation(10, (this.getHeight() / 2) - imagemPersonagem.getIconHeight());
                
        amostraDaPontuacao = new JLabel("PONTUAÇÃO:");
        amostraDaPontuacao.setFont(new Font("Arial bold", Font.PLAIN, 15));
        amostraDaPontuacao.setForeground(Color.white);
        amostraDaPontuacao.setSize(200, 20);
        amostraDaPontuacao.setLocation(this.getWidth() - 210, 20);
        amostraDaPontuacao.setVisible(true);
        
        this.add(painel);
        this.painel.add(personagem);
        this.painel.add(fundo);
        this.painel.add(amostraDaPontuacao);
        this.getPainel().setComponentZOrder(amostraDaPontuacao, 0);

        this.repaint();
        
        new ThreadFase(this).start();
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
    }

    public ArrayList<Asteroide> getAsteroides() {
        return asteroides;
    }

    public void setAsteroides(ArrayList<Asteroide> asteroides) {
        this.asteroides = asteroides;
    }

    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public JLabel getFundo() {
        return fundo;
    }

    public void setFundo(JLabel fundo) {
        this.fundo = fundo;
    }

    public JLabel getPersonagem() {
        return personagem;
    }

    public void setPersonagem(JLabel personagem) {
        this.personagem = personagem;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public JLabel getAmostraDaPontuacao() {
        return amostraDaPontuacao;
    }

    public void setAmostraDaPontuacao(JLabel amostraDaPontuacao) {
        this.amostraDaPontuacao = amostraDaPontuacao;
    }
    

}
