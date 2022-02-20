package Environment.Animals;

import java.util.*;

public class AbilitiesV2 {

  public static void move(ArrayList<Animals> river, int i) {
    Animals natureOfCurrentAnimal = river.get(i);

    if (i != river.size() - 1) {
      if (river.get(i) != null && river.get(i + 1) == null) {
        river.set(i, null);
        river.set(i + 1, natureOfCurrentAnimal);
      } else if (
        river.get(i) != null &&
        river.get(i).getClass().equals(river.get(i + 1).getClass())
      ) {
        newAnimalJoins(river, i);
      } else if (
        river.get(i).getClass() != null &&
        river.get(i + 1).getClass() != river.get(i + 1).getClass()
      ) {
        eat(river, i);
      }
    } else if (i == river.size() - 1 && river.get(i) != null) {
      river.remove(i);
    }
  }

  public static void eat(ArrayList<Animals> river, int i) {
    Animals currentAnimal = river.get(i);

    if (
      currentAnimal.getClass().equals(Bear.class) &&
      river.get(i + 1).getClass().equals(Fish.class)
    ) {
      river.set(i + 1, currentAnimal);
      river.set(i, null);
    } else if (
      currentAnimal.getClass().equals(Fish.class) &&
      river.get(i + 1).getClass().equals(Bear.class)
    ) {
      river.set(i, null);
    }
  }

  public static void newAnimalJoins(ArrayList<Animals> river, int i) {
    Animals currentAnimal = river.get(i);
    // Class classOfCurrentAnimal = currentAnimal.getClass();

    if (river.contains(null)) {
      int indexOfNull = 0;
      for (int j = 0; j < river.size(); i++) {
        if (river.get(j) == null) {
          indexOfNull = j;
          break;
        }
        river.set(
          indexOfNull,
          currentAnimal.getClass().equals(Bear.class) ? new Bear() : new Fish()
        );
      }
    } else if (!(river.contains(null))) {
      river.set(
        0,
        currentAnimal.getClass().equals(Bear.class) ? new Bear() : new Fish()
      );
    }
  }

  public static void sleep() {}
}
