import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
    public static void main(String[] args) {
        String url = "https://www.onliner.by/";
        String elementSelector = "span._u.js-валюта-сумма";
        String outputFile = "output.txt";

        try {
            // Создаем объект URL и открываем подключение к указанному URL-адресу
            URL website = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(website.openStream()));

            String line;
            StringBuilder htmlCode = new StringBuilder();

            // Считываем HTML-код страницы построчно
            while ((line = reader.readLine()) != null) {
                htmlCode.append(line);
            }

            reader.close();

            // Ищем числа в HTML-коде
            String regex = "<" + elementSelector + ">([0-9]+)<\\/";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(htmlCode);

            // Создаем файл для сохранения чисел
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Печатаем и сохраняем найденные числа
            while (matcher.find()) {
                String number = matcher.group(1);
                System.out.println(number);
                printWriter.println(number);
            }

            printWriter.close();
            System.out.println("Числа успешно сохранены в файл " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

