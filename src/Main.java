import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePathOne, filePathTwo;
        FileReader firstInput = LoadFile(" первому", firstInput),
                   secondInput = LoadFile("о второму", secondInput);
        
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
    
    private static FileReader LoadFile(String outputText, FileReader fileStream) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Введите полный путь к" + outputText + " файлу:");
        while(true)
            try{
                return new FileReader(sc.nextLine());
            }catch (FileNotFoundException e) {
                System.out.println("Ошибка c cообщением - " + e.getMessage() + "\nПовторите ввод пути к файлу.");
            }finaly {
                sc.close();
            }
        return null;//Вероятнее всего, этот возврат не пригодится и если ide предложит его удалить, удаляй =)
    }
}
