import java.util.Scanner;

public class Setting {
    public Setting(int load, String mode) 
    {
        Scanner work = new Scanner(System.in);
        if (load == 1) 
        {

        }
        else 
        {
            System.out.println("Введите желаемое количество конфет в общем банке: ");
            int bank = work.nextInt();
            int p1scor = 0;
            int p2scor = 0;
            int p2bank = 0;
            int p1bank = 0;
            new MainGame(mode, bank, p1scor, p2scor, p2bank, p1bank);
        }
    }
}
