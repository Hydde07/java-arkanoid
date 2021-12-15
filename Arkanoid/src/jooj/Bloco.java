package jooj;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public abstract class Bloco extends GameObject{
    private boolean dead;
    protected boolean jaganho,ehoamarelo;
    protected int pont;
    private int qt;
    
    public Bloco(int p)
    {
        super();
        this.jaganho=false;
        this.raq=false;
        this.pont = p;
        this.s = new Rectangle(80,15);
        this.dead=false;
        this.larg=80;
        this.alt=8;
    }
    
    public boolean getGanho()
    {
        return this.jaganho;
    }
    
    public void setGanho(boolean top)
    {
        this.jaganho = top;
    }
    
    public int getPontos()
    {
        return this.pont;
    }
    
    public boolean Morreu(){
        if(isDead())
        {
            this.s.setLayoutX(1500);
            return true;
        }
        else
            return false;
    }
    
    abstract void movimentar(GameObject px);
    
    
    
    boolean preconceito()
    {
        return !ehoamarelo;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    /**
     * @return the dead
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * @param dead the dead to set
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
}
