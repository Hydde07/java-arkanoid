package jooj;

import javafx.scene.shape.Shape;

public class GameObject {
    protected Shape s;
    private double x;
    private double y;
    protected double larg,alt;
    protected boolean raq;
    protected int dir;
    
    public Shape getShape()
    {
        return this.s;
    }
    
    public int getDir() {
        return dir;
    }
    
    public Shape getS(){
        return this.s;
    }
    
    public void Desenhar(int xo, int yo){
        this.setX(xo);
        this.setY(yo);
        this.s.setLayoutX(getX());
        this.s.setLayoutY(getY());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
