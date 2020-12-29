package controles;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;
import static javafx.beans.binding.Bindings.or;
import model.ThreadFase;
import telas.Fase;

public class ControleFase implements KeyListener {

    private Fase fase;

    public ControleFase(Fase aThis) {
        fase = aThis;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            
            if(fase.getPersonagem().getY() < fase.getHeight()){
                
                if(fase.getPersonagem().getY() >= 15){
                    fase.getPersonagem().setLocation(fase.getPersonagem().getX(), fase.getPersonagem().getY() - 20);
                    fase.getFundo().setLocation(fase.getFundo().getX(), fase.getFundo().getY() + 2);
                }
            }
        }

        else if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
                if(fase.getPersonagem().getY() >= fase.getHeight()){

                }
                else{
                    if(fase.getPersonagem().getY() < 550){
                        fase.getPersonagem().setLocation(fase.getPersonagem().getX(), fase.getPersonagem().getY() + 20);
                        fase.getFundo().setLocation(fase.getFundo().getX(), fase.getFundo().getY() - 2);
                    }                    
                }
        }
        
        else if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
                if(fase.getPersonagem().getX() <= 0){
                }
                else{
                    if(fase.getPersonagem().getX() > 10){
                        fase.getPersonagem().setLocation(fase.getPersonagem().getX() - 20, fase.getPersonagem().getY());
                        fase.getFundo().setLocation(fase.getFundo().getX() + 2, fase.getFundo().getY());
                    }                    
                }
            
        }
        
        else if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                if(fase.getPersonagem().getX() >= fase.getWidth()){
                    
                }
                else{
                    if(fase.getPersonagem().getX() < 1080){
                        fase.getPersonagem().setLocation(fase.getPersonagem().getX() + 20, fase.getPersonagem().getY());
                        fase.getFundo().setLocation(fase.getFundo().getX() - 2, fase.getFundo().getY());
                    }                    
                }

        }
        
    }
    

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}

