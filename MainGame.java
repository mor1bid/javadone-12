import java.util.Random;
import java.util.Scanner;

public class MainGame{
    public MainGame(String mode, int bank, int p1scor, int p1bank, int p2scor, int p2bank)
    {
        int p1mo = 0;
        int p2mo;
        Scanner work = new Scanner(System.in);
        while (bank>0) 
        {
            int move = new Random().nextInt(2);
            move = new Random().nextInt(2);
            for (int turn = 0; turn<=1;) 
            {
                if (move == 0) 
                {
                    System.out.println("Игрок 1 ходит первым! Введите желаемое кол-во конфет: ");
                    p1mo = work.nextInt(move);
                    if (p1mo > 28 || p1mo>bank) 
                    {
                        System.out.println("Не жадничайте! Вы можете взять не больше чем есть в банке и не более 28 конфет за ход!");
                    }
                    else 
                    {
                        p1scor += p1mo;
                        p1bank += p1mo;
                        bank -= p1mo;
                    }
                    System.out.println("Игрок 1 получил" + p1bank + "конфет(ы)! \n Конфет в банке:" + bank + "\n");
                }
                if (move != 1) 
                {
                    move+=1;
                }
                else 
                {
                    move-=1;
                }
                if (move == 1)
                {   
                    if (mode.equals("1")) 
                    {
                        System.out.println("Игрок 2, введите желаемое кол-во конфет: ");
                        p2mo = work.nextInt(move);
                    }
                    else if (bank > 28) 
                    {
                        p2mo = new Random().nextInt((p1mo+1-1)+1);
                    }
                    else if (bank > p1mo) 
                    {
                        p2mo = new Random().nextInt((bank-p1mo)+p1mo);
                    }
                    else 
                    {
                        p2mo = new Random().nextInt(bank);
                    }   
                    if (p2mo > 28 || p2mo>bank) 
                    {
                        System.out.println("Не жадничайте! Вы можете взять не больше чем есть в банке и не более 28 конфет за ход!");
                    }
                    else 
                    {
                        p1scor += p1mo;
                        p1bank += p1mo;
                        bank -= p1mo;
                    }
                    turn+=1;
                }
            }
        }
        if (p1bank>p2bank) 
        {
            System.out.println("Игрок 1 побеждает с личным счётом в" + p1scor + "конфет!");
        }
        else if (p1bank<p2bank) 
        {
            System.out.println("Игрок 2 побеждает с личным счётом в" + p2scor + "конфет!");
        }
        else 
        {
            System.out.println("Ничья!");
        }
        work.close();
    }
}
