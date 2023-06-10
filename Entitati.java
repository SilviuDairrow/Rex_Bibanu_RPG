import java.awt.*;
import java.awt.image.BufferedImage;

public class Entitati
{
        GameInterface gi;
        public int worldX, worldY;
        public int rexSpeed;

        public BufferedImage Sus1, Sus2, Sus3, Sus4, Sus5, Sus6, Sus7, Sus8;
        public BufferedImage Jos1, Jos2, Jos3, Jos4, Jos5, Jos6, Jos7, Jos8;
        public BufferedImage Stanga1, Stanga2, Stanga3, Stanga4, Stanga5, Stanga6, Stanga7, Stanga8;
        public BufferedImage Dreapta1, Dreapta2, Dreapta3, Dreapta4, Dreapta5, Dreapta6, Dreapta7, Dreapta8;


        public BufferedImage attackSus1, attackSus2, attackSus3, attackSus4, attackSus5, attackSus6;
        public BufferedImage attackJos1, attackJos2, attackJos3, attackJos4, attackJos5, attackJos6;
        public BufferedImage attackStanga1, attackStanga2, attackStanga3, attackStanga4, attackStanga5, attackStanga6;
        public BufferedImage attackDreapta1, attackDreapta2, attackDreapta3, attackDreapta4, attackDreapta5, attackDreapta6;


        public String Directie;
        public int spriteCnt = 0;
        public int spriteNum = 1;

        public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
        public Rectangle attackArea = new Rectangle(0,0,0,0);
        public int solidAreaDefaultX, solidAreaDefaultY;

        // Status caractere
        public int maxHP;
        public int HP;

        public boolean coliziuniOn = false;
        public int LockActiuneCurenta = 0;
        public boolean invincible = false;
        public int invincibleCounter = 0;
        boolean Attacking = false;

        public int typeEntitate; // 0 - rex bibanu 1 - NPC, 2 - Monstru


        public Entitati(GameInterface gi)
        {
                this.gi = gi;
        }

        public void draw(Graphics2D grafici)
        {
        BufferedImage imagine = null;
        int ScreenX = worldX - gi.RexBibanu.worldX + gi.RexBibanu.screenX;
        int ScreenY = worldY - gi.RexBibanu.worldY + gi.RexBibanu.screenY;
        if (worldX + gi.tileSize > gi.RexBibanu.worldX - gi.RexBibanu.screenX && //ca sa randez pe ecran doar ce e in jurul lui rex
                worldX - gi.tileSize < gi.RexBibanu.worldX + gi.RexBibanu.screenX &&
                worldY + gi.tileSize > gi.RexBibanu.worldY - gi.RexBibanu.screenY &&
                worldY - gi.tileSize < gi.RexBibanu.worldY + gi.RexBibanu.screenY) {
                switch (Directie) {
                        case "Sus" -> {
                                switch (spriteNum) {
                                        case 1 -> imagine = Sus1;
                                        case 2 -> imagine = Sus2;
                                        case 3 -> imagine = Sus3;
                                }
                        }
                        case "Jos" -> {
                                switch (spriteNum) {
                                        case 1 -> imagine = Jos1;
                                        case 2 -> imagine = Jos2;
                                        case 3 -> imagine = Jos3;
                                }
                        }
                        case "Stanga" -> {
                                switch (spriteNum) {
                                        case 1 -> imagine = Stanga1;
                                        case 2 -> imagine = Stanga2;
                                        case 3 -> imagine = Stanga3;
                                }
                        }
                        case "Dreapta" -> {
                                switch (spriteNum) {
                                        case 1 -> imagine = Dreapta1;
                                        case 2 -> imagine = Dreapta2;
                                        case 3 -> imagine = Dreapta3;
                                }
                        }
                }
                if(invincible)
                {
                        grafici.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
                }

                grafici.drawImage(imagine, ScreenX, ScreenY, gi.tileSize, gi.tileSize, null);
                grafici.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        }
        }
        public void setActiune()
        {

        }
        public void update()
        {
                setActiune();

                coliziuniOn = false;
                gi.Coliziune.CheckTile(this);
                gi.Coliziune.checkObiect(this, false);
                boolean contactJucator = gi.Coliziune.checkJucator(this);

                //gi.Coliziune.checkEntitate(this, gi.NPC); // freeze daca e npc XD
                //gi.Coliziune.checkEntitate(this, gi.Monstrii); // same here

                if(this.typeEntitate == 2 && contactJucator)
                {
                        if(!gi.RexBibanu.invincible)
                        {
                                gi.RexBibanu.HP--;
                                gi.RexBibanu.invincible = true;
                        }
                }

                if(!coliziuniOn)
                {
                        switch (Directie) {
                                case "Sus" -> worldY -= rexSpeed;
                                case "Dreapta" -> worldX += rexSpeed;
                                case "Jos" -> worldY += rexSpeed;
                                case "Stanga" -> worldX -= rexSpeed;
                        }
                }
                spriteCnt++;
                if (spriteCnt > 8) {
                        if (spriteNum == 1) {
                                spriteNum = 2;
                        } else if (spriteNum == 2) {
                                spriteNum = 3;
                        } else if (spriteNum == 3) {
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
        }
}
