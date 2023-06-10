import javax.swing.JFrame;

public class main {
    
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.setTitle("Rex Bibanu - RPG"); // bruh

        GameInterface GameInterface = new GameInterface();
        window.add(GameInterface); // initializare interfata

        window.pack(); // sa leg totul

        window.setLocationRelativeTo(null); // centrat
        window.setVisible(true);

        GameInterface.setupGame();

        GameInterface.startGameThread();
    }

}
