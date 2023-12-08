package z2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Drukarka {
    public void start(String input, String output) {
        File file=new File(input);
        try {
            Scanner scanner=new Scanner(file);
            PrintWriter printWriter = new PrintWriter(output);
            List<Integer> list=new ArrayList<>();
            while (scanner.hasNext()){
                String a=scanner.nextLine();
                try{
                    list.add(Integer.parseInt(a));
                }catch (NumberFormatException e){
                    if (a.equals("drukuj")){
                        if (list.isEmpty()){
                            printWriter.println("brak");
                        }
                        else {
                            Collections.sort(list);
                            printWriter.println(list.get(list.size()-1));
                            list.remove(list.get(list.size()-1));
                        }

                    } else if (a.equals("koniec")) {
                        if (list.isEmpty()){
                            printWriter.println("brak");
                        }
                        else {
                            list.sort(Collections.reverseOrder());
                            for (Integer integer : list) {
                                printWriter.println(integer);
                            }
                        }
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
