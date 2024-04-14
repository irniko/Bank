import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
@DisplayName("Проверка строки")
public class AccountTest {


    String name;
    boolean expectedResult;
    String message;
    Account account;

    public AccountTest(String name, boolean expectedResult, String message) {
        this.name = name;
        this.expectedResult = expectedResult;
        this.message = message;
    }

    @Before
    public void setUp() {
        account = new Account(name);
    }

    @Parameterized.Parameters(name = "Цвет: {2}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Тимоти Шаламе", true, "Строка соответствует требованиям"},
                {" Тимоти Шаламе", false, "Строка не соответствует требованиям: пробел в начале"},
                {"Тимоти Шаламе ", false, "Строка не соответствует требованиям: пробел в конце"},
                {"Т Ш", true, "Строка соответствует требованиям: 3 символа"},
                {"Тимоти ШаламеОпроаоот", false, "Строка не соответствует требованиям: больше 19 символов"}
        };
    }

    @Test
    @DisplayName("Проверка заданной строки")
    public void checkNameToEmboss() {
        Allure.parameter("Строка:", name);
        //System.out.println(account.checkNameToEmboss());
        assertEquals(expectedResult, account.checkNameToEmboss());
        Allure.step("Строка: " + name);
        Allure.step(message);
    }
}