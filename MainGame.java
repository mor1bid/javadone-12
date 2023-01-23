import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class MainGame
{
    public MainGame(int move, String mode, int bank, int p1bank, int p2bank, int p1scor, int p2scor)
    {
        int p1mo = 27; //потому что игрок-компьютер выбором кол-ва опирается на решение игрока
        int p2mo = 0;
        Scanner work = new Scanner(System.in);
        while (bank>0) 
        {
            try(FileWriter saved = new FileWriter("saveFile.txt", false)) 
            {
                saved.write(move + " ");
                saved.write(mode + " ");
                saved.write(bank + " ");
                saved.write(p1bank + " ");
                saved.write(p2bank + " ");
                saved.write(p1scor + " ");
                saved.write(p2scor + " \n");
                saved.flush();
                System.out.println("\n(s) Приостановить игру");
                System.out.println("Игрок 1 - " + p1bank + " конфет\nИгрок 2 - " + p2bank + " конфет\nБанк - " + bank + " конфет\n");
                if (move != 1)
                {
                    System.out.println("Игрок 1 ходит первым! Введите желаемое кол-во конфет: ");
                    int i = 0;
                    while (i == 0) 
                    {
                        String pl1 = work.nextLine();
                        if (pl1.equals("s")) 
                        {
                            System.out.println("Игра приостановлена.");
                            System.exit(1);
                        }
                        else if (pl1.length() == 1 && Character.isDigit(pl1.charAt(0)) || pl1.length() > 1 && Character.isDigit(pl1.charAt(0)) && Character.isDigit(pl1.charAt(1))) 
                        {
                            p1mo = Integer.parseInt(pl1);
                            i+=1;
                        }
                        else 
                        {
                            System.out.println("Ошибка!");
                        }
                    }
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
                    System.out.println("Игрок 1 получил " + p1scor + " конфет(ы)! \n");
                        
                    if (mode.equals("1")) 
                    {
                        System.out.println("Игрок 2, введите желаемое кол-во конфет: ");
                        p2mo = work.nextInt();
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
                        p2mo = new Random().nextInt(bank+1);
                    }   
                    if (p2mo > 28 || p2mo>bank) 
                    {
                        System.out.println("Не жадничайте! Вы можете взять не больше чем есть в банке и не более 28 конфет за ход!");
                    }
                    else 
                    {
                        p2scor += p2mo;
                        p2bank = p2bank + p2mo + p1bank;
                        p1bank = 0;
                        bank -= p2mo;
                    }
                        System.out.println("Игрок 2 получил " + p2scor + " конфет(ы)! \nИгрок 1 остался без лакомств :с");
                }
                else
                {
                    if (mode.equals("1")) 
                    {
                        System.out.println("Игрок 2 ходит первым! Введите желаемое кол-во конфет: ");
                        p2mo = work.nextInt();
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
                        p2mo = new Random().nextInt(bank+1);
                    }   
                    if (p2mo > 28 || p2mo>bank) 
                    {
                        System.out.println("Не жадничайте! Вы можете взять не больше чем есть в банке и не более 28 конфет за ход!");
                    }
                    else 
                    {
                        p2scor += p2mo;
                        p2bank += p2mo;
                        bank -= p2mo;
                    }
                    System.out.println("Игрок 2 получил " + p2scor + " конфет(ы)! \n");

                    System.out.println("\n(s) Приостановить игру");
                    System.out.println("Игрок 1 - " + p1bank + " конфет\nИгрок 2 - " + p2bank + " конфет\nБанк - " + bank + " конфет\n");
                    System.out.println("Игрок 1, введите желаемое кол-во конфет: ");
                    int i = 0;
                    while (i == 0) 
                    {
                        String pl1 = work.nextLine();
                        if (pl1.equals("s")) 
                        {
                            System.out.println("Игра приостановлена.");
                            System.exit(1);
                        }
                        else if (pl1.length() == 1 && Character.isDigit(pl1.charAt(0)) || pl1.length() > 1 && Character.isDigit(pl1.charAt(0)) && Character.isDigit(pl1.charAt(1))) 
                        {
                            p1mo = Integer.parseInt(pl1);
                            i+=1;
                        }
                        else 
                        {
                            System.out.println("Ошибка!");
                        }
                    }
                    if (p1mo > 28 || p1mo > bank)
                    {
                        System.out.println("Не жадничайте! Вы можете взять не больше чем есть в банке и не более 28 конфет за ход!");
                    }
                    else 
                    {
                        p1scor += p1mo;
                        p1bank = p1bank + p1mo + p2bank;
                        p2bank = 0;
                        bank -= p1mo;
                    }
                        System.out.println("Игрок 1 получил " + p1scor + " конфет(ы)! \nИгрок 2 остался без лакомств :с");
                }
                move = new Random().nextInt(2);
                }
            catch(IOException e) 
            {
                e.printStackTrace();
            }
        }
        if (p1bank>p2bank) 
        {
            System.out.println("Игрок 1 побеждает с личным счётом в " + p1scor + " конфет!");
        }
        else if (p1bank<p2bank) 
        {
            System.out.println("Игрок 2 побеждает с личным счётом в " + p2scor + " конфет!");
        }
        else 
        {
            System.out.println("Ничья!");
        }
    }
}

