package ticket.booking.util;

public class UserServiceUtil {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String hashedPassword, String password) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}