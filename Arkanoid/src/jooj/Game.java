package jooj;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
public class Game extends Pane{
    
    private int rest;
    private Pontuacao ponta = new Pontuacao();
    private ArrayList<Bloco> gg;
    private Bloco nameless;
    private Bolinha bb;
    private Raquete pj;
    private Rectangle chao;
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Dimension dim = tk.getScreenSize();
    private Button jogar;
    Point p = MouseInfo.getPointerInfo().getLocation();
    AnimationTimer atimer;
    private int c,d,gc,gd;
     private Text frase2;
    private Font fonte;
    private int antx,anty;
    private double altu,largu,xdatela;
    private boolean inicia;
    private ImageView imageview;
    KeyEvent event;
    private Button button,voltar;
    private int vida;
    private String path2 = "src\\jooj\\DeadSea.mp3";
    private Media media2 = new Media(new File(path2).toURI().toString());  
    private MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
    private String path = "src\\jooj\\Megalovania.mp3";
    private Media media = new Media(new File(path).toURI().toString());  
    private MediaPlayer mediaPlayer = new MediaPlayer(media); 
    private String path3 = "src\\jooj\\FinalFantasyPSXMusicExtended.mp3";
    private Media media3 = new Media(new File(path3).toURI().toString());  
    private MediaPlayer mediaPlayer3 = new MediaPlayer(media3); 
    private boolean jaFoi,pause;
    private MaxPoint maximo;

//    public Game(ArrayList<Bloco> gg, Bloco nameless, Bolinha bb, Raquete pj, Rectangle chao, Button jogar, AnimationTimer atimer, int c, int d, int gc, int gd, Text frase2, Font fonte, double altu, double largu, double xdatela, boolean inicia, ImageView imageview, Button button) {
//        this.gg = gg;
//        this.nameless = nameless;
//        this.bb = bb;
//        this.pj = pj;
//        this.chao = chao;
//        this.jogar = jogar;
//        this.atimer = atimer;
//        this.c = c;
//        this.d = d;
//        this.gc = gc;
//        this.gd = gd;
//        this.frase2 = frase2;
//        this.fonte = fonte;
//        this.altu = altu;
//        this.largu = largu;
//        this.xdatela = xdatela;
//        this.inicia = inicia;
//        this.imageview = imageview;
//        this.button = button;
//    }
    
    public Game() throws IOException
    {
        super();
        maximo = new MaxPoint();
        jaFoi=false;
        inicializar();
        
    }
    
