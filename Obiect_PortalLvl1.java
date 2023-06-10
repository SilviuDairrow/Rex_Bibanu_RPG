import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Obiect_PortalLvl1 extends SuperObiect
{
    public Obiect_PortalLvl1()
    {
        nume = "PortalLvl1";
        ColiziuniOn = true;
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/Void.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
