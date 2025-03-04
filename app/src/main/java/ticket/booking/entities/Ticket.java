package org.example.entities;

import java.util.Date;

public class Ticket {
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;

    // Constructor
    public Ticket(String userId, String source, String destination, Date dateOfTravel, Train train) {
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTicketInfo() {
        return "Ticket Info: " +
               "\nUser ID: " + userId +
               "\nSource: " + source +
               "\nDestination: " + destination +
               "\nDate of Travel: " + dateOfTravel +
               "\nTrain: " + train.getTrainInfo();
    }
}