package praktikum.account;

import io.qameta.allure.Allure;
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
                {"Тимоти Шаламе", true},
                {"Ти", false},
                {"Тимоти Сентиментальный", false},
                {"ТимотейШевроле", false},
                {" ТимотиШаламе", false},
                {"ТимотиШаламе ", false}
        };
    }

    @Test
    public void checkName() {
        Allure.parameter("name", name);
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

    /** String validName = "Тимоти Шаламе";
    String nameLessThanThree = "Ти";
    String nameMoreThanNineteen = "Тимоти Сентиментальный";
    String nameWithoutSpace = "ТимотейШевроле";
    String nameWithSpaceInStart = " ТимотиШаламе";
    String nameWithSpaceInEnd = "ТимотиШаламе "; */
}
