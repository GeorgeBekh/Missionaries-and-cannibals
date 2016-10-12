/*
 * Задача:
 * Три миссионера и три каннибала находятся на одной стороне реки,
 * где также находится лодка, которая может выдержать одного или двух человек.
 * Найдите способ перевезти всех на другой берег реки, никогда не оставляя где-либо
 * группу миссионеров, которую превосходила бы по численности группа каннибалов.
 */
package missionariesandcannibals;

import java.util.ArrayList;
import java.util.List;

public class MissionariesAndCannibals {

	public static void main(String[] args) {
		Boat blackPearl = new Boat();
		Coast startCoast = new Coast();
		Coast targetCoast = new Coast();
		List<Human> passengers = createPassangers(3);

	}

	private static List<Human> createPassangers(int count) {
		ArrayList<Cannibal> cannibals = new ArrayList<>();
		ArrayList<Missionary> missionaries = new ArrayList<>();
		ArrayList<Human> passengers = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			cannibals.add(new Cannibal());
			missionaries.add(new Missionary());
		}

		passengers.addAll(cannibals);
		passengers.addAll(missionaries);

		return passengers;
	}

}
