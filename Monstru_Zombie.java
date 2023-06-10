import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Monstru_Zombie extends Entitati
{
    public Monstru_Zombie(GameInterface gi)
    {
        super(gi);
        // nume = "Slime";
        typeEntitate = 2;
        rexSpeed = 2;
        maxHP = 24;
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
            Sus1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieSus1.png")));
            Sus2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieSus2.png")));
            Sus3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieSus3.png")));

            Dreapta1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieDreapta1.png")));
            Dreapta2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieDreapta2.png")));
            Dreapta3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieDreapta3.png")));

            Jos1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieJos1.png")));
            Jos2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieJos2.png")));
            Jos3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieJos3.png")));

            Stanga1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieStanga1.png")));
            Stanga2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieStanga2.png")));
            Stanga3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Monstrii/ZombieStanga3.png")));

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
