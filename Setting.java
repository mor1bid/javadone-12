import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Setting 
{
    public Setting(int load) 
    {
        Scanner work = new Scanner(System.in);
        File svd = new File("saveFile.txt");
        if (load == 1) 
        {
            try (BufferedReader bread = new BufferedReader(new FileReader(svd)))
            {
                String line;
                String lines = "";
                while (((line = bread.readLine()) != null)) 
                {
                    lines += line;
                }
                List<String> slot = Arrays.asList(lines.split(" "));
                System.out.println(Arrays.asList(slot));
                new MainGame(Integer.parseInt(slot.get(0)), slot.get(1), Integer.parseInt(slot.get(2)), Integer.parseInt(slot.get(3)), Integer.parseInt(slot.get(4)), Integer.parseInt(slot.get(5)), Integer.parseInt(slot.get(6)));
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        else 
        {
            int i = 0;
            String mode = "";
            while (i == 0) 
            {
                System.out.println("Хотите играть с другим игроком, или с компьютером? 1/2: ");
                mode = work.nextLine();
                if (mode.equals("1") || mode.equals("2")) 
                {
                    i+=1;
                }
                else 
                {
                    System.out.println("Ошибка!");
                }
            }
            System.out.println("Введите желаемое количество конфет в общем банке: ");
            int bank = work.nextInt();
            int p1scor = 0;
            int p2scor = 0;
            int p2bank = 0;
            int p1bank = 0;
            int move = new Random().nextInt(2);
            new MainGame(move, mode, bank, p1scor, p2scor, p2bank, p1bank);
        }
    }
}
