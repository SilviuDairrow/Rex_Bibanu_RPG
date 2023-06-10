import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Obiect_Cruce3 extends SuperObiect
{
    public Obiect_Cruce3()
    {
        nume = "Cruce3";
        ColiziuniOn = true;
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/Cruce21.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}