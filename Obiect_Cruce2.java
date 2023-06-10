import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Obiect_Cruce2 extends SuperObiect
{
    public Obiect_Cruce2()
    {
        nume = "Cruce2";
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/Cruce12.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}