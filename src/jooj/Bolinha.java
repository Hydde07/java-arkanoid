package jooj;

import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bolinha extends GameObject{
    private int f,g;
    private double velx,vely;
    private boolean god;
    
    public Bolinha()
    {
        this.god = true;
        this.velx=3;
        this.vely=6;
        this.f=1;
        this.g=1;
        this.s = new Circle(6);
        this.alt = 6;
        this.larg = 6;
        this.s.setFill(rgb(255,250,250));
        this.raq=false;
    }
    
    void salvacao()
    {
        this.setG(this.getG() * -1);
    }
    
    boolean pegaGod()
    {
        return god;
    }
    
    void goderoso()
    {
        god=true;
    }
    
    public boolean Colidiu(Shape obj){
        return super.getS().getBoundsInParent().intersects(obj.getBoundsInParent());
    }
    
    void colisao(GameObject px)
    {
        if(colideObj(px,true) && colideObj(px,false))
        {
            setF(getF() * -1);
            setG(getG() * -1);
            this.god = false;
        }
        else
        {
            if(px.raq && (colideObj(px,false) || colideObj(px,true)))
            {
               if(px.dir==2)
                   setVelx(getVelx() + 0.05);
               else
                   setVelx(getVelx() - 0.05);
               this.god = false;
            }
            if(colideObj(px,true))
            {
                setG(getG() * -1);
                this.god = false;
            }
            else if(colideObj(px,false))
            {
//                if(f==1)
//                {
//                    this.setX(px.getX() - this.larg - 1);
//                }
//                else
//                    this.setX(px.getX() + px.larg + this.larg + 1);
                setF(getF() * -1);
                this.god = false;
            }
        }
//        if(fodex)
//            setVelx(getVelx() + 0.03);
        
    }
    boolean colideObj(GameObject px,boolean cima)
    {
        if(cima)
            return dentroObj(px) && Diro(px,true);
        else
            return dentroObj(px) && Diro(px,false);
    }
    
    boolean Diro(GameObject px,boolean y)
    {
        Circle test2 = new Circle(this.getX(), this.getY(),this.larg+1);
        Shape test = Shape.intersect(px.getShape(), test2);
        Rectangle H = new Rectangle(px.getX(), px.getY(),px.larg,1);
        Rectangle H1 = new Rectangle(px.getX(),px.getY()+px.alt-1,px.larg,1);
        Rectangle H2 = new Rectangle(px.getX(), px.getY(),1,px.alt);
        Rectangle H3 = new Rectangle(px.getX()+px.larg, px.getY(),1,px.alt);
        if(y)
            return dentroObj(H,test) || dentroObj(H1,test);
        else
            return dentroObj(H2,test) || dentroObj(H3,test);
    }
    
    boolean dentroObj(GameObject px)
    {
        Circle test2 = new Circle(this.getX(), this.getY(),this.larg+1);
        Shape test = Shape.intersect(px.getShape(), test2);
        return test.getBoundsInLocal().getWidth()!=-1 || test.getBoundsInLocal().getHeight()!=-1;
    }
    
    boolean dentroObj(Shape px,Shape px2)
    {
        Shape test = Shape.intersect(px, px2);
        return test.getBoundsInLocal().getWidth()!=-1 || test.getBoundsInLocal().getHeight()!=-1;
    }
    
    boolean fudido(double a)
    {
        return this.getY() + this.alt + 1>= a;
    }
    
    boolean colidePane(double a,double l,boolean cima)
    {
        if(cima)
            return (this.getY() - this.alt - 1 <=0);
        else
            return (this.getX() + this.larg + 1>= l || this.getX() - this.alt - 1 <=0);
    }
    
    void movimentar(double altura, double largura)
    {
        if(colidePane(altura,largura,true))
            setG(getG() * -1);
        if(colidePane(altura,largura,false))
            setF(getF() * -1);
        this.setX(this.getX() + getVelx()*getF());
        this.setY(this.getY() + getVely()*getG());
        this.s.setLayoutY(this.getY());
        this.s.setLayoutX(this.getX());
    }

    public double getVelx() {
        return velx;
    }

    public void setVelx(double velx) {
        this.velx = velx;
    }

    public double getVely() {
        return vely;
    }

    public void setVely(double vely) {
        this.vely = vely;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }
    
}

