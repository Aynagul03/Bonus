import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    private void assertEquals(long expected, long actual) {
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateBonusIfHugeAmountAndNotRegistered() {
        BonusService service = new BonusService();

        long actual = service.calculate(10_000_000, false);
        long expected = 500;

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldCalculateBonusIfSmallAmountAndRegistered() {
        BonusService service = new BonusService();
        long actual = service.calculate(1000, true);
        long expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldCalculateBonusIfHugeAmountAndRegistered() {
        BonusService service = new BonusService();
        long actual = service.calculate(10_000_000, true);
        long expected = 500;

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldCalculateBonusIfSmallAmountAndNotRegistered() {
        BonusService service = new BonusService();
        long actual = service.calculate(1000, false);
        long expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}

