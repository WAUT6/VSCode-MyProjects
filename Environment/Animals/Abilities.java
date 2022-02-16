package Environment.Animals;

import java.util.*;

public class Abilities {

  //Method to initiate a movement depending on different conditions
  public static void move(ArrayList<Object> river, int i) {
    Object type = river.get(i);

    //Checking the type of the next cell in the arraylist

    if (i < river.size()) {
      if (type != null) {
        if ((river.get(i) != river.get(i + 1)) && river.get(i + 1) == null) {
          river.set(i, null);
          river.set(i + 1, type);
        } else if (river.get(i) == river.get(i + 1) && river.get(i) != null) {
          newAnimalJoins(river, river.get(i));
        } else if (
          (river.get(i) != river.get(i + 1)) && river.get(i + 1) != null
        ) {
          eat(river, i);
        }
      }
    } else {
      river.remove(i);
    }
  }

  //This method will allow the bear to eat the fish in the next cell (replace its position and make it disappear)
  public static void eat(ArrayList<Object> river, int i) {
    Object type = river.get(i);
    Object bear = new String("Bear");

    if (type.equals(bear)) {
      river.set(i, null);
      river.set(i + 1, type);
    } else if (river.get(i).equals("Fish") && river.get(i + 1).equals("Fish")) {
      newAnimalJoins(river, type);
    } else {
      river.set(i, null);
    }
  }

  //This method will add a new animal to the river
  public static void newAnimalJoins(
    ArrayList<Object> river,
    Object animalType
  ) {
    //This variable is for finding the first occurences of null
    int index = 0;

    Object bear = new String("Bear");

    for (int i = 0; i < river.size(); i++) {
      if (river.get(i) == null) {
        index = i;
        break;
      } else {
        continue;
      }
    }

    //Checking the type of the animal to clone
    if (index == 0) {
      river.add(
        0,
        animalType.equals(bear) ? new String("Bear") : new String("Fish")
      );
    } else {
      river.set(
        index,
        animalType.equals(bear) ? new String("Bear") : new String("Fish")
      );
    }
  }

  //This method will not change anything in the arraylist
  public static void sleep() {}
}
