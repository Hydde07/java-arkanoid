/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jooj;




import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class Pontuacao{
    private int pontos;
    private Text frase;
    private Font fonte;
    public Pontuacao()
    {
        this.pontos = 0;
        fonte = new Font("Courier New",30);
           
        frase = new Text();
    }
    
    public void zerar()
    {
        this.pontos = 0;
    }
    public void subtrair(int valor)
    {
        this.pontos-=valor;
    }
    public void somar(int valor)
    {
        
        this.pontos+=valor;
        this.frase.setText("Score:"+getPontos());
    }
    public int getPontos()
    {
   
        return this.pontos;
    }
    public Text desenhar(int xo,int yo)
    {
        this.frase = new Text("Score:"+getPontos());
        this.frase.setFont(fonte);
        this.frase.setFill(Color.WHITE);
        this.frase.setX(xo);
        this.frase.setY(yo);
    


        return this.frase;
    }
}
