// Создать карту (Map), будет хранить в себе данные телефонной книги (Фамилии и телефонные номера), 
// если будут дубликаты фамилий, то должны выводиться оба номера (если помним Map не может хранить 
// дубликаты, будет заменять номер телефона по ключу, нужно подумать как не допустить такого)


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class lesson3task1 {
    
    public static Map<String, List<String>> addToPhonebook(Map<String, List<String>> phonebook, 
                                                            String userName, String userPhone) 
    {
            if (phonebook.containsKey(userName)) {
            phonebook.get(userName).add(userPhone);
        } else {
            ArrayList<String> userPhoneList = new ArrayList<>();
            userPhoneList.add(userPhone);
            phonebook.put(userName, userPhoneList);
        }
        return phonebook;
    }

    public static void main(String[] args) {
        Map<String, List<String>> phonebook = new TreeMap<>();
        
        File newFile = new File("phonebookfile.txt");

        try (FileReader reader = new FileReader(newFile)) {
            Scanner scanner = new Scanner(newFile);
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                String userName = temp.substring(0, temp.indexOf(" "));
                String userPhone = temp.substring(temp.indexOf(" ")+1);
                addToPhonebook(phonebook, userName, userPhone);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
        System.out.println(phonebook);
    }

}