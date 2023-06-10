import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class rexbibanu extends Entitati
{
    Controale RexKey;

    public final int screenX;
    public final int screenY;
    boolean Sabie = false;
    String SabieNume = " ";
    public int AttackDamage;
    public int KillCount = 0;
    public int SaveCondition = 0;

    public rexbibanu(GameInterface gi, Controale RexKey)
    {
        super(gi); // call la consturctor clasa entitati (pt gameinterface)
        this.RexKey = RexKey;

        screenX = gi.Latime / 2 - (gi.tileSize / 2);
        screenY = gi.Lungime / 2 - (gi.tileSize / 2);

        solidArea = new Rectangle(8,16,30,30);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        // in functie de arma trb modificat
        attackArea.width = 36;
        attackArea.height = 36;

        setDefault();
        GetImagine();
        GetRexAttackImagine();
    }

    public void setDefaultPositions()
    {
        worldX = 384; // gi.tileSize * 2;
        worldY = 512; // gi.tileSize * 3;
        Directie = "Jos";
    }
    public void restoreHP()
    {
        HP = maxHP;
        invincible = false;
    }
    public void setDefault()
    {
        worldX = 384; // gi.tileSize * 2;
        worldY = 512; // gi.tileSize * 3;
        rexSpeed = 4;
        AttackDamage = 10;
        Directie = "Jos";

        maxHP = 6;
        HP = maxHP;
    }

    public void GetImagine()
    {
        try{
//            Sus1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res\\RexBibanu\\Rex_Sus1.png")));
            Sus1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus1.png")));
            Sus2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus2.png")));
            Sus3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus3.png")));
            Sus4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus4.png")));
            Sus5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus5.png")));
            Sus6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus6.png")));
            Sus7 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus7.png")));
            Sus8 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Sus8.png")));


            Jos1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos1.png")));
            Jos2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos2.png")));
            Jos3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos3.png")));
            Jos4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos4.png")));
            Jos5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos5.png")));
            Jos6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos6.png")));
            Jos7 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos7.png")));
            Jos8 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Jos8.png")));


            Stanga1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga1.png")));
            Stanga2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga2.png")));
            Stanga3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga3.png")));
            Stanga4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga4.png")));
            Stanga5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga5.png")));
            Stanga6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga6.png")));
            Stanga7 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga7.png")));
            Stanga8 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Stanga8.png")));


            Dreapta1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta1.png")));
            Dreapta2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta2.png")));
            Dreapta3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta3.png")));
            Dreapta4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta4.png")));
            Dreapta5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta5.png")));
            Dreapta6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta6.png")));
            Dreapta7 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta7.png")));
            Dreapta8 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta8.png")));
            // Dreapta3 = ImageIO.read(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta3.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void GetRexAttackImagine()
    {
        try{
//            Sus1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res\\RexBibanu\\Rex_Sus1.png")));
            attackSus1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexSusAttack1.png")));
            attackSus2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexSusAttack2.png")));
            attackSus3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexSusAttack3.png")));
            attackSus4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexSusAttack4.png")));
            attackSus5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexSusAttack5.png")));
            attackSus6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexSusAttack6.png")));


            attackJos1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexJosAttack1.png")));
            attackJos2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexJosAttack2.png")));
            attackJos3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexJosAttack3.png")));
            attackJos4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexJosAttack4.png")));
            attackJos5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexJosAttack5.png")));
            attackJos6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexJosAttack6.png")));


            attackStanga1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexStangaAttack1.png")));
            attackStanga2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexStangaAttack2.png")));
            attackStanga3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexStangaAttack3.png")));
            attackStanga4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexStangaAttack4.png")));
            attackStanga5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexStangaAttack5.png")));
            attackStanga6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexStangaAttack6.png")));


            attackDreapta1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexDreaptaAttack1.png")));
            attackDreapta2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexDreaptaAttack2.png")));
            attackDreapta3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexDreaptaAttack3.png")));
            attackDreapta4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexDreaptaAttack4.png")));
            attackDreapta5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexDreaptaAttack5.png")));
            attackDreapta6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/RexBibanuSword/RexDreaptaAttack6.png")));
            // Dreapta3 = ImageIO.read(getClass().getResourceAsStream("/res/RexBibanu/Rex_Dreapta3.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void update() {

        if(Attacking)
        {
               attacking();
        }
        else if (RexKey.Sus || RexKey.Jos || RexKey.Dreapta || RexKey.Stanga)
        {
            // Verificare coliziune cu dalele
            coliziuniOn = false;
            gi.Coliziune.CheckTile(this);

            // Verificare coliziune cu obiectele
            int obiectID = gi.Coliziune.checkObiect(this, true);
            PickUpObiect(obiectID);

            // Verificare coliziuni cu Entitati
            int NPCId = gi.Coliziune.checkEntitate(this, gi.NPC);
            InteractiuneNPC(NPCId);

            // Verificare coliziuni cu Monstrii
            int monstruId = gi.Coliziune.checkEntitate(this,gi.Monstrii);
            ContactMonstru(monstruId);

            if(RexKey.Sus)
            {
                Directie = "Sus";
                if(!coliziuniOn)
                    worldY -= rexSpeed;
            }
            if(RexKey.Jos)
            {
                Directie = "Jos";
                if(!coliziuniOn)
                    worldY += rexSpeed;
            }
            if(RexKey.Dreapta)
            {
                Directie = "Dreapta";
                if(!coliziuniOn)
                    worldX += rexSpeed;
            }
            if(RexKey.Stanga)
            {
                Directie = "Stanga";
                if(!coliziuniOn)
                    worldX -= rexSpeed;
            }
        }

            spriteCnt++;
            if (spriteCnt > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 5;
                } else if (spriteNum == 5) {
                    spriteNum = 6;
                } else if (spriteNum == 6) {
                    spriteNum = 7;
                } else if (spriteNum == 7) {
                    spriteNum = 8;
                } else if (spriteNum == 8) {
                    spriteNum = 1;
                }
                spriteCnt = 0;
            }

            if(invincible)
            {
                ++invincibleCounter;
                if(invincibleCounter > 60)
                {
                    invincible = false;
                    invincibleCounter = 0;
                }
            }
        if(HP <= 0)
        {
            gi.StatusJoc = gi.StatusGameOver;
        }
    }

    public void attacking()
    {
        ++spriteCnt;

        if(spriteCnt <= 5)
        {
            spriteNum = 1;
        }
        if(spriteCnt > 5 && spriteCnt <= 25)
        {
            spriteNum = 2;
            // ca sa salvez worldX, worldY si solidArea in mom de fata
            int WorldXCurent = worldX;
            int WorldYCurent = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            switch (Directie) {
                case "Sus" -> worldY -= attackArea.height;
                case "Jos" -> worldY += attackArea.height;
                case "Dreapta" -> worldX += attackArea.width;
                case "Stanga" -> worldX -= attackArea.width;
            }
            // AttackArea devine solid area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // Verificare coliziune cu un monstru si stocare id
            int MonstruId = gi.Coliziune.checkEntitate(this,gi.Monstrii);
            damageMonster(MonstruId);

            // return la pozitia initiala
            worldX = WorldXCurent;
            worldY = WorldYCurent;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(spriteCnt > 25 && spriteCnt <= 45)
        {
            spriteNum = 3;
            // ca sa salvez worldX, worldY si solidArea in mom de fata
            int WorldXCurent = worldX;
            int WorldYCurent = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            switch (Directie) {
                case "Sus" -> worldY -= attackArea.height;
                case "Jos" -> worldY += attackArea.height;
                case "Dreapta" -> worldX += attackArea.width;
                case "Stanga" -> worldX -= attackArea.width;
            }
            // AttackArea devine solid area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // Verificare coliziune cu un monstru si stocare id
            int MonstruId = gi.Coliziune.checkEntitate(this,gi.Monstrii);
            damageMonster(MonstruId);

            // return la pozitia initiala
            worldX = WorldXCurent;
            worldY = WorldYCurent;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }

        if(spriteCnt > 45 && spriteCnt <= 65)
        {
            spriteNum = 4;
            // ca sa salvez worldX, worldY si solidArea in mom de fata
            int WorldXCurent = worldX;
            int WorldYCurent = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            switch(Directie)
            {
                case "Sus":
                {
                    worldY -= attackArea.height;
                    break;
                }
                case "Jos":
                {
                    worldY += attackArea.height;
                    break;
                }
                case "Dreapta":
                {
                    worldX += attackArea.width;
                }
                case "Stanga":
                {
                    worldX -= attackArea.width;
                }
            }
            // AttackArea devine solid area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // Verificare coliziune cu un monstru si stocare id
            int MonstruId = gi.Coliziune.checkEntitate(this,gi.Monstrii);
            damageMonster(MonstruId);

            // return la pozitia initiala
            worldX = WorldXCurent;
            worldY = WorldYCurent;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }

        if(spriteCnt > 65 && spriteCnt <= 85)
        {
            spriteNum = 6;
            // ca sa salvez worldX, worldY si solidArea in mom de fata
            int WorldXCurent = worldX;
            int WorldYCurent = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            switch(Directie)
            {
                case "Sus":
                {
                    worldY -= attackArea.height;
                    break;
                }
                case "Jos":
                {
                    worldY += attackArea.height;
                    break;
                }
                case "Dreapta":
                {
                    worldX += attackArea.width;
                }
                case "Stanga":
                {
                    worldX -= attackArea.width;
                }
            }

            // AttackArea devine solid area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // Verificare coliziune cu un monstru si stocare id
            int MonstruId = gi.Coliziune.checkEntitate(this,gi.Monstrii);
            damageMonster(MonstruId);

            // return la pozitia initiala
            worldX = WorldXCurent;
            worldY = WorldYCurent;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }

        if(spriteCnt > 85 && spriteCnt <= 105)
        {
            spriteNum = 1;
            spriteCnt = 0;
            Attacking = false;
        }
    }

    public void PickUpObiect(int i)
    {
        if(i != 2323)
        {
            String NumeObiect = gi.obiect[i].nume;
            switch(NumeObiect)
            {
                case "Sword" ->
                {
                    gi.obiect[i] = null;
                    System.out.println("Sabie biban!\nSabie biban!\nSabie biban!\n");
                    Sabie = true;
                    SabieNume = "Sabie Biban";
                    gi.playSE(0);
                }
                case "PortalLvl1" ->
                {
                    gi.obiect[i] = null;
                }
            }

        }
    }

    public void InteractiuneNPC(int i)
    {
        if(i != 2323)
        {
            // System.out.println("hit npc!");
            SaveCondition = 1;
        }
    }

    public void ContactMonstru(int i)
    {
        if(i != 2323)
        {
            // HP -= 1;
            // System.out.println(HP);
            if(!invincible)
            {
                HP -= 1;
                invincible = true;
            }
        }
    }
    public void damageMonster(int i)
    {
        if(i != 2323)
        {
            if(!gi.Monstrii[i].invincible)
            {
                gi.Monstrii[i].HP -= AttackDamage;
                gi.Monstrii[i].invincible = true;
                if(gi.Monstrii[i].HP <= 0)
                {
                    gi.Monstrii[i] = null;
                    ++KillCount;
                }
            }
        }
    }

    @Override
    public void draw(Graphics2D grafici)
    {
        BufferedImage imagine = null;
//        int tempScreenX = screenX; // pt animatii 16x32
//        int tempScreenY = screenY;

            switch (Directie)
            {
                case "Sus" -> {
                    if(!Attacking)
                    {
                        switch (spriteNum) {
                            case 1 -> imagine = Sus1;
                            case 2 -> imagine = Sus2;
                            case 3 -> imagine = Sus3;
                            case 4 -> imagine = Sus4;
                            case 5 -> imagine = Sus5;
                            case 6 -> imagine = Sus6;
                            case 7 -> imagine = Sus7;
                            case 8 -> imagine = Sus8;
                        }
                    }
                    if(Attacking)
                    {
                        //tempScreenY = screenY - gi.tileSize;
                        switch (spriteNum) {
                            case 1 -> imagine = attackSus1;
                            case 2 -> imagine = attackSus2;
                            case 3 -> imagine = attackSus3;
                            case 4 -> imagine = attackSus4;
                            case 5 -> imagine = attackSus5;
                            case 6 -> imagine = attackSus6;
                        }
                    }
                }

                case "Jos" -> {
                    if(!Attacking)
                    {
                        switch (spriteNum) {
                            case 1 -> imagine = Jos1;
                            case 2 -> imagine = Jos2;
                            case 3 -> imagine = Jos3;
                            case 4 -> imagine = Jos4;
                            case 5 -> imagine = Jos5;
                            case 6 -> imagine = Jos6;
                            case 7 -> imagine = Jos7;
                            case 8 -> imagine = Jos8;
                        }
                    }
                    if(Attacking)
                    {
                        switch (spriteNum) {
                            case 1 -> imagine = attackJos1;
                            case 2 -> imagine = attackJos2;
                            case 3 -> imagine = attackJos3;
                            case 4 -> imagine = attackJos4;
                            case 5 -> imagine = attackJos5;
                            case 6 -> imagine = attackJos6;
                        }
                    }
                }
                case "Stanga" -> {
                    if(!Attacking)
                    {
                        //tempScreenX = screenX - gi.tileSize;
                        switch (spriteNum) {
                            case 1 -> imagine = Stanga1;
                            case 2 -> imagine = Stanga2;
                            case 3 -> imagine = Stanga3;
                            case 4 -> imagine = Stanga4;
                            case 5 -> imagine = Stanga5;
                            case 6 -> imagine = Stanga6;
                            case 7 -> imagine = Stanga7;
                            case 8 -> imagine = Stanga8;
                        }
                    }
                    if(Attacking)
                    {
                        switch (spriteNum) {
                            case 1 -> imagine = attackStanga1;
                            case 2 -> imagine = attackStanga2;
                            case 3 -> imagine = attackStanga3;
                            case 4 -> imagine = attackStanga4;
                            case 5 -> imagine = attackStanga5;
                            case 6 -> imagine = attackStanga6;

                        }
                    }
                }
                case "Dreapta" -> {
                    if(!Attacking)
                    {
                        switch (spriteNum) {
                            case 1 -> imagine = Dreapta1;
                            case 2 -> imagine = Dreapta2;
                            case 3 -> imagine = Dreapta3;
                            case 4 -> imagine = Dreapta4;
                            case 5 -> imagine = Dreapta5;
                            case 6 -> imagine = Dreapta6;
                            case 7 -> imagine = Dreapta7;
                            case 8 -> imagine = Dreapta8;
                        }
                    }
                    if(Attacking)
                    {
                        switch (spriteNum) {
                            case 1 -> imagine = attackDreapta1;
                            case 2 -> imagine = attackDreapta2;
                            case 3 -> imagine = attackDreapta3;
                            case 4 -> imagine = attackDreapta4;
                            case 5 -> imagine = attackDreapta5;
                            case 6 -> imagine = attackDreapta6;

                        }
                    }
                }
            }

            if(invincible)
            {
                grafici.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            }
            grafici.drawImage(imagine, screenX, screenY, gi.tileSize, gi.tileSize, null);
            //grafici.drawImage(imagine, tempScreenX, tempScreenY, gi.tileSize, gi.tileSize, null);


            grafici.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));


//            grafici.setFont(new Font("Arial",Font.PLAIN, 26));
//            grafici.setColor(Color.white);
//            grafici.drawString("Invincible: " +invincibleCounter, 10, 400);
    }
}
