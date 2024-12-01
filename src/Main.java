import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Создание объекта класса InterpolDatabase
        InterpolDatabase database = new InterpolDatabase();
        // Загрузка данных из файла
        database.loadFromFile();
        Scanner scanner = new Scanner(System.in);

        // Выбор действия
        while (true) {
            System.out.println("\n1. Добавить информацию о преступнике");
            System.out.println("2. Просмотреть всю базу данных");
            System.out.println("3. Поиск по базе данных");
            System.out.println("4. Выход");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Добавление информации о преступнике
                    System.out.print("Введите Фамилию: ");
                    String surname= scanner.nextLine();
                    System.out.print("Введите Имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите Кличку: ");
                    String nickname = scanner.nextLine();
                    System.out.print("Введите Рост: ");
                    String height = scanner.nextLine();
                    System.out.print("Введите Цвет волос: ");
                    String hairColor = scanner.nextLine();
                    System.out.print("Введите Цвет глаз: ");
                    String eyeColor = scanner.nextLine();
                    System.out.print("Введите Особые приметы: ");
                    String distinctiveMarks = scanner.nextLine();
                    System.out.print("Введите Гражданство: ");
                    String citizenship = scanner.nextLine();
                    System.out.print("Введите Место и дату рождения: ");
                    String birthPlaceAndDate = scanner.nextLine();
                    System.out.print("Введите Преступная профессия: ");
                    String criminalProfession = scanner.nextLine();
                    System.out.print("Введите Последнее дело: ");
                    String lastCase = scanner.nextLine();

                    //Слава Богу мы написали все параметры, сохраняем
                    Criminal criminal = new Criminal(surname, name, nickname, height, hairColor,
                            eyeColor, distinctiveMarks, citizenship, birthPlaceAndDate,
                            criminalProfession, lastCase);
                    database.addCriminal(criminal);
                    break;
                case 2:
                    //Увидеть всю БД
                    database.viewCriminals();
                    break;
                case 3:
                    //Поиск по ключевому слову
                    System.out.print("Введите данные для поиска: ");
                    String searchTerm = scanner.nextLine();
                    database.searchCriminal(searchTerm);
                    break;
                case 4:
                    //Выход
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}

