package jooj;

import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Rectangle;

public class Raquete extends GameObject {
    
    public Raquete()
    {
        dir=0;
        this.s = new Rectangle(75,6);
        this.larg = 75;
        this.alt = 6;
        this.s.setFill(rgb(255,250,250));
        this.raq=true;
    }
    
    public void movimentar(double yo)
    {
        if(this.getX()<yo)
            dir=1;
        else if(this.getX()>yo)
            dir=2;
        this.setX(yo);
        this.s.setLayoutX(yo);
    }

}
