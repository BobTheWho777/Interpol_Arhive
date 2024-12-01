import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Criminal {
    String surname;
    String name;
    String nickname;
    String height;
    String hairColor;
    String eyeColor;
    String distinctiveMarks;
    String citizenship;
    String birthPlaceAndDate;
    String criminalProfession;
    String lastCase;

    //Конструктор
    public Criminal(String surname, String name, String nickname, String height, String hairColor,
                    String eyeColor, String distinctiveMarks, String citizenship, String birthPlaceAndDate,
                    String criminalProfession, String lastCase) {
        this.surname = surname;
        this.name = name;
        this.nickname = nickname;
        this.height = height;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.distinctiveMarks = distinctiveMarks;
        this.citizenship = citizenship;
        this.birthPlaceAndDate = birthPlaceAndDate;
        this.criminalProfession = criminalProfession;
        this.lastCase = lastCase;
    }

    //Конструктор для записи в файл
    public String toCsv() {
        return surname + "," + name + "," + nickname + "," + height + "," + hairColor + "," +
                eyeColor + "," + distinctiveMarks + "," + citizenship + "," +
                birthPlaceAndDate + "," + criminalProfession + "," + lastCase;
    }

    @Override
    public String toString() {
        return "Фамилия: " + surname + ", Имя: " + name + ", Кличка: " + nickname +
                ", Рост: " + height + ", Цвет волос: " + hairColor + ", Цвет глаз: " + eyeColor +
                ", Особые приметы: " + distinctiveMarks + ", Гражданство: " + citizenship +
                ", Место и дата рождения: " + birthPlaceAndDate + ", Преступная профессия: " +
                criminalProfession + ", Последнее дело: " + lastCase;
    }
}

public class InterpolDatabase {
    //Имя нашего файла-архива
    private static final String FILENAME = "criminals_database.txt";
    private List<Criminal> criminals = new ArrayList<>();

    public void addCriminal(Criminal criminal) {
        criminals.add(criminal);
        saveToFile();
    }

    // Загрузка БД csv формата из файла в список
    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11) {
                    criminals.add(new Criminal(data[0], data[1], data[2], data[3], data[4], data[5],
                            data[6], data[7], data[8], data[9], data[10]));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка загрузки базы данных: " + e.getMessage());
        }
    }

    // Сохранение списка в файл
    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Criminal criminal : criminals) {
                bw.write(criminal.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка сохранения базы данных: " + e.getMessage());
        }
    }

    // Вывод всего списка
    public void viewCriminals() {
        if (criminals.isEmpty()) {
            System.out.println("База данных пуста.");
        } else {
            for (Criminal criminal : criminals) {
                System.out.println(criminal);
            }
        }
    }

    // Поиск преступника по заданным данным, пока только одному
    public void searchCriminal(String searchTerm) {
        boolean found = false;
        String[] terms = searchTerm.toLowerCase().split("\\s+"); // Разделяем строку на слова
        for (Criminal criminal : criminals) {
            boolean matchesAll = true;
            for (String term : terms) {
                // Проверяем, содержит ли строка ключевые слова
                if (!criminal.toString().toLowerCase().contains(term)) {
                    matchesAll = false;
                    break;
                }
                //Если нашла, то выводим результат юзеру
            }if (matchesAll) {
                System.out.println(criminal);
                found = true;
                }
            //Если не нашла, то говорим об этом юзеру
        }if (!found) {
            System.out.println("Преступник не найден.");
        }
    }
}