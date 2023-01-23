import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Hub {

    public static void main(String[] args) throws IOException 
    {
        Scanner work = new Scanner(System.in);
        File svd = new File("saveFile.txt");
        Path del = FileSystems.getDefault().getPath("saveFile.txt");
        boolean play = true;
        EndGame end = new EndGame(); // для объявления методов из других классов без использования перегрузки
        while (play)
        {
            System.out.println("Здравствуйте!");
            int i = 0;
            if (svd.exists())
            {
                while (i == 0) 
                {
                    System.out.println("Желаете продолжить сохранённую игру, или начать новую? 1/2");
                    int choi = work.nextInt();
                    if (choi == 2) 
                    {
                        try 
                        {
                            Files.deleteIfExists(del);
                        }
                        catch (IOException x) 
                        {
                            System.err.println(x);
                        }
                        i+=1;
                    }
                    else if (choi == 1)
                    {
                        new Setting(1);
                        play = end.endGame(play);
                    }
                    else
                    {
                        System.out.println("Ошибка!");
                    }
                }
            }
            new Setting(0);
            play = end.endGame(play);
        }
        work.close();
    }
}