package jooj;

import static javafx.scene.paint.Color.rgb;

public class BlocoVerde extends Bloco{

    private int f;
    private final int a;
    private final int c;
    
    public BlocoVerde(int ta,int tc) {
        super(0);
        this.f=1;
        this.ehoamarelo=false;
        this.a = ta;
        this.c = tc;
        s.setFill(rgb(0,255,0));
    }
    @Override
    public void movimentar(GameObject px)
    {
        if(this.getQt()==1)
        {
            this.pont=5;
            if(this.getY()+10 == a)
            {
                this.setX(this.getX() + 1.5*f);
                if(this.getX()+this.larg>=c || this.getX()-1<=0)
                    f*=-1;
                this.s.setLayoutX(this.getX());
            }
            else
            {
                this.s.setLayoutY(getY());
                this.setY(this.getY() + 1.5);
            }
        }
        else if(this.getQt()==2)
            this.setDead(true);
    }
}
