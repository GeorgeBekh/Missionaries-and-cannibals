package missionariesandcannibals;

import java.util.ArrayList;
import java.util.List;

class Boat {

    private List<Human> passengers;
    
    public Boat() {
        passengers = new ArrayList<>();
    }
    
    /**
     *
     * @param human
     */
    void addPassenger(Human human) {
        if (passengers.size() < 2) {
            passengers.add(human);
            return;
        }
        throw new RuntimeException("Some people have drowned. Hope you're happy...");
    }
    
    List<Human> disembarkPassengers() {
        List<Human> disembarkedPassengers = passengers;
        passengers.clear();
        return disembarkedPassengers;
    }
}
