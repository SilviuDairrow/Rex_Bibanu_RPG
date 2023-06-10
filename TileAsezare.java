import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Objects;

public class TileAsezare {

    GameInterface gi;
    public tile[] Dale;
    public int[][] MapaDale;

    String FilePathNivel1 = "res/Mapa/MapaNivel1.txt";
    String FilePathNivel2 = "res/Mapa/MapaNivel2.txt";
    String FilePathNivel3 = "res/Mapa/MapaNivel3.txt";

    public TileAsezare (GameInterface gi)
    {
        this.gi = gi;

        Dale = new tile[20];
        MapaDale = new int [gi.maxWorldCol][gi.maxWorldRanduri];

        getTileImagine();

        loadMapa(FilePathNivel3);
    }
    public void getTileImagine()
    {
        try
        {

            Dale[0] = new tile();
            Dale[0].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/wall.png")));
            Dale[0].coliziune = true;

            Dale[1] = new tile();
            Dale[1].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/grass.png")));

            Dale[2] = new tile();
            Dale[2].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/Dala_basic_1.png")));

            Dale[3] = new tile();
            Dale[3].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/wall.png")));

            Dale[4] = new tile();
            Dale[4].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/wall.png")));

            Dale[5] = new tile();
            Dale[5].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/wall.png")));

            Dale[6] = new tile();
            Dale[6].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/wall.png")));

            Dale[7] = new tile();
            Dale[7].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/wall.png")));

            Dale[8] = new tile();
            Dale[8].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/wall.png")));

            Dale[9] = new tile();
            Dale[9].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/Training1.png")));

            Dale[10] = new tile();
            Dale[10].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/Training2.png")));

            Dale[11] = new tile();
            Dale[11].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/Training3.png")));

            Dale[12] = new tile();
            Dale[12].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/Void.png")));

            Dale[13] = new tile();
            Dale[13].imagine = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/Tiles/Void.png")));
            Dale[13].coliziune = true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void loadMapa(String FilePath)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(FilePath);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int rand = 0;
            while(col < gi.maxWorldCol && rand < gi.maxWorldRanduri)
            {
                String line = br.readLine();
                while (col < gi.maxWorldCol)
                {
                    String[] NumereMapa = line.split(" ");

                    int num = Integer.parseInt(NumereMapa[col]);

                    MapaDale[col][rand] = num;
                    col++;
                }
                if(col == gi.maxWorldCol)
                {
                    col = 0;
                    rand++;
                }
            }
            br.close();

        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2)
    {
       int WorldCol = 0;
       int WorldRand = 0;

       while (WorldCol < gi.maxWorldCol && WorldRand < gi.maxWorldRanduri)
       {
           int DalaNr = MapaDale[WorldCol][WorldRand];

           int WorldX = WorldCol * gi.tileSize;
           int WorldY = WorldRand * gi.tileSize;
           int ScreenX = WorldX - gi.RexBibanu.worldX + gi.RexBibanu.screenX;
           int ScreenY = WorldY - gi.RexBibanu.worldY + gi.RexBibanu.screenY;

           if(WorldX + gi.tileSize > gi.RexBibanu.worldX - gi.RexBibanu.screenX && //ca sa randez pe ecran doar ce e in jurul lui rex
              WorldX - gi.tileSize < gi.RexBibanu.worldX + gi.RexBibanu.screenX &&
              WorldY + gi.tileSize > gi.RexBibanu.worldY - gi.RexBibanu.screenY &&
              WorldY - gi.tileSize < gi.RexBibanu.worldY + gi.RexBibanu.screenY)
           {
               g2.drawImage(Dale[DalaNr].imagine, ScreenX, ScreenY, gi.tileSize, gi.tileSize, null);
           }

           WorldCol++;

           if(WorldCol == gi.maxWorldCol)
           {
               WorldCol = 0;
               WorldRand++;
           }
       }
    }


}
