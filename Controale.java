import java.awt.event.KeyListener;
//import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

public class Controale implements KeyListener {

    GameInterface gi;
    public boolean Sus, Stanga, Jos, Dreapta; // WASD
    public boolean Save;

    public Controale(GameInterface gi)
    {
        this.gi = gi;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {      
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        int rexKey = e.getKeyCode();

        // Controale Title Screen
        if (gi.StatusJoc == gi.StatusTitle) {
            if (rexKey == KeyEvent.VK_W) {
                gi.iu.NumarComanda--;
                if (gi.iu.NumarComanda < 0) {
                    gi.iu.NumarComanda = 2;
                }
            }

            if (rexKey == KeyEvent.VK_S) {
                gi.iu.NumarComanda++;
                if (gi.iu.NumarComanda > 2) {
                    gi.iu.NumarComanda = 0;
                }
            }

            if (rexKey == KeyEvent.VK_ENTER) {
                if (gi.iu.NumarComanda == 0) {
                    gi.StatusJoc = gi.StatusStart;
                    //gi.playMusic(1);
                }
                if (gi.iu.NumarComanda == 1) {
                    //later
                }
                if (gi.iu.NumarComanda == 2) {
                    System.exit(0);
                }
            }
        }

        // Controale ingame
        if (gi.StatusJoc == gi.StatusStart) {
            if (rexKey == KeyEvent.VK_W) {
                Sus = true;
            }

            if (rexKey == KeyEvent.VK_A) {
                Stanga = true;
            }

            if (rexKey == KeyEvent.VK_S) {
                Jos = true;
            }

            if (rexKey == KeyEvent.VK_D) {
                Dreapta = true;
            }
            if (rexKey == KeyEvent.VK_Z)
            {
                Save = true;
            }

            if (rexKey == KeyEvent.VK_P) {
                if (gi.StatusJoc == gi.StatusStart)
                {
                    gi.StatusJoc = gi.StatusPauza;
                } else if (gi.StatusJoc == gi.StatusPauza)
                {
                    gi.StatusJoc = gi.StatusStart;
                }
            }

            if (rexKey == KeyEvent.VK_J)
            {
                gi.RexBibanu.Attacking = true;
            }
        }
        if (gi.StatusJoc == gi.StatusGameOver) {
            if (rexKey == KeyEvent.VK_W) {
                --gi.iu.NumarComanda;
                if (gi.iu.NumarComanda < 0) {
                    gi.iu.NumarComanda = 1;
                }
                //gi.playSE(5); // audio schimb optiuni
            }
            if (rexKey == KeyEvent.VK_S) {
                ++gi.iu.NumarComanda;
                if (gi.iu.NumarComanda > 1) {
                    gi.iu.NumarComanda = 0;
                }
                //gi.playSE(5); // audio schimb optiuni
            }
            if(rexKey == KeyEvent.VK_ENTER)
            {
                if(gi.iu.NumarComanda == 0)
                {
                    gi.StatusJoc = gi.StatusStart;
                    gi.retry();
                }
                if(gi.iu.NumarComanda == 1)
                {
                    gi.StatusJoc = gi.StatusTitle;
                    gi.restart();
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        int rexKey = e.getKeyCode();

        if(rexKey == KeyEvent.VK_W)
        {
            Sus = false;
        }

        if(rexKey == KeyEvent.VK_A)
        {
            Stanga = false;
        }

        if(rexKey == KeyEvent.VK_S)
        {
            Jos = false;
        }

        if(rexKey == KeyEvent.VK_D)
        {
            Dreapta = false;
        }
        if(rexKey == KeyEvent.VK_J)
        {
            gi.RexBibanu.Attacking = false;
        }
        if (rexKey == KeyEvent.VK_Z)
        {
            Save = false;
        }
    }
}
