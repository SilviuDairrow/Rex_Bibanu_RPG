import javax.imageio.ImageIO;
import java.io.IOException;

public class Obiect_Heart extends SuperObiect
{
    GameInterface gi;
    public Obiect_Heart(GameInterface gi)
    {
        this.gi = gi;
        nume = "Heart";
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaFull1.png"));
            imagine2 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaJumate1.png"));
            imagine3 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaGoala1.png"));

            imagine4 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaFull2.png"));
            imagine5 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaJumate2.png"));
            imagine6 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaGoala2.png"));

            imagine7 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaFull3.png"));
            imagine8 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaJumate3.png"));
            imagine9 = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/InimaGoala3.png"));

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
