package telas;

import controles.ControleTelaInicial;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import model.Pontuacao;
import model.ThreadFase;

public class TelaInicial extends JFrame {

    private JLabel fundo, sair, jogar, nome, sobre, recorde, labelRecorde;
    private ImageIcon imagemFundo,imagemNome, imagemSair, imagemJogar, imagemRecorde, imagemSobre;
    private AudioInputStream audioInputStream, audioInputStream2;
    private Clip clip;
    
    public TelaInicial() throws IOException, LineUnavailableException {
        this.setSize(1244, 650);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/musicas/telaInicial_1_.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Integer.MAX_VALUE);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imagemFundo = new ImageIcon("src/imagens/fundo1.jpg");
        fundo = new JLabel(imagemFundo);
        fundo.setSize(1244, 650);
        fundo.setLocation(0, 0);
        
        imagemNome = new ImageIcon("src/imagens/DinoNaveedt3.png");
        nome = new JLabel(imagemNome);
        nome.setSize(imagemNome.getIconWidth(), imagemNome.getIconHeight());
        nome.setLocation(this.getWidth() / 2 - (imagemNome.getIconWidth() / 2), 0);
        nome.setVisible(true);
        
        imagemRecorde = new ImageIcon("src/imagens/recorde01.png"); 
        recorde = new JLabel(imagemRecorde);
        recorde.setSize(imagemRecorde.getIconWidth(), imagemRecorde.getIconHeight());
        recorde.setLocation(0, this.getHeight() / 2 - (imagemRecorde.getIconHeight()) );     
        recorde.setVisible(true);
        
        labelRecorde = new JLabel(Pontuacao.leitor("arquivoDePontuacao/pontuacao.txt"));
        labelRecorde.setForeground(Color.green);
        Font f = new Font("SansSerif", Font.BOLD, 72);
        labelRecorde.setFont(f);
        labelRecorde.setSize(300, 100);
        labelRecorde.setLocation(250, this.getHeight() / 2 - (imagemRecorde.getIconHeight() / 2) - 30);
        labelRecorde.setVisible(true);
        
        imagemJogar = new ImageIcon("src/imagens/jogar01.png");
        jogar = new JLabel(imagemJogar);
        jogar.setSize(imagemJogar.getIconWidth(), imagemJogar.getIconHeight());
        jogar.setLocation((this.getWidth() / 2) - (imagemJogar.getIconWidth() / 2), this.getHeight() / 2 - (imagemJogar.getIconHeight() / 2));
        jogar.setVisible(true);
        jogar.addMouseListener(new ControleTelaInicial(this, this.clip));
        
        imagemSair = new ImageIcon("src/imagens/sair01.png"); 
        sair = new JLabel(imagemSair);
        sair.setSize(imagemSair.getIconWidth(), imagemSair.getIconHeight());
        sair.setLocation((this.getWidth() - (imagemSair.getIconWidth())) - ((this.getWidth() / 3) - (imagemSair.getIconWidth() / 2)) , this.getHeight() / 2  + (imagemJogar.getIconHeight() / 2));
        sair.setVisible(true);
        sair.addMouseListener(new ControleTelaInicial(this, this.clip));
        
        imagemSobre = new ImageIcon("src/imagens/sobre01.png"); 
        sobre = new JLabel(imagemSobre);
        sobre.setSize(imagemSobre.getIconWidth(), imagemSobre.getIconHeight());
        sobre.setLocation(this.getWidth() / 3 - (imagemSobre.getIconWidth() / 2) , this.getHeight() / 2 + (imagemJogar.getIconHeight() / 2));
        sobre.setVisible(true);
        sobre.addMouseListener(new ControleTelaInicial(this, this.clip));
        
        this.add(nome);
        this.add(sobre);
        this.add(jogar);
        this.add(sair);
        this.add(recorde);
        this.add(labelRecorde);
        this.add(fundo);
        this.repaint();
              
    }

    public JLabel getFundo() {
        return fundo;
    }

    public void setFundo(JLabel fundo) {
        this.fundo = fundo;
    }

    public JLabel getSair() {
        return sair;
    }

    public void setSair(JLabel sair) {
        this.sair = sair;
    }

    public JLabel getJogar() {
        return jogar;
    }

    public void setJogar(JLabel jogar) {
        this.jogar = jogar;
    }

    public JLabel getNome() {
        return nome;
    }

    public void setNome(JLabel nome) {
        this.nome = nome;
    }

    public JLabel getSobre() {
        return sobre;
    }

    public void setSobre(JLabel sobre) {
        this.sobre = sobre;
    }

    public JLabel getRecorde() {
        return recorde;
    }

    public void setRecorde(JLabel recorde) {
        this.recorde = recorde;
    }

    public ImageIcon getImagemFundo() {
        return imagemFundo;
    }

    public void setImagemFundo(ImageIcon imagemFundo) {
        this.imagemFundo = imagemFundo;
    }

    public ImageIcon getImagemNome() {
        return imagemNome;
    }

    public void setImagemNome(ImageIcon imagemNome) {
        this.imagemNome = imagemNome;
    }

    public ImageIcon getImagemSair() {
        return imagemSair;
    }

    public void setImagemSair(ImageIcon imagemSair) {
        this.imagemSair = imagemSair;
    }

    public ImageIcon getImagemJogar() {
        return imagemJogar;
    }

    public void setImagemJogar(ImageIcon imagemJogar) {
        this.imagemJogar = imagemJogar;
    }

    public ImageIcon getImagemRecorde() {
        return imagemRecorde;
    }

    public void setImagemRecorde(ImageIcon imagemRecorde) {
        this.imagemRecorde = imagemRecorde;
    }

    public ImageIcon getImagemSobre() {
        return imagemSobre;
    }

    public void setImagemSobre(ImageIcon imagemSobre) {
        this.imagemSobre = imagemSobre;
    }

    

}
