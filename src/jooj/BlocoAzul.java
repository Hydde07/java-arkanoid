package jooj;

import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Shape;

public class BlocoAzul extends Bloco{
    
    private final int a;
    private boolean toca;
    
    
    public BlocoAzul(int ta) {
        super(0);
        this.a = ta;
        this.ehoamarelo=false;
        this.toca=false;
        s.setFill(rgb(0,220,255));
    }
    @Override
    public void movimentar(GameObject px)
    {
        morre(px);
        if(this.getQt()==2)
            this.setDead(true);
        else if(this.getQt()==1)
        {
            this.pont=10;
            if(this.getY()+10 >= a || toca)
            {
                this.pont = 0;
                this.setDead(true);
            }
            else
            {
                this.s.setLayoutY(getY());
                this.setY(this.getY() + 1.5);
            }
        }
    }
    
    public void morre(GameObject px)
    {
        Shape test = Shape.intersect(px.getShape(), this.getShape());
        this.toca = test.getBoundsInLocal().getWidth()!=-1 || test.getBoundsInLocal().getHeight()!=-1;
    }
}
