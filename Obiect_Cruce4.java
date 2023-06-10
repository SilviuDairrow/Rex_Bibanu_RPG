import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Obiect_Cruce4 extends SuperObiect
{
    public Obiect_Cruce4()
    {
        nume = "Cruce4";
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/Cruce22.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}