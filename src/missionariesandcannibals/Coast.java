package missionariesandcannibals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coast {

	private boolean boat;

	private List<Human> humans;

	private List<Human> prepairedToSendHumans;

	public Coast() {
		humans = new ArrayList<>();
		prepairedToSendHumans = new ArrayList<>();
	}

	boolean HasBoat() {
		return boat;
	}

	void moorBoat() {
		if (boat) {
			throw new RuntimeException("Boat is already here!");
		}
		boat = true;
	}

	void prepareToSend(String className) {
		if (humans.size() >= 2) {
			throw new RuntimeException("Can't send more than 2 humans");
		}
		try {
			for (Human human : humans) {
				if (Class.forName(className).isInstance(human)) {
					prepairedToSendHumans.add(human);
					humans.remove(human);
				}
			}
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("Wrong class name");
		}
	}
	
	void sendPreparedHumans(Coast coast) {
		coast.addHumans(prepairedToSendHumans);
		prepairedToSendHumans =  new ArrayList<>();
	}

	void addHumans(List<Human> humans) {
		if (humans.size() > 2) {
			throw new RuntimeException("3 or more people on a boat is bad!");
		}
		this.humans.addAll(humans);
	}

	List<Human> getHumans() {
		return humans;
	}

	boolean missionariesAreAlive() {
		int missionaries = 0;
		int cannibals = 0;

		for (Human passenger : humans) {
			if (passenger instanceof Missionary) {
				missionaries++;
			} else {
				cannibals++;
			}
		}

		return cannibals <= missionaries;
	}

}
