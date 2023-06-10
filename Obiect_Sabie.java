import javax.imageio.ImageIO;
import java.io.IOException;

public class Obiect_Sabie extends SuperObiect
{
    public Obiect_Sabie()
    {
        nume = "Sword";
        try
        {
            imagine = ImageIO.read(getClass().getResourceAsStream("/res/Obiecte/SabieBiban.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
