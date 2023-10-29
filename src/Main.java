import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "ovchinnikova";
        String password = "Qq654321";
        String confirmPassword = "Qq654321";

        try {
            registrationOfUser(login, password, confirmPassword);
        } catch (WrongLoginException wrongLoginException) {
            wrongLoginException.printStackTrace();
        } catch (WrongPasswordException wrongPasswordException) {
            wrongPasswordException.printStackTrace();
        }
        System.out.println("Регистрация выполнена!");
    }

    private static final String VALID_CHARACTER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    private static final int MAX_LENGH = 20;

    public static void registrationOfUser(String login, String password, String confirmPassword) {
        for (int i = 0; i < login.length(); i++) {
            if (VALID_CHARACTER.indexOf(login.charAt(i)) == -1) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }
        }
        if (login.length() > MAX_LENGH) {
            throw new WrongLoginException("Длина логина больше допустимой");
        }

        for (int i = 0; i < password.length(); i++) {
            if (VALID_CHARACTER.indexOf(password.charAt(i)) == -1) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
        }
        if (password.length() > MAX_LENGH) {
            throw new WrongPasswordException("Длина пароля больше допустимой");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}