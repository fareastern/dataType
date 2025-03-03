package taxSystem;

// Расчет налога 6% с дохода по СНО - УСН Доходы
public class E {
    public static int taxEarnings (int earning) {
        return earning * 6 / 100;
    }
}