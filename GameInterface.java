import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameInterface extends JPanel implements Runnable
{
    //FPS = 60
    int FPS = 60;
    final int ogTileSize = 16; // tile-uri de 16x16
    final int scalabil = 4;
    public final int tileSize =  ogTileSize * scalabil; // 64x64 tile-uri
    public final int maxScreenColoane = 16;
    public final int maxScreenRanduri = 12;

    public final int Latime = tileSize * maxScreenColoane; // 64 x 16 = 1024
    public final int Lungime = tileSize * maxScreenRanduri; // 64 x 12 = 768

    // Setari World

    public final int maxWorldCol = 50;
    public final int maxWorldRanduri = 50;

    // Sistem
    Controale rexKey = new Controale(this);
    TileAsezare tileA = new TileAsezare(this);

    public AsezareLucruri aSet = new AsezareLucruri(this);
    Sound music = new Sound();
    Sound sound = new Sound();
    public InterfataUser iu = new InterfataUser(this);
    public ColiziuniCheck Coliziune = new ColiziuniCheck(this);

    // Obiecte si entitati
    public SuperObiect[] obiect = new SuperObiect[10]; // maxim 10 obiecte
    public rexbibanu RexBibanu = new rexbibanu(this, rexKey); // rex bibanu e instantiat dupa ce sunt verificate coliziunile
    public Entitati[] NPC = new Entitati[10]; // maxim 10 npcs
    public Entitati[] Monstrii = new Entitati[23]; // maxim 23 monstrii
    Database_Manager DB = new Database_Manager();


    Thread gameThread; // game thread e instantiat aici pt ca mai
    // Intai trebuie initializate celelalte metode de mai sus (y)

    // Status joculet
    public int StatusJoc;
    public final int StatusStart = 1;
    public final int StatusPauza = 2;
    public final int StatusTitle = 0;
    public final int StatusGameOver = 3;

    public GameInterface()
    {
        this.setPreferredSize(new Dimension(Latime, Lungime));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(rexKey);
        this.setFocusable(true);
    }

    public void setupGame()
    {
        //playMusic(1);
        //stopMusic();
        aSet.SetEntitati();
        aSet.SetObiect();
        aSet.SetMonstrii();
        StatusJoc = 0;
    }

    public void retry()
    {
        RexBibanu.setDefaultPositions();
        RexBibanu.restoreHP();
        aSet.SetEntitati();
        aSet.SetMonstrii();
    }
    public void restart()
    {
        RexBibanu.setDefaultPositions();
        RexBibanu.restoreHP();
        aSet.SetEntitati();
        aSet.SetMonstrii();
        aSet.SetObiect();
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run()
    {
        double Interval = 1000000000.00/FPS; //0.01(6) secunde
        double nextInterval = System.nanoTime() + Interval;

        while(gameThread != null)
        {
            update(); //Update la noile valori
            repaint(); //Repaint pe ecran cu noile valori
            if(rexKey.Save)
            {
                DB.insertData(RexBibanu.KillCount, RexBibanu.worldX, RexBibanu.worldY, "Sword");
                DB.printData();
            }

            double TimpRamas = nextInterval - System.nanoTime();
            TimpRamas /= 1000000;
            try {
                if(TimpRamas < 0) TimpRamas = 0;

                Thread.sleep((long) TimpRamas); // Sleep la timpul ramas dintre update + repaint si FPS

                nextInterval += Interval;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }


    public void update()
    {
        if(StatusJoc == StatusStart)
        {
            RexBibanu.update();
            for (Entitati entitati : NPC) {
                if (entitati != null)
                    entitati.update();
            }
            for (Entitati entitati : Monstrii) {
                if (entitati != null)
                    entitati.update();
            }
        }
        if(StatusJoc == StatusPauza)
        {
            // bruh nimic
        }
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D grafici = (Graphics2D)graphics;

        if(StatusJoc == StatusTitle)
        {
            iu.draw(grafici);
        }
        else
        {
            tileA.draw(grafici);
            for (SuperObiect superObiect : obiect)
            {
                if (superObiect != null)
                {
                    superObiect.draw(grafici, this);
                }
            }


            RexBibanu.draw(grafici); // Desenare rex bibu
            //System.out.println("coords: " + RexBibanu.worldX + " " + RexBibanu.worldY);

            // NPC
            for (Entitati entitati : NPC) {
                if (entitati != null) {
                    entitati.draw(grafici);
                }
            }

            // Monstrii
            for (Entitati entitati : Monstrii) {
                if (entitati != null) {
                    entitati.draw(grafici);
                }
            }

            iu.draw(grafici);
        }

        grafici.dispose();
    }


    //Implementare audio i guess?
    public void playMusic(int i)//loop pt ca e muzica de background
    {
        music.setFile(i);

        music.play();
        music.loop();
    }

    public void playSE(int i) //Sound Effects, nu background music
    {
        sound.setFile(i);

        sound.play();
    }
    public void stopMusic()
    {
        music.stop();
    }
    // bruh actually merge

}