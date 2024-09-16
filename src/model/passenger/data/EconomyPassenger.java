package model.passenger.data;

public class EconomyPassenger extends Passenger{

    public EconomyPassenger(String name, String surname, int luggageCount, int yearOfBirth) {
        setName(name);
        setSurname(surname);
        setLuggageCount(luggageCount);
        setYearOfBirth(yearOfBirth);
        setPassengerType(PassengerType.Economy);
    }

}
