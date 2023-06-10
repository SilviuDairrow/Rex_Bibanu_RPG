public class ColiziuniCheck
{
    GameInterface gi;
    public ColiziuniCheck(GameInterface gi)
    {
        this.gi = gi;
    }
    public void CheckTile(Entitati entitati)
    {
        int EntitateStangaWorldX = entitati.worldX + entitati.solidArea.x;
        int EntitateDreaptaWorldX = entitati.worldX + entitati.solidArea.x + entitati.solidArea.width;
        int EntitateSusWorldY = entitati.worldY + entitati.solidArea.y;
        int EntitateJosWorldY = entitati.worldY + entitati.solidArea.y + entitati.solidArea.height;

        int EntitateStangaCol = EntitateStangaWorldX / gi.tileSize;
        int EntitateDreaptaCol = EntitateDreaptaWorldX / gi.tileSize;
        int EntitateSusRand = EntitateSusWorldY / gi.tileSize;
        int EntitateJosRand = EntitateJosWorldY / gi.tileSize;

        int tileNum1, tileNum2;

        switch (entitati.Directie) {
            case "Sus" -> {
                EntitateSusRand = (EntitateSusWorldY - entitati.rexSpeed) / gi.tileSize;

                tileNum1 = gi.tileA.MapaDale[EntitateStangaCol][EntitateSusRand];
                tileNum2 = gi.tileA.MapaDale[EntitateDreaptaCol][EntitateSusRand];

                if (gi.tileA.Dale[tileNum1].coliziune || gi.tileA.Dale[tileNum2].coliziune) { // Daca e true, coliziune true
                    entitati.coliziuniOn = true;
                }
            }
            case "Jos" -> {
                EntitateJosRand = (EntitateJosWorldY + entitati.rexSpeed) / gi.tileSize;

                tileNum1 = gi.tileA.MapaDale[EntitateStangaCol][EntitateJosRand];
                tileNum2 = gi.tileA.MapaDale[EntitateDreaptaCol][EntitateJosRand];

                if (gi.tileA.Dale[tileNum1].coliziune || gi.tileA.Dale[tileNum2].coliziune) {
                    entitati.coliziuniOn = true;
                }
            }
            case "Stanga" -> {
                EntitateStangaCol = (EntitateStangaWorldX - entitati.rexSpeed) / gi.tileSize;

                tileNum1 = gi.tileA.MapaDale[EntitateStangaCol][EntitateSusRand];
                tileNum2 = gi.tileA.MapaDale[EntitateStangaCol][EntitateJosRand];

                if (gi.tileA.Dale[tileNum1].coliziune || gi.tileA.Dale[tileNum2].coliziune) {
                    entitati.coliziuniOn = true;
                }
            }
            case "Dreapta" -> {
                EntitateDreaptaCol = (EntitateDreaptaWorldX + entitati.rexSpeed) / gi.tileSize;

                tileNum1 = gi.tileA.MapaDale[EntitateDreaptaCol][EntitateSusRand];
                tileNum2 = gi.tileA.MapaDale[EntitateDreaptaCol][EntitateJosRand];

                if (gi.tileA.Dale[tileNum1].coliziune || gi.tileA.Dale[tileNum2].coliziune) {
                    entitati.coliziuniOn = true;
                }
            }
        }
    }
    public int checkObiect(Entitati entitate, boolean rex)
    {
        int index = 2323;

        for(int i = 0; i < gi.obiect.length; ++i)
        {
            if(gi.obiect[i] != null)
            {
                // ca sa extrag pozitia ariei solide a entitatii
                entitate.solidArea.x += entitate.worldX;
                entitate.solidArea.y += entitate.worldY;

                // ca sa extrag pozitia ariei solide a obiectului
                gi.obiect[i].solidArea.x += gi.obiect[i].WorldX;
                gi.obiect[i].solidArea.y += gi.obiect[i].WorldY;

                switch(entitate.Directie)
                {
                    case "Sus" ->
                    {
                        entitate.solidArea.y -= entitate.rexSpeed;
                        if(entitate.solidArea.intersects(gi.obiect[i].solidArea))
                        {
                            if(gi.obiect[i].ColiziuniOn)
                                entitate.coliziuniOn = true;
                            if(rex)
                                index = i;
                        }
                    }
                    case "Jos" ->
                    {
                        entitate.solidArea.y += entitate.rexSpeed;
                        if(entitate.solidArea.intersects(gi.obiect[i].solidArea))
                        {
                            if(gi.obiect[i].ColiziuniOn)
                                entitate.coliziuniOn = true;
                            if(rex)
                                index = i;
                        }
                    }
                    case "Dreapta" ->
                    {
                        entitate.solidArea.x += entitate.rexSpeed;
                        if(entitate.solidArea.intersects(gi.obiect[i].solidArea))
                        {
                            if(gi.obiect[i].ColiziuniOn)
                                entitate.coliziuniOn = true;
                            if(rex)
                                index = i;
                        }
                    }
                    case "Stanga" ->
                    {
                        entitate.solidArea.x -= entitate.rexSpeed;
                        if(entitate.solidArea.intersects(gi.obiect[i].solidArea)) //intersects pt ca sunt mai
                            //putine obiecte decat tileuri in render distance mereu si e mai usor
                        {
                            if(gi.obiect[i].ColiziuniOn)
                                entitate.coliziuniOn = true;
                            if(rex)
                                index = i;
                        }
                    }
                }
                entitate.solidArea.x = entitate.solidAreaDefaultX;
                entitate.solidArea.y = entitate.solidAreaDefaultY;
                gi.obiect[i].solidArea.x = gi.obiect[i].solidAreaDefaultX;
                gi.obiect[i].solidArea.y = gi.obiect[i].solidAreaDefaultY;
            }
        }
        return index;
    }
    public int checkEntitate(Entitati entitate, Entitati[] target)
    {
        int index = 2323;
        for(int i = 0; i < target.length; ++i)
        {
            if(target[i] != null)
            {
                // ca sa extrag pozitia ariei solide a entitatii
                entitate.solidArea.x += entitate.worldX;
                entitate.solidArea.y += entitate.worldY;

                // ca sa extrag pozitia ariei solide a obiectului
                target[i].solidArea.x += target[i].worldX;
                target[i].solidArea.y += target[i].worldY;

                switch(entitate.Directie)
                {
                    case "Sus" ->
                    {
                        entitate.solidArea.y -= entitate.rexSpeed;
                        if(entitate.solidArea.intersects(target[i].solidArea))
                        //intersects pt ca sunt mai putine obiecte decat
                            // tileuri in render distance mereu si e mai usor
                        {
                            entitate.coliziuniOn = true;
                            index = i;
                        }
                    }
                    case "Jos" ->
                    {
                        entitate.solidArea.y += entitate.rexSpeed;
                        if(entitate.solidArea.intersects(target[i].solidArea))
                        {
                            entitate.coliziuniOn = true;
                            index = i;
                        }
                    }
                    case "Dreapta" ->
                    {
                        entitate.solidArea.x += entitate.rexSpeed;
                        if(entitate.solidArea.intersects(target[i].solidArea))
                        {
                            entitate.coliziuniOn = true;
                            index = i;
                        }
                    }
                    case "Stanga" ->
                    {
                        entitate.solidArea.x -= entitate.rexSpeed;
                        if(entitate.solidArea.intersects(target[i].solidArea))
                        {
                            entitate.coliziuniOn = true;
                            index = i;
                        }
                    }
                }
                entitate.solidArea.x = entitate.solidAreaDefaultX;
                entitate.solidArea.y = entitate.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        return index;
    }
    public boolean checkJucator(Entitati entitate)
    {
        boolean contactJucator = false;

        // ca sa extrag pozitia ariei solide a entitatii
        entitate.solidArea.x += entitate.worldX;
        entitate.solidArea.y += entitate.worldY;

        // ca sa extrag pozitia ariei solide a obiectului
        gi.RexBibanu.solidArea.x += gi.RexBibanu.worldX;
        gi.RexBibanu.solidArea.y += gi.RexBibanu.worldY;

        switch(entitate.Directie)
        {
            case "Sus" ->
            {
                entitate.solidArea.y -= entitate.rexSpeed;
                if(entitate.solidArea.intersects(gi.RexBibanu.solidArea))
                //intersects pt ca sunt mai putine obiecte decat
                // tileuri in render distance mereu si e mai usor
                {
                    entitate.coliziuniOn = true;
                    contactJucator = true;
                }
            }
            case "Jos" ->
            {
                entitate.solidArea.y += entitate.rexSpeed;
                if(entitate.solidArea.intersects(gi.RexBibanu.solidArea))
                {
                    entitate.coliziuniOn = true;
                    contactJucator = true;
                }
            }
            case "Dreapta" ->
            {
                entitate.solidArea.x += entitate.rexSpeed;
                if(entitate.solidArea.intersects(gi.RexBibanu.solidArea))
                {
                    entitate.coliziuniOn = true;
                    contactJucator = true;
                }
            }
            case "Stanga" ->
            {
                entitate.solidArea.x -= entitate.rexSpeed;
                if(entitate.solidArea.intersects(gi.RexBibanu.solidArea))
                {
                    entitate.coliziuniOn = true;
                    contactJucator = true;
                }
            }
        }
        entitate.solidArea.x = entitate.solidAreaDefaultX;
        entitate.solidArea.y = entitate.solidAreaDefaultY;
        gi.RexBibanu.solidArea.x = gi.RexBibanu.solidAreaDefaultX;
        gi.RexBibanu.solidArea.y = gi.RexBibanu.solidAreaDefaultY;

        return contactJucator;
    }
}
