package missionariesandcannibals;

import java.util.ArrayList;
import java.util.List;


public class Coast {

    private Boat boat;
       
    private List<Human> passengers;

    public Coast() {
        passengers = new ArrayList<>();
    }
    
    void addPassenger(Human human) {
        passengers.add(human);
        checkIfMissionariesAreAlive();
    }
    
    boolean HasBoat() {
        return boat != null;
    }
  
    void moorBoat(Boat boat) {
        if (boat != null) {
            throw new RuntimeException("This world is too small for two boats!");
        }
        this.boat = boat;
    }
    
    void sendBoatToCoast(Coast coast) {
        
    }
    
    private void checkIfMissionariesAreAlive() {
        int missionaries = 0;
        int cannibals = 0;
        
        for (Human passenger : passengers) {
            if (passenger instanceof Missionary) {
                missionaries++;
            } else {
                cannibals++;
            }
        }
        
        if (cannibals > missionaries) {
            throw new RuntimeException("Rip in peace, missionaries...");
        }
    }

    
}
