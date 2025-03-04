package ticket.booking.services;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "../localDB/users.json";

    public UserBookingService(User user) {
        this.user = user;
        File users = new File(USERS_PATH);
        this.userList = objectMapper.readValue(users, new TypeReference<List<User>>());
    }

    public boolean loginUser() {
        Optional<User> foundUser = userList.stream().filter(u -> {
            return u.getName().equals(user.getName()) && UserServiceUtil.checkPassword(u.getHashedPassword(), user.getPassword());
        }).findFirst();

        return foundUser.isPresent();
    }

    public boolean signup(User u) {
        try {
            userList.add(u);
            saveUserListToFile();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void saveUserListToFile() {
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }
}