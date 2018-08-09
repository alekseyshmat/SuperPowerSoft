import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFile {
    //коллекция, хранящая данные из файла
    public static List<String> input = new ArrayList<String>();
    //коллекция, хранящая время прихода
    public static List<Integer> arrivalTime = new ArrayList<Integer>();
    //коллекция, хранящая время ухода
    public static List<Integer> careTime = new ArrayList<Integer>();

    public void fileRead() {
//         String path = "E:/WorkSoft/WorkSoft/input.txt";
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите путь к файлу, например: E:/work/input.txt");
        String path = scn.nextLine();

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            scn.close();
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
                input.add(line);
        } catch (IOException e) {
            System.out.println("Путь не найден");
        }
    }

    public List[] convertList(List<String> input) {
        for (String s : input) {
            String[] strs = s.split(" ");
            if (strs[0].length() != 5 || strs[1].length() != 5) {
                if (strs[0].length() != 5 && strs[1].length() != 5)
                    System.out.println("Время " + strs[0] + " и " + strs[1] + " не соответсвует формату HH:MM");
                else if (strs[0].length() != 5) {
                    System.out.println("Время " + strs[0] + " не соответсвует формату HH:MM");
                } else
                    System.out.println("Время " + strs[1] + " не соответсвует формату HH:MM");
            } else {
                if (Integer.parseInt(strs[0].subSequence(0, 2).toString()) > 24 ||
                        Integer.parseInt(strs[1].subSequence(0, 2).toString()) > 24 ||
                        Integer.parseInt(strs[0].subSequence(3, 5).toString()) > 60 ||
                        Integer.parseInt(strs[1].subSequence(3, 5).toString()) > 60) {
                    System.out.println("Время в строке " + (input.indexOf(s) + 1) + " не соответсвует формату: 00:00 ≤ HH:ММ ≤ 23:59");
                } else if (Integer.parseInt(strs[0].replaceAll(":", "")) > Integer.parseInt(strs[1].replaceAll(":", ""))) {
                    System.out.println("Начальное время в строке " + (input.indexOf(s) + 1) + " больше конечного");
                } else {
                    arrivalTime.add(Integer.parseInt(strs[0].replaceAll(":", "")));
                    careTime.add(Integer.parseInt(strs[1].replaceAll(":", "")));
                }
            }
        }
        return new List[]{arrivalTime, careTime};
    }
}
