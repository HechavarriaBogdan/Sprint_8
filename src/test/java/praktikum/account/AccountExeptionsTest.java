package praktikum.account;

import org.junit.Test;

public class AccountExeptionsTest {

    @Test(expected = NullPointerException.class)
    public void checkNullName() {
        Account account = new Account(null);
        account.checkNameToEmboss();
    }
}
