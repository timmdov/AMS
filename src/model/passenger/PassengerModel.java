package model.passenger;

import model.passenger.data.*;

import java.util.ArrayList;
import java.util.List;

public class PassengerModel {

    private PassengerManagementSystem passengerData = new PassengerManagementSystem();

    private Passenger checkFields(
            String name,
            String surname,
            String luggageCountText,
            String yearOfBirthText,
            PassengerType passengerType
    ) {
        if (name.isEmpty() || surname.isEmpty() || luggageCountText.isEmpty() || yearOfBirthText.isEmpty()) {
            throw new IllegalArgumentException("Fill all fields");
        } else {
            int luggageCount = -1;
            int yearOfBirth = -1;

            try {
                luggageCount = Integer.parseInt(luggageCountText);
            } catch (Exception exception) {
                throw new IllegalArgumentException("Enter integer for Luggage Count");
            }

            try {
                yearOfBirth = Integer.parseInt(yearOfBirthText);
            } catch (Exception exception) {
                throw new IllegalArgumentException("Enter integer for year of birth");
            }

            Passenger newPassenger = null;
            assert passengerType != null;
            //If luggageCount and yearOfBirth are set, newPassenger will be created
            if (luggageCount != -1 && yearOfBirth != -1) {
                switch (passengerType) {
                    case Business -> {
                        try {
                            newPassenger = new BusinessPassenger(name, surname, luggageCount, yearOfBirth);
                        } catch (Exception ex) {
                            throw new IllegalArgumentException(ex.getMessage());
                        }
                    }
                    case Economy -> {
                        try {
                            newPassenger = new EconomyPassenger(name, surname, luggageCount, yearOfBirth);
                        } catch (Exception ex) {
                            throw new IllegalArgumentException(ex.getMessage());
                        }
                    }
                    case Family -> {
                        try {
                            newPassenger = new FamilyPassenger(name, surname, luggageCount, yearOfBirth);
                        } catch (Exception ex) {
                            throw new IllegalArgumentException(ex.getMessage());
                        }
                    }
                }
            }

            return newPassenger;
        }
    }

    public void addUser(
            String name,
            String surname,
            String luggageCountText,
            String yearOfBirthText,
            PassengerType passengerType
    ) {
        //1. step check fields
        //2. create new passenger
        //3. adduser
        Passenger newPassenger = checkFields(name, surname, luggageCountText, yearOfBirthText, passengerType);

        if (newPassenger != null) {
            passengerData.addUser(newPassenger);
        }
    }

    public List<Passenger> getAllPassengers() {
        return passengerData.getAllPassengers();
    }

    public Passenger getPassenger(int index) {
        return passengerData.getAllPassengers().get(index);
    }

    public void removeUser(int id) {
        passengerData.removeUser(id);
    }

    public void updateUser(
            String name,
            String surname,
            String luggageCountText,
            String yearOfBirthText,
            PassengerType passengerType,
            int passengerId
    ) {
        Passenger updatedPassenger = checkFields(name, surname, luggageCountText, yearOfBirthText, passengerType);
        updatedPassenger.setId(passengerId);
        passengerData.updateUser(updatedPassenger);
    }
}
