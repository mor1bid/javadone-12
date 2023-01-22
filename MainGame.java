import java.util.Random;

public class MainGame{
    public MainGame(int bank, int p1scor, int p1bank, int p2scor, int p2bank)
    {
        while (bank>0) 
        {
            int move = new Random().nextInt(2);
            System.out.println(move);
            move = new Random().nextInt(2);
            System.out.println(move);
            
        }
    }
}
