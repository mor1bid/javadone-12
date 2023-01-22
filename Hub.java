import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Hub
 */
public class Hub {

    public static void main(String[] args) throws IOException 
    {
        Scanner work = new Scanner(System.in);
        File svd = new File("saveFile.txt");
        FileWriter saved = new FileWriter("saveFile.txt", false);
        boolean play = true;
        while (play)
        {
            System.out.println("Здравствуйте!");
            int i = 0;
            while (i == 0) 
            {
                if (svd.exists())
                {
                    System.out.println("Желаете продолжить сохранённую игру, или начать новую? 1/2");
                    String choi = work.nextLine();
                    if (choi.equals("2")) 
                    {
                        i+=1;
                    }
                    else if (choi.equals("1"))
                    {
                        try (BufferedReader bread = new BufferedReader(new FileReader(svd)))
                        {
                            String line;
                            String lines = "";
                            while (((line = bread.readLine()) != null)) 
                            {
                                lines += line;
                            }
                            System.out.println(lines);
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
            }
            i = 0;
            while (i == 0) 
            {
                System.out.println("Хотите играть с другим игроком, или с компьютером? 1/2: ");
                String mode = work.nextLine();
                if (mode.equals("1") || mode.equals("2")) 
                {
                    saved.write(mode+"\n");
                    saved.flush();
                    i+=1;
                    new Setting(0, mode);
                    i = 0;
                    while (i == 0) 
                    {
                        System.out.println("Новая игра? y/n");
                        String ng = work.nextLine();
                        if (ng.equals("n")) 
                        {
                            play = false;
                        }
                        else if (ng.equals("y")) 
                        {
                            i+=1;
                        }
                        else 
                        {
                            System.out.println("Ошибка!");
                        }
                    }
                }
                else 
                {
                    System.out.println("Ошибка!");
                }
            }
        }
        saved.close();
        work.close();
    }
}