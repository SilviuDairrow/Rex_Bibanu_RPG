import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.*;
import static java.awt.Font.BOLD;

public class InterfataUser
{
    GameInterface gi;
    Graphics graphics;
    Font SabieOn_23;
    Font PauzaOn_69;
    public int NumarComanda = 0;
    BufferedImage InimaFull1, InimaFull2, InimaFull3, InimaJumate1, InimaJumate2, InimaJumate3, InimaGoala1, InimaGoala2, InimaGoala3;

    public InterfataUser(GameInterface gi)
    {
        this.gi = gi;

        SabieOn_23 = new Font("Rex Bibanu", Font.ITALIC, 23);
        PauzaOn_69 = new Font("PAUZA", BOLD, 69);

        // HUD REX BIBANU
        SuperObiect Inima = new Obiect_Heart(gi);
        InimaFull1 = Inima.imagine;
        InimaJumate1 = Inima.imagine2;
        InimaGoala1 = Inima.imagine3;

        InimaFull2 = Inima.imagine4;
        InimaJumate2 = Inima.imagine5;
        InimaGoala2 = Inima.imagine6;

        InimaFull3 = Inima.imagine7;
        InimaJumate3 = Inima.imagine8;
        InimaGoala3 = Inima.imagine9;

    }

    public void draw(Graphics2D graphics)
    {

        this.graphics = graphics;
        if(gi.StatusJoc == gi.StatusTitle)
        {
            drawTitleScreen();
        }

        if(gi.StatusJoc == gi.StatusStart)
        {
            drawRexLife();
            graphics.setFont(SabieOn_23);
            graphics.setColor(white);
            graphics.drawString("Sword: ",50, 750);
            graphics.setColor(new Color(0,230,0));
            graphics.drawString(gi.RexBibanu.SabieNume,123,750);
        }
        if(gi.StatusJoc == gi.StatusPauza)
        {
            drawRexLife();
            graphics.setColor(white);
            graphics.setFont(PauzaOn_69);
            drawPauza();
        }
        if(gi.StatusJoc == gi.StatusGameOver)
        {
            drawGameOverScreen();
        }
    }
    public void drawPauza()
    {
        String text = "PAUSED";//min 14 ep 13
//        int lungime = (int) gi.getFontMetrics().getStringBounds(text, gi).getWidth();
//        int x = gi.Lungime/2 - lungime;
//        int y = gi.Latime/2;
        graphics.drawString(text, 380, 300);
    }

