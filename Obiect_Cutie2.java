import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Obiect_Cutie2 extends SuperObiect
{
    public Obiect_Cutie2()
    {
        nume = "Cutie2";
        ColiziuniOn = true;
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/Cutie2.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}