import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Obiect_Cutie1 extends SuperObiect
{
    public Obiect_Cutie1()
    {
        nume = "Cutie1";
        ColiziuniOn = true;
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/Cutie1.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}