    public void jogar()
    {
        pause=false;
        ponta.zerar();
        mediaPlayer3.stop();
        mediaPlayer2.stop();
       mediaPlayer.play();
        rest=28;
        vida=3;
        chao = new Rectangle(0,401,700,1);
        inicia = true;
        xdatela = dim.width/2-350-2;
        gg = new ArrayList();
        int q;
        bb = new Bolinha();
        pj = new Raquete();
        altu=400;
        largu=700;
        antx = 350;
        anty = 200;
        frase2 = new Text();
        fonte = new Font("Courier New",30);
        frase2.setFont(fonte);
        frase2.setFill(Color.WHITE);
        frase2.setText("Vidas: "+vida);
        frase2.setX(400);
        frase2.setY(480);
        Random rand = new Random();
        for(int i=1;i<=7;i++)
        {
            for(int j=1;j<=4;j++)
            {
                q = rand.nextInt(3);
                if(q==0)
                    nameless = (new BlocoAzul(400));
                else if(q==1)
                    nameless = (new BlocoVerde(300,700));
                else if(q==2)
                    nameless = (new BlocoAmarelo());
                if(i==1)
                {
                    c=45;
                    gc=0;
                }
                else
                {
                    c=90;
                    gc=45;
                }
                if(j==1)
                {
                    d=20;
                    gd=0;
                }
                else
                {
                    d=30;
                    gd=10;
                }
                nameless.Desenhar(c*i-gc,d*j-gd);
                gg.add(nameless);
                this.getChildren().add(gg.get(gg.size()-1).getShape());
            }
        }
        bb.Desenhar(350,200);
        pj.Desenhar(p.x,370);
        
        this.getChildren().add(ponta.desenhar(10, 480));
        getChildren().add(this.maximo.desenhar(10, 515));
        this.getChildren().add(bb.getShape());
        this.getChildren().add(pj.getShape());
        this.getChildren().add(frase2);
        chao.setFill(Color.WHITE);
        
        this.getChildren().add(chao);
                
        atimer = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                if(!pause)
                {
                    mediaPlayer.play();
                    p = MouseInfo.getPointerInfo().getLocation();
                        for (Bloco gg1 : gg) {
                            gg1.movimentar(pj);
                            if(gg1.isDead() && !gg1.getGanho())
                            {
                                rest--;
                                gg1.setGanho(true);
                            }
                            if(bb.Colidiu(gg1.getShape()))
                            {

                                ponta.somar(gg1.pont);
                                gg1.setQt(gg1.getQt()+1);

                                //f horizontal 
                                //g vertical


                                 if(bb.getY() < gg1.getY()) //1
                                 {
                                    if(bb.getX()> gg1.getX()+5 && bb.getX() < gg1.getX()+75)
                                        bb.setG(bb.getG()*-1);
                                    else
                                    {
                                        if(bb.getX() < gg1.getX()+5)
                                            bb.setF(-1);
                                        else
                                            bb.setF(1);
                                        bb.setG(-1);
                                    }
                                 }
                                  else if(bb.getX()> gg1.getX()+5 && bb.getX() < gg1.getX()+75)
                                      bb.setG(bb.getG()*-1);
                                  else if(bb.getY() <  gg1.getY()  +10)
                                  {
                                      bb.setF(bb.getF()*-1);
                                  }
                                  else if(bb.getX() < gg1.getX()+40)
                                  {
                                      bb.setF(-1);
                                      bb.setG(1);
                                  }
                                 else
                                  {
                                      bb.setF(1);
                                      bb.setG(1);
                                  }

                            }
                            bb.colisao(pj);
                            frase2.setText("Vidas: "+vida);
                            if(bb.fudido(401))
                            {
                                frase2.setText("Vidas: "+--vida);
                                bb.setX(350);
                                bb.setY(200);
                                bb.movimentar(altu, largu);
                                bb.salvacao();
                                bb.setVelx(3);
                                bb.setVely(6);
                            }
                            gg1.Morreu();

                        }
                        antx  = (int) bb.getX();
                        anty = (int) bb.getY();
                        pj.movimentar(p.x-xdatela-pj.larg/2);
                        bb.colisao(pj);
                        bb.movimentar(altu,largu);
                    pj.movimentar(p.x-xdatela-pj.larg/2);
                    if(vida==0)
                    {
                        try {
                            top();
                        } catch (IOException ex) {
                            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        mediaPlayer.stop();
                    }
                    else if(rest==0)
                    {
                        win();
                        mediaPlayer.stop();
                    }
                }
                else
                    mediaPlayer.pause();
            }
        };
        atimer.start();
        this.setOnMouseClicked(e->{pause=!pause;});
    }
   public void top() throws IOException{
       trocaPonto(ponta.getPontos(),maximo.getPontos());
       mediaPlayer2.play();
       getChildren().clear();
       Rectangle telapreta = new Rectangle(700,550,rgb(0,0,0));
       this.getChildren().add(telapreta);
       atimer.stop();
       String path = "src\\jooj\\Toop.mp4";
       Media media = new Media(new File(path).toURI().toString());
       MediaPlayer mediaPlayer = new MediaPlayer(media);
       MediaView mediaView = new MediaView(mediaPlayer);
       mediaPlayer.setAutoPlay(true);  
       mediaView.autosize();
       mediaView.setLayoutX(110);
       mediaView.setLayoutY(35);
       
       this.getChildren().add(mediaView);
       getChildren().add(this.ponta.desenhar(285, 500));
       jaFoi=true;
       inicializar();
   }
   public void win()
   {
       trocaPonto(ponta.getPontos(),maximo.getPontos());
        Image image = new Image(getClass().getResourceAsStream("/img/backbutton.png"));
        mediaPlayer3.play();
        atimer.stop();
        String url;
        url = "/img/youwin.png";
        getChildren().clear();
        getChildren().add(this.ponta.desenhar(285, 400));
        Image imagem = new Image(url);
        ImageView imgView = new ImageView(imagem);
        imgView.minHeight(300);
        imgView.minWidth(300);
        imgView.setLayoutX(200);
        imgView.setLayoutY(150);
        this.getChildren().add(imgView);
        
        
        ImageView back = new ImageView(image);
        back.setFitHeight(80);
        back.setFitWidth(120);
     
        this.voltar  = new Button();
        voltar.setText("");  
        voltar.setLayoutX(300);
        voltar.setLayoutY(450);
        imgView.setFitHeight(200);
        imgView.setFitWidth(300);
        
        voltar.setGraphic(back);
        jaFoi=true;
        voltar.setStyle("-fx-background-color: transparent;");
        getChildren().add(voltar);
        voltar.setOnAction(e->{
            getChildren().clear();
           try {
               mediaPlayer3.stop();
               inicializar();
           } catch (IOException ex) {
               Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
           }
});
   }
   
   void trocaPonto(int pont, int pontmax)
   {
       if(pont>pontmax)
           maximo.setPont(pont);
   }
   
   public void inicializar() throws IOException
    {
        getChildren().add(this.maximo.desenhar(245, 530));
        Image image,image2;
        jogar  = new Button();
        if(jaFoi)
        {
            image = new Image(getClass().getResourceAsStream("/img/startgame2.png"));
            jogar.setLayoutX(190);
            jogar.setLayoutY(50);
        }
        else
        {
            image = new Image(getClass().getResourceAsStream("/img/startgame.png"));
            jogar.setLayoutX(190);
            jogar.setLayoutY(200);
        }
        image2 = new Image(getClass().getResourceAsStream("/img/logo.png"));
        ImageView imgv = new ImageView(image2);
        imgv.setLayoutX(211);
        imgv.setLayoutY(5);
        jogar.setText("");
        jogar.setMinWidth(60);
        jogar.setMinHeight(60);
        jogar.setGraphic(new ImageView(image));
        jogar.setStyle("-fx-background-color: transparent;");
        getChildren().add(jogar);
        getChildren().add(imgv);
        jogar.setOnAction(e->{
            getChildren().clear();
            jogar();});
        
        
     }
}
