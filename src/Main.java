import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner consoleIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String filePathOne, filePathTwo;
        FileReader firstInput = null, secondInput = null;
        //Scanner consoleIn = new Scanner(System.in);
        LoadFile(" первому", firstInput);
        LoadFile("о второму", secondInput);
        /*
        while(true) {
            System.out.println("Введите полный путь к первому файлу:");
            filePathOne = consoleIn.nextLine();
            try{
                firstInput = new FileReader(filePathOne);
            }
            catch (FileNotFoundException e) {
                System.out.println("Такого файла не существует или путь некорректен");
                continue;
            }
            break;
        }
        while(true) {
            System.out.println("Введите полный путь ко второму файлу:");
            filePathTwo = consoleIn.nextLine();
            try{
                secondInput = new FileReader(filePathTwo);
            }
            catch (FileNotFoundException e) {
                System.out.println("Такого файла не существует или путь некорректен");
                continue;
            }
            break;
        }
*/
        System.out.println("Список отличий:");

        int charOne = firstInput.read(), charTwo = secondInput.read(),
                charPosition = 1;
        boolean isAnyDifferences = false;
        try{
            while (charOne != -1 && charTwo != -1) {
                if(charOne != charTwo) {
                    if(charPosition == 1) {
                        System.out.println("№\tfile1\tfile2");
                    }
                    isAnyDifferences = true;
                    System.out.println(charPosition + "\t" + (char)charOne +
                            "    \t" + (char)charTwo);
                }
                charPosition++;
                charOne = firstInput.read();
                charTwo = secondInput.read();
            }
        }
        catch (Exception e){
            System.out.println("Ошибка чтения файлов");
        }

        String fileNumber, textBeginning;
        if (!isAnyDifferences){
            System.out.println("Отличий нет");
        }
        else if(charOne != charTwo) {
            if (charPosition == 1){
                textBeginning = "Все";
            }
            else {
                textBeginning = "и все";
            }
            if (charOne == -1) {
                fileNumber = "второго";
            }
            else {
                fileNumber = "первого";
            }
            System.out.println(textBeginning + " символы " + fileNumber + " файла, начиная с " + charPosition);
        }
        firstInput.close();
        secondInput.close();
    }
    private static void LoadFile(String outputText, FileReader fileStream) {
        while(true) {
            System.out.println("Введите полный путь к" + outputText + " файлу:");
            String filePath = consoleIn.nextLine();
            try{
                fileStream = new FileReader(filePath);
            }
            catch (FileNotFoundException e) {
                System.out.println("Такого файла не существует или путь некорректен");
                continue;
            }
            break;
        }
    }
}
