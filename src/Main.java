import java.util.Scanner;
import taxSystem.EMS;
import taxSystem.E;

public class Main {
    public static void main(String[] args) {

        int earnings = 0;
        int spendings = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Выводим информацию о возможных операциях пользователю
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Для завершения программы введите 'end'");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyE = scanner.nextLine();
                    int money = Integer.parseInt(moneyE);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyS = scanner.nextLine();
                    int money2 = Integer.parseInt(moneyS);
                    spendings += money2;
                    break;
                case 3:
                    int taxE = E.taxEarnings(earnings);
                    int taxEMS = EMS.taxEMS(earnings, spendings);
                    if (taxE > taxEMS) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                    } else if (taxE < taxEMS) {
                        System.out.println("Мы советуем вам УСН доходы");
                    } else {
                        // На случай, когда налог одинаковый, например, доход 10000, расход 6000 - налог в таких условиях одинаковый получился
                        System.out.println("Вы можете выбрать любую СНО из предложенных, т.к. сумма налога равна");
                    }
                    // Здесь вместо условного оператора легче использовать методы Math.max и Math.min, так как они сравнят значения и выведут нужное
                    System.out.println("Ваш налог составит: " + Math.min(taxE, taxEMS));
                    System.out.println("Налог на другой системе: " + Math.max(taxE, taxEMS));
                    System.out.println("Экономия: " + (Math.max(taxE, taxEMS)-Math.min(taxE, taxEMS)));
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}