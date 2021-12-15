package jooj;

import static javafx.scene.paint.Color.rgb;

public class BlocoAmarelo extends Bloco{
    
    public BlocoAmarelo() {
        super(1);
        this.ehoamarelo=true;
        this.s.setFill(rgb(255,255,0));
    }

    @Override
    void movimentar(GameObject px) {
        if(this.getQt()==1)
            this.setDead(true);
    }
}