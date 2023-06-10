import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class NPC_Joker extends Entitati
{
    public NPC_Joker(GameInterface gi)
    {
        super(gi);
        Directie = "Jos";
        rexSpeed = 1;
        GetImagine();
    }
    public void GetImagine()
    {
            try{
                Sus1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCSus1.png")));
                Sus2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCSus2.png")));
                Sus3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCSus3.png")));

                Jos1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCJos1.png")));
                Jos2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCJos2.png")));
                Jos3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCJos3.png")));

                Stanga1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCStanga1.png")));
                Stanga2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCStanga2.png")));
                Stanga3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCStanga3.png")));

                Dreapta1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCDreapta1.png")));
                Dreapta2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCDreapta2.png")));
                Dreapta3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/NPC/NPCDreapta3.png")));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
    }

    @Override
    public void setActiune()
    {
        Random random = new Random();
        int i = random.nextInt(100) + 1;
        ++LockActiuneCurenta;
        if(LockActiuneCurenta == 120)
        {
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

