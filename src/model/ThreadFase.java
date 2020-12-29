package model;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import telas.Fase;
import telas.GameOver;

public class ThreadFase extends Thread {

    private Fase fase;
    private Clip clip, clip2;
    private AudioInputStream audioInputStream, audioInputStream2;

    public ThreadFase(Fase fase) throws IOException, LineUnavailableException{
        this.fase = fase;     
    }

    public void run() {
        
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/musicas/portal.wav").getAbsoluteFile());
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
        
        boolean gameover = false;
        
        
        while (!gameover) {            
                       
            //andar com os ateroides
            for(int i = 0; i < fase.getAsteroides().size(); i++){
                Asteroide aste = fase.getAsteroides().get(i);
                
                if(aste.getX() < -195){
                    fase.setPontuacao(fase.getPontuacao() + 5); 
                    
                    fase.getAmostraDaPontuacao().setText("PONTUAÇÃO: " + fase.getPontuacao() );
                    
                    fase.getAsteroides().get(i).setVisible(false);
                    fase.remove(fase.getAsteroides().get(i));
                    fase.getAsteroides().remove(i);
                    i--;
                }
                
                else{
                    aste.setLocation(aste.getX() - aste.getVelocidade(), aste.getY());
                } 
                
                if(aste.getBounds().intersects(fase.getPersonagem().getBounds())){
                    gameover = true;
                    
                }
                    
            }  
            
            //sortear os asteorides
            
            Random aleatorio = new Random();
            
            int possibilidadeDeAsteroide = aleatorio.nextInt(1800);
            int possibilidadeDoEixoY = aleatorio.nextInt(4);
            
            //Adicionando um asteroide grande            
            if(possibilidadeDeAsteroide <= 2){
                Asteroide asteroideGrande = new Asteroide(retornaAVelocidade(fase.getPontuacao()), Asteroide.ASTEROIDE_GRANDE); 
                fase.getAsteroides().add(asteroideGrande);
                
                this.retornaOAsteroide(possibilidadeDoEixoY, asteroideGrande);
                
                asteroideGrande.setVisible(true);
                fase.getPainel().add(asteroideGrande);
                fase.getPainel().setComponentZOrder(asteroideGrande, 0);
              
            }
            
            //Adicionando um asteroide medio           
            if(possibilidadeDeAsteroide >= 4 && possibilidadeDeAsteroide <= 8){
                int velocidade = retornaAVelocidade(fase.getPontuacao());
                Asteroide asteroideMedio = new Asteroide(retornaAVelocidade(fase.getPontuacao()), Asteroide.ASTEROIDE_MEDIO); 
                fase.getAsteroides().add(asteroideMedio);
                
                this.retornaOAsteroide(possibilidadeDoEixoY, asteroideMedio);
                
                asteroideMedio.setVisible(true);
                fase.getPainel().add(asteroideMedio);
                fase.getPainel().setComponentZOrder(asteroideMedio, 0);
              
            }
            
            //adicionando um asteroide pequeno
            else if(possibilidadeDeAsteroide > 8 && possibilidadeDeAsteroide <= 13){
                Asteroide asteroidePequeno = new Asteroide(retornaAVelocidade(fase.getPontuacao()), Asteroide.ASTEROIDE_PEQUENO); 
               
                fase.getAsteroides().add(asteroidePequeno);
                
                this.retornaOAsteroide(possibilidadeDoEixoY, asteroidePequeno);
                
                asteroidePequeno.setVisible(true);
                fase.getPainel().add(asteroidePequeno);
                fase.getPainel().setComponentZOrder(asteroidePequeno, 0);
              
            }
             
        try {
            sleep(15);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex);
            }               
            
        }
        
        try {
            clip.stop();
            
        try {
            audioInputStream2 = AudioSystem.getAudioInputStream(new File("src/musicas/gameOver_1_.wav").getAbsoluteFile());
            clip2 = AudioSystem.getClip();
            clip2.open(audioInputStream2);
            clip2.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex);
        }
            GameOver game = new GameOver(fase.getPontuacao());
            fase.dispose();
        } catch (IOException ex1) {
                Logger.getLogger(ThreadFase.class.getName()).log(Level.SEVERE, null, ex1);
            }
        

        }
    
    public void retornaOAsteroide(int possibilidade, Asteroide asteroide){
        
        if(possibilidade == 0){
            asteroide.setLocation(fase.getWidth(), 0);
        }
                
        else if(possibilidade == 1){
            asteroide.setLocation(fase.getWidth(), (fase.getHeight() / 2) - (asteroide.getIcon().getIconHeight()));
        }
        
        else if (possibilidade == 2){
            asteroide.setLocation(fase.getWidth(), (fase.getHeight() / 2));
        }        
                
        else if(possibilidade == 3){
            asteroide.setLocation(fase.getWidth(), fase.getHeight() - asteroide.getIcon().getIconHeight());
        }
        
    }
    
    public int retornaAVelocidade(int pontuacao){
        if(pontuacao <= 500){
           return 4;
        } 
       
        else if(pontuacao > 500 && pontuacao <= 800){
           return 5;
        }
       
        else if(pontuacao > 800 && pontuacao <= 1000){
            return 6;
        }
        
        else if(pontuacao > 1000 && pontuacao <= 1100){
            return 7;
        }
        
        else if(pontuacao > 1100 && pontuacao <= 1200){
            return 8;
        }
        
        else if (pontuacao > 1200 && pontuacao <= 1250){
            return 9;
        }
        
        else{
            return ((int)(pontuacao/500))+5;
        }
        
    }
    
}

