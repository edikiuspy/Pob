package z1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kalkulator{
    public void oblicz(String input,String output){
        File file=new File(input);
        try {
            Scanner scanner=new Scanner(file);
            PrintWriter printWriter = new PrintWriter(output);
            while (scanner.hasNext()){
                int a =scanner.nextInt();
                String dzialanie=scanner.next();
                int b=scanner.nextInt();
                switch (dzialanie) {
                    case "+" -> printWriter.println(a + b);
                    case "-" -> printWriter.println(a - b);
                    case "*" -> printWriter.println(a * b);
                    case "/" -> {
                        if (b == 0) printWriter.println("Dzielenie przez zero");
                        else printWriter.println(a / b);
                    }
                }

            }
            printWriter.close();
        }
        catch (FileNotFoundException e1) {
            try{
                PrintWriter printWriter = new PrintWriter(output);
                printWriter.println("Nie znaleziono pliku");
                printWriter.close();
            }catch (FileNotFoundException e2) {
                System.out.println("Nie zapisano plik");
            }
        }
    }

}
