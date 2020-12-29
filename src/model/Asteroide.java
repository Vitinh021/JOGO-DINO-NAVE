package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Asteroide extends JLabel{
    private int velocidade;
    private JLabel imagem;
    public static final int ASTEROIDE_GRANDE=1,ASTEROIDE_MEDIO=2,ASTEROIDE_PEQUENO=3;
    
    public Asteroide(int velocidade,  int opcao){
        this.velocidade = velocidade;
      
        
        if(opcao==ASTEROIDE_GRANDE){
            setIcon(new ImageIcon("src/imagens/asteroideGrandeedt.png"));
        
        }
        
        else if (opcao==ASTEROIDE_MEDIO){
            setIcon(new ImageIcon("src/imagens/asteroideMedioedt.png"));
        }
        
        else if (opcao==ASTEROIDE_PEQUENO){
            setIcon(new ImageIcon("src/imagens/asteroidePequenoedt.png"));
        }          
        
        setSize(getIcon().getIconWidth(),getIcon().getIconHeight());
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public JLabel getImagem() {
        return imagem;
    }

    public void setImagem(JLabel imagem) {
        this.imagem = imagem;
    }
    
    
    
}