    public void drawTitleScreen()
    {
        graphics.setColor(BLACK);
        graphics.fillRect(0,0,gi.Latime, gi.Lungime); // fundal

        String titlu = "REX BIBANU";
        graphics.setFont(graphics.getFont().deriveFont(BOLD,92F));
        graphics.setColor(GRAY);
        int x = 230;
        int y = gi.tileSize * 3;
        graphics.drawString(titlu, x, y); // titlu

        graphics.setColor(white);
        graphics.drawString(titlu, x+5,y+5); // umbra

        String SILVIUBIBANU = "Joc realizat de:";
        graphics.setFont(graphics.getFont().deriveFont(Font.ITALIC,23F));
        graphics.setColor(white);
        x = 569;
        y = gi.tileSize * 4;
        graphics.drawString(SILVIUBIBANU, x, y);

        x = 726;
        y += 1;
        int i = 0;
        Color[] v = new Color[12];
        v[0] = new Color(255,0,0);
        v[1] = new Color(255,127,0);
        v[2] = new Color(255,255,0);
        v[3] = new Color(127,255,0);
        v[4] = new Color(0,255,0);
        v[5] = new Color(0,255,127);
        v[6] = new Color(0,255,255);
        v[7] = new Color(0,127,255);
        v[8] = new Color(0,0,255);
        v[9] = new Color(127,0,255);
        v[10] = new Color(255,0,255);
        v[11] = new Color(255,0,127);

        graphics.setColor(v[i % 12]);
        graphics.drawString("S", x, y);

        graphics.setColor(v[(i + 1) % 12]);
        graphics.drawString("i", x + 14, y);

        graphics.setColor(v[(i + 2) % 12]);
        graphics.drawString("l", x + 20, y);

        graphics.setColor(v[(i + 3) % 12]);
        graphics.drawString("v", x + 26, y);

        graphics.setColor(v[(i + 4) % 12]);
        graphics.drawString("i", x + 38, y);

        graphics.setColor(v[(i + 5) % 12]);
        graphics.drawString("u", x + 43, y);


        graphics.setColor(v[(i + 6) % 12]);
        graphics.drawString("S", x + 58, y);

        graphics.setColor(v[(i + 7) % 12]);
        graphics.drawString("e", x + 72, y);

        graphics.setColor(v[(i + 8) % 12]);
        graphics.drawString("c", x + 86, y);

        graphics.setColor(v[(i + 9) % 12]);
        graphics.drawString("a", x + 98, y);

        graphics.setColor(v[(i + 10) % 12]);
        graphics.drawString("n", x + 110, y);

        graphics.setColor(v[(i + 11) % 12]);
        graphics.drawString("!", x + 122, y);

        graphics.setColor(WHITE);
        graphics.setFont(graphics.getFont().deriveFont(BOLD,46F));
        titlu = "NEW GAME";
        x = 350;
        y = gi.tileSize * 7;
        graphics.drawString(titlu, x, y);
        if(NumarComanda == 0)
        {
            graphics.drawString(">", x - 35, y);
        }

        titlu = "LOAD GAME";
        x = 340;
        y += gi.tileSize;
        graphics.drawString(titlu, x, y);
        if(NumarComanda == 1)
        {
            graphics.drawString(">", x - 35, y);
        }

        titlu = "QUIT";
        x = 423;
        y += gi.tileSize;
        graphics.drawString(titlu, x, y);
        if(NumarComanda == 2)
        {
            graphics.drawString(">", x - 35, y);
        }
    }
    public void drawRexLife()
    {
        int x = gi.tileSize/2;
        int y = gi.tileSize/2;

        switch (gi.RexBibanu.HP)
        {
            default -> {
                graphics.drawImage(InimaGoala1, x, y, null);
                graphics.drawImage(InimaGoala2, x + 32, y, null);
                graphics.drawImage(InimaGoala3, x + 64, y, null);
            }
            case 1 -> {
                graphics.drawImage(InimaJumate1, x, y, null);
                graphics.drawImage(InimaGoala2, x + 32, y, null);
                graphics.drawImage(InimaGoala3, x + 64, y, null);
            }
            case 2 -> {
                graphics.drawImage(InimaFull1, x, y, null);
                graphics.drawImage(InimaGoala2, x + 32, y, null);
                graphics.drawImage(InimaGoala3, x + 64, y, null);
            }
            case 3 -> {
                graphics.drawImage(InimaFull1, x, y, null);
                graphics.drawImage(InimaJumate2, x + 32, y, null);
                graphics.drawImage(InimaGoala3, x + 64, y, null);
            }
            case 4 -> {
                graphics.drawImage(InimaFull1, x, y, null);
                graphics.drawImage(InimaFull2, x + 32, y, null);
                graphics.drawImage(InimaGoala3, x + 64, y, null);
            }
            case 5 -> {
                graphics.drawImage(InimaFull1, x, y, null);
                graphics.drawImage(InimaFull2, x + 32, y, null);
                graphics.drawImage(InimaJumate3, x + 64, y, null);
            }
            case 6 -> {
                graphics.drawImage(InimaFull1, x, y, null);
                graphics.drawImage(InimaFull2, x + 32, y, null);
                graphics.drawImage(InimaFull3, x + 64, y, null);
            }
        }
    }
    public void drawGameOverScreen()
    {
        graphics.setColor(new Color(0,0,0,130));
        graphics.fillRect(0,0, gi.maxScreenRanduri,gi.maxScreenColoane);

        int x;
        int y;
        String titlu;
        graphics.setFont(gi.getFont().deriveFont(BOLD,110f));
        titlu = "Game Over";

        graphics.setColor(BLACK);
        x = 230;
        y = gi.tileSize * 4;
        graphics.drawString(titlu, x, y);

        graphics.setColor(WHITE);
        graphics.drawString(titlu, x - 4, y - 4);


        graphics.setFont(gi.getFont().deriveFont(50F));
        titlu = "Retry";
        x = 450;
        y = gi.tileSize * 7;
        graphics.drawString(titlu, x, y);

        if(NumarComanda == 0)
        {
            graphics.drawString(">", x - 30, y);
        }

        titlu = "Quit";
        x = 460;
        y = gi.tileSize * 8;
        graphics.drawString(titlu, x, y);

        if(NumarComanda == 1)
        {
            graphics.drawString(">", x - 30, y);
        }

    }
}
