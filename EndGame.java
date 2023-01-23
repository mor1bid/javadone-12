import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class EndGame
    {
        public boolean endGame(boolean play) throws IOException
        {
            Path del = FileSystems.getDefault().getPath("saveFile.txt");
            int i = 0;
            while (i == 0) 
                {
                    try 
                    {
                        Files.deleteIfExists(del);
                    }
                    catch (IOException x) 
                    {
                        System.err.println(x);
                    }
                    Scanner work = new Scanner(System.in);
                    System.out.println("Новая игра? y/n");
                    String ng = work.nextLine();
                    // work.close();
                    if (ng.equals("n")) 
                    {
                        i+=1;
                        return play = false;
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
            return play;
        }
    }