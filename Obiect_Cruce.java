import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Obiect_Cruce extends SuperObiect
{
    public Obiect_Cruce()
    {
        nume = "Cruce1";
        ColiziuniOn = true;
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/Cruce11.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
