import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObiect
{
    public BufferedImage imagine, imagine2, imagine3, imagine4, imagine5, imagine6, imagine7, imagine8, imagine9;
    public String nume;
    public boolean ColiziuniOn = false;
    public int WorldX, WorldY;

    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D grafici, GameInterface gi)
    {
        int ScreenX = WorldX - gi.RexBibanu.worldX + gi.RexBibanu.screenX;
        int ScreenY = WorldY - gi.RexBibanu.worldY + gi.RexBibanu.screenY;

        if(WorldX + gi.tileSize > gi.RexBibanu.worldX - gi.RexBibanu.screenX && //ca sa randez pe ecran doar ce e in jurul lui rex
                WorldX - gi.tileSize < gi.RexBibanu.worldX + gi.RexBibanu.screenX &&
                WorldY + gi.tileSize > gi.RexBibanu.worldY - gi.RexBibanu.screenY &&
                WorldY - gi.tileSize < gi.RexBibanu.worldY + gi.RexBibanu.screenY)
        {
            grafici.drawImage(imagine, ScreenX, ScreenY, gi.tileSize, gi.tileSize, null);
        }
    }

}
