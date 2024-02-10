package jooj;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class MaxPoint{
    private int pontos;
    private Text frase;
    private Font fonte;
    public MaxPoint()
    {
        this.pontos = 0;
        fonte = new Font("Courier New",30);
           
        frase = new Text();
    }
    
    public void zerar()
    {
        this.pontos = 0;
    }
    
    public void setPont(int valor)
    {
        
        this.pontos=valor;
        this.frase.setText("HighScore:"+getPontos());
    }
    public int getPontos()
    {
   
        return this.pontos;
    }
    public Text desenhar(int xo,int yo)
    {
        this.frase = new Text("HighScore:"+getPontos());
        this.frase.setFont(fonte);
        this.frase.setFill(Color.WHITE);
        this.frase.setX(xo);
        this.frase.setY(yo);
        return this.frase;
    }
}
