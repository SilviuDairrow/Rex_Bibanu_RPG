 import javax.imageio.ImageIO;
 import java.awt.*;
 import java.awt.image.BufferedImage;
 import java.io.IOException;
 import java.util.Objects;
 import java.util.Random;

public class Monstru_Slime extends Entitati
{
    public Monstru_Slime(GameInterface gi)
    {
        super(gi);
       // nume = "Slime";
        typeEntitate = 2;
        rexSpeed = 1;
        maxHP = 15;
        HP = maxHP;
        Directie = "Jos";

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImagine();
    }
    public void getImagine()
    {
        try {
            Sus1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));
            Sus2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos2.png")));
            Sus3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));

            Dreapta1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));
            Dreapta2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos2.png")));
            Dreapta3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));

            Jos1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));
            Jos2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos2.png")));
            Jos3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));

            Stanga1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));
            Stanga2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos2.png")));
            Stanga3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/Slime_Jos1.png")));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setActiune()
    {
        ++LockActiuneCurenta;

        if(LockActiuneCurenta == 120)
        {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25)
            {
                Directie = "Sus";
            }
            if(i <= 50 && i > 25)
            {
                Directie = "Dreapta";
            }
            if(i <= 75 && i > 50)
            {
                Directie = "Jos";
            }
            if(i <= 100 && i > 75)
            {
                Directie = "Stanga";
            }
            LockActiuneCurenta = 0;
        }
    }

}
