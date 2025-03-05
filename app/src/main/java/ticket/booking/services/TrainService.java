package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ticket.booking.entities.Train;

public class TrainService {
    
    private static final String TRAINS_PATH = "../localDB/trains.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Train> trainList;

    public TrainService() throws IOException {
        File trains = new File(TRAINS_PATH);
        trainList = objectMapper.readValue(trains, new TypeReference<List<Train>>() {});
    }

    public List<Train> searchTrains(String source, String destination) {
        return trainList.stream().filter(t -> validateTrain(t, source, destination)).collect(Collectors.toList());
    }

    private boolean validateTrain(Train t, String source, String destination) {
        int sourceIndex = trainList.indexOf(source);
        int destinationIndex = trainList.indexOf(destination);
        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }
}