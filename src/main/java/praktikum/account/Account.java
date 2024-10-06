package praktikum.account;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }


    public boolean checkNameToEmboss() {
        if (name.length() < 3 || name.length() > 19) {
            return false;
        }
        if (name.startsWith(" ") || name.endsWith(" ")) {
            return false;
        }
        return name.matches("^[^ ]+ [^ ]+$"); // регулярное выражение для проверки наличия пробела внутри строки
    }

}

