import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Hub
 */
public class Hub {

    public static void main(String[] args) {
        Scanner work = new Scanner(System.in);
        File saved = new File("saveFile.txt");
        try (FileWriter svd = new FileWriter("saveFile.txt")) 
        {
        // BufferedReader bread = new BufferedReader(new FileReader(saved));
        boolean play = true;
        while (play)
        {
            System.out.println("Здравствуйте!");
            int i = 0;
            while (i == 0) 
            {
                System.out.println("Желаете продолжить сохранённую игру, или начать новую? 1/2");
                String choi = work.nextLine();
                if (choi.equals("2")) 
                {
                    i+=1;
                }
                else if (choi.equals("1"))
                {
                    try (BufferedReader bread = new BufferedReader(new FileReader(saved)))
                    {
                        String line;
                        String lines = "";
                        while (((line = bread.readLine()) != null)) 
                        {
                            lines += line;
                        }
                        System.out.println(lines);
                        // new Setting(1, mode);
                    }
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                    System.exit(1);
                }
                else 
                {
                    System.out.println("Ошибка!");
                }
            }
            i = 0;
            while (i == 0) 
            {
                System.out.println("Хотите играть с другим игроком, или с компьютером? 1/2: ");
                String mode = work.nextLine();
                if (mode.equals("1") || mode.equals("2")) 
                {
                    svd.write("gamemode: " + mode);
                    i+=1;
                    new Setting(0, mode);
                }
                else 
                {
                    System.out.println("Ошибка!");
                }
            }
        }
    }
    catch (IOException e) 
{
    e.printStackTrace();
}
}
}