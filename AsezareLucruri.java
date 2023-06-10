public class AsezareLucruri
{
    GameInterface gi;

    public AsezareLucruri(GameInterface gi)
    {
        this.gi = gi;
    }

    public void SetObiect()
    {
        gi.obiect[0] = new Obiect_Cruce(); // baza cruce 1
        gi.obiect[0].WorldX = 15 * gi.tileSize;
        gi.obiect[0].WorldY = 3 * gi.tileSize;

        gi.obiect[1] = new Obiect_Cruce2(); // top cruce 1
        gi.obiect[1].WorldX = 15 * gi.tileSize;
        gi.obiect[1].WorldY = 2 * gi.tileSize;

        gi.obiect[2] = new Obiect_Cruce3(); // baza cruce 2
        gi.obiect[2].WorldX = 16 * gi.tileSize;
        gi.obiect[2].WorldY = 3 * gi.tileSize;

        gi.obiect[3] = new Obiect_Cruce4(); // top cruce 2
        gi.obiect[3].WorldX = 16 * gi.tileSize;
        gi.obiect[3].WorldY = 2 * gi.tileSize;

        gi.obiect[4] = new Obiect_Cutie1(); // cutie 1
        gi.obiect[4].WorldX = 8 * gi.tileSize;
        gi.obiect[4].WorldY = 8 * gi.tileSize;

        gi.obiect[5] = new Obiect_Cutie2(); // cutie 2
        gi.obiect[5].WorldX = 9 * gi.tileSize;
        gi.obiect[5].WorldY = 8 * gi.tileSize;

        gi.obiect[6] = new Obiect_Sabie();
        gi.obiect[6].WorldX = 8 * gi.tileSize;
        gi.obiect[6].WorldY = 10 * gi.tileSize;

        gi.obiect[7] = new Obiect_PortalLvl1();
        gi.obiect[7].WorldX = 43 * gi.tileSize;
        gi.obiect[7].WorldY = 4 * gi.tileSize;

        gi.obiect[8] = new Obiect_PortalLvl1();
        gi.obiect[8].WorldX = 43 * gi.tileSize;
        gi.obiect[8].WorldY = 5 * gi.tileSize;
    }
    public void SetEntitati()
    {
        gi.NPC[0] = new NPC_Joker(gi);
        gi.NPC[0].worldX = gi.tileSize * 15;
        gi.NPC[0].worldY = gi.tileSize * 8;
    }
    public void SetMonstrii()
    {
        gi.Monstrii[0] = new Monstru_Slime(gi);
        gi.Monstrii[0].worldX = gi.tileSize * 15;
        gi.Monstrii[0].worldY = gi.tileSize * 10;

        gi.Monstrii[1] = new Monstru_Slime(gi);
        gi.Monstrii[1].worldX = gi.tileSize * 25;
        gi.Monstrii[1].worldY = gi.tileSize * 35;

        gi.Monstrii[2] = new Monstru_Slime(gi);
        gi.Monstrii[2].worldX = gi.tileSize * 24;
        gi.Monstrii[2].worldY = gi.tileSize * 25;

        gi.Monstrii[3] = new Monstru_Slime(gi);
        gi.Monstrii[3].worldX = gi.tileSize * 38;
        gi.Monstrii[3].worldY = gi.tileSize * 14;

        gi.Monstrii[4] = new Monstru_Zombie(gi);
        gi.Monstrii[4].worldX = gi.tileSize * 36;
        gi.Monstrii[4].worldY = gi.tileSize * 26;


    }

}
