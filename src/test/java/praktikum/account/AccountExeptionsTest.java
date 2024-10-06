package praktikum.account;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class AccountExeptionsTest {

    @Test(expected = NullPointerException.class)
    @DisplayName("Check Null name")
    public void checkNullName() {
        Account account = new Account(null);
        account.checkNameToEmboss();
    }
}
