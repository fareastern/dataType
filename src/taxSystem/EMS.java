package taxSystem;

// Расчет налога 15% с дохода по СНО - УСН Доходы минус расходы
public class EMS {
    public static int taxEMS(int earning, int spending) {
        int tax = (earning - spending) * 15 / 100;
        // Здесь вместо условного оператора легче использовать метод Math.max, так как он вернет 0 только в случае, если tax будет отрицательным
        return Math.max(tax, 0);
    }
}