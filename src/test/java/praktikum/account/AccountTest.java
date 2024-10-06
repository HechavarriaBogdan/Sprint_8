package praktikum.account;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest (String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "name is {0}")
    public static Object[][] nameVariants() {
        return new Object[][] {
                {"J D", true}, // 3 символа
                {"John Doeertyuiopqwe", true}, // 19 символов
                {"Тимоти Шаламе", true},
                {"Ти", false}, // 2 символа
                {"Тимоти Сентиментальн", false}, // 20 символов
                {"ТимотейШевроле", false}, // без пробелов
                {" ТимотиШаламе", false}, // пробел в начале
                {"ТимотиШаламе ", false}, // пробел в конце
                {" ", false}, // пустой ввод
        };
    }

    @Test
    @DisplayName("Check different names")
    public void checkName() {
        Allure.parameter("name", name);
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }


}
