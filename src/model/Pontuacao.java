package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Pontuacao {
    private int pontuacao;
    private static String linha;
    
    public Pontuacao(int pontos){
        this.pontuacao = pontos;    
    }
    
    public static String leitor(String arquivo) throws IOException {
        FileReader abridorLer = new FileReader(arquivo);
        BufferedReader leitor = new BufferedReader(abridorLer);
        linha = leitor.readLine();
        return linha;
    }
    
    public static void escritor(String arquivo, String linha) throws IOException {
        zerarArquivo(arquivo);
        FileWriter abridorEscrever = new FileWriter(arquivo, true);
        PrintWriter buffWrite = new PrintWriter(abridorEscrever, true);
        buffWrite.print(linha);
        buffWrite.close();
    }
    
    public static void zerarArquivo(String arquivo) throws IOException {
        FileWriter abridorEscrever = new FileWriter(arquivo);
        PrintWriter buffWriter = new PrintWriter(abridorEscrever, true);
        buffWriter.close();
    }
}
