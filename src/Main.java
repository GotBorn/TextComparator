import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader firstInput, secondInput;

        firstInput = LoadFile(" первому"); // загрузка файлов
        secondInput = LoadFile("о второму");

        System.out.println("Список отличий:");

        int charOne = firstInput.read(), charTwo = secondInput.read(),
                charPosition = 1; // порядковый номер символа в файлах
        boolean isAnyDifferences = false;


        while (charOne != -1 && charTwo != -1) { // пока не закончится один из файлов, считываем посимвольно
            if (charOne != charTwo) {
                if (charPosition == 1) { // если впервые обнаружили различие, выводим шапку таблицы
                    System.out.println("№\tfile1\tfile2");
                }
                isAnyDifferences = true;
                System.out.println(charPosition + "\t" + (char)charOne +
                        "    \t" + (char)charTwo);
            }
            charPosition++;
            try{
                charOne = firstInput.read();
                charTwo = secondInput.read();
            }
            catch (Exception e){
                System.out.println("Ошибка чтения файлов");
            }
        }


        String fileNumber, textBeginning; // временные строки для генерации сообщения
                                          // на случай большого количества различающихся символов
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

    private static FileReader LoadFile(String outputText) {
        Scanner consoleIn = new Scanner(System.in);
        while(true) {
            System.out.println("Введите полный путь к" + outputText + " файлу. Например, E:\\example.txt");
            String filePath = consoleIn.nextLine();
            try{
                return new FileReader(filePath);
            }
            catch (FileNotFoundException e) {
                System.out.println("Такого файла не существует или путь некорректен");
            }
        }
    }
}
