package telas;

import controles.ControleTelaSobre;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class  TelaSobre extends JFrame {
    
    private ImageIcon imagemvoltar, imagemFundo, imagemWasd;
    private JLabel voltar, fundo, wasd;
    public TelaSobre(){
        
        this.setSize(1244, 650);
        this.setVisible(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        
        imagemvoltar = new ImageIcon("src/imagens/voltar01.png");
        voltar = new JLabel (imagemvoltar);
        voltar.setSize(imagemvoltar.getIconWidth(), imagemvoltar.getIconHeight());
        voltar.setLocation((this.getWidth() / 2) - (imagemvoltar.getIconWidth() / 2), this.getHeight() - (imagemvoltar.getIconHeight()));
        voltar.setVisible(true);
        voltar.addMouseListener(new ControleTelaSobre(this));
        
        imagemWasd = new ImageIcon("src/imagens/wasd.png");
        wasd = new JLabel (imagemWasd);
        wasd.setSize(imagemWasd.getIconWidth(), imagemWasd.getIconHeight());
        wasd.setLocation((this.getWidth() / 2) - (imagemWasd.getIconWidth() / 2),0);
        wasd.setVisible(true);
        
        imagemFundo = new ImageIcon("src/imagens/fundo1.jpg");
        fundo = new JLabel(imagemFundo);
        fundo.setSize(this.getWidth(), this.getHeight());
        fundo.setLocation(0, 0);
        fundo.setVisible(true);
        
        this.add(wasd);
        this.add(voltar);
        this.add(fundo);
        
        this.repaint();

    }

    public JLabel getVoltar() {
        return voltar;
    }

    public void setVoltar(JLabel voltar) {
        this.voltar = voltar;
    }

   
    
        
    
     
   
    



 
}
