package telas;

import controles.ControleGameOver;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Pontuacao;

public class GameOver extends JFrame{
    private JLabel gameOver, reiniciar, voltar, newRecordeOUnao, recorde;
    private ImageIcon imagemReiniciar, imagemVoltar, imagemGameOver, imagemNewRecordeOUnao;
    private int pontuacaoINT, pontuacaoArquivoINT;
    private String pontuacaoSTR, pontuacaoArquivoSTR;
    
    public GameOver(int ponto) throws IOException{
        this.pontuacaoINT = ponto;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1244, 650);
        this.setLocation(0, 100);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.black);
        
        pontuacaoArquivoSTR = Pontuacao.leitor("arquivoDePontuacao/pontuacao.txt");
        pontuacaoArquivoINT = Integer.parseInt(pontuacaoArquivoSTR);
               
        if(this.pontuacaoINT > pontuacaoArquivoINT){
            
            pontuacaoArquivoINT = this.pontuacaoINT;
            pontuacaoArquivoSTR = this.pontuacaoArquivoINT + "";
            Pontuacao.escritor("arquivoDePontuacao/pontuacao.txt", pontuacaoArquivoSTR);
            imagemNewRecordeOUnao = new ImageIcon("src/imagens/recorde02.png");
            newRecordeOUnao = new JLabel(imagemNewRecordeOUnao);
            newRecordeOUnao.setSize(imagemNewRecordeOUnao.getIconWidth(), imagemNewRecordeOUnao.getIconHeight());
            newRecordeOUnao.setLocation(this.getWidth() / 2 - (imagemNewRecordeOUnao.getIconWidth()), this.getHeight() / 2 - (imagemNewRecordeOUnao.getIconHeight() - 40));
            newRecordeOUnao.setVisible(true);
        }
        
        else{
            this.pontuacaoSTR = this.pontuacaoINT + "";
            imagemNewRecordeOUnao = new ImageIcon("src/imagens/recorde01.png");
            newRecordeOUnao = new JLabel(imagemNewRecordeOUnao);
            newRecordeOUnao.setSize(imagemNewRecordeOUnao.getIconWidth(), imagemNewRecordeOUnao.getIconHeight());
            newRecordeOUnao.setLocation(this.getWidth() / 2 - (imagemNewRecordeOUnao.getIconWidth()), this.getHeight() / 2 - (imagemNewRecordeOUnao.getIconHeight() - 40));
            newRecordeOUnao.setVisible(true);          
        }
        
        this.pontuacaoSTR = this.pontuacaoINT + "";
        recorde = new JLabel(this.pontuacaoSTR);
        recorde.setForeground(Color.green);
        Font f = new Font("SansSerif", Font.BOLD, 72);
        recorde.setFont(f);
        recorde.setSize(300, 100);
        recorde.setLocation(630,this.getHeight() / 2 - (recorde.getHeight()));
        recorde.setVisible(true);
               
        imagemGameOver = new ImageIcon("src/imagens/gameOver.png");
        gameOver = new JLabel(imagemGameOver);
        gameOver.setSize(imagemGameOver.getIconWidth(), imagemGameOver.getIconHeight());
        gameOver.setLocation(this.getWidth() / 2 - (imagemGameOver.getIconWidth() / 2), 0);
        gameOver.setVisible(true);
        
        imagemReiniciar = new ImageIcon("src/imagens/reiniciar01.png");
        reiniciar = new JLabel(imagemReiniciar);
        reiniciar.setSize(imagemReiniciar.getIconWidth(), imagemReiniciar.getIconHeight());
        reiniciar.setLocation(this.getWidth() / 2 - (imagemReiniciar.getIconWidth()) , this.getHeight() / 2 + (imagemReiniciar.getIconHeight() / 2));
        reiniciar.setVisible(true);
        reiniciar.addMouseListener(new ControleGameOver(this));
        
        imagemVoltar = new ImageIcon("src/imagens/voltar01.png");
        voltar = new JLabel(imagemVoltar);
        voltar.setSize(imagemVoltar.getIconWidth(), imagemVoltar.getIconHeight());
        voltar.setLocation(this.getWidth() / 2, this.getHeight() / 2 + (imagemVoltar.getIconHeight() / 2));
        voltar.setVisible(true);
        voltar.addMouseListener(new ControleGameOver(this));
        
        this.add(newRecordeOUnao);
        this.add(recorde);
        this.add(voltar);
        this.add(reiniciar);
        this.add(gameOver);    
        this.repaint();
                  
    }

    public JLabel getReiniciar() {
        return reiniciar;
    }

    public void setReiniciar(JLabel reiniciar) {
        this.reiniciar = reiniciar;
    }

    public JLabel getVoltar() {
        return voltar;
    }

    public void setVoltar(JLabel voltar) {
        this.voltar = voltar;
    }

    
}
