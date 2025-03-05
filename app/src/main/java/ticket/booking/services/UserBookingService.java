package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "../localDB/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUsers();
    }

    public UserBookingService() throws IOException {
        loadUsers();
    }

    public List<User> loadUsers() throws IOException {
        File users = new File(USERS_PATH);
        return objectMapper.readValue(users, new TypeReference<List<User>>(){});
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
        try {
            objectMapper.writeValue(usersFile, userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fetchBooking() {
        user.printTicketsBooked();
        return;
    }

    public void cancelBooking() {

    }

    public List<Train> getTrains(String source, String destination) {
        TrainService trainService;
        try {
            trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}