package Environment.Animals;

import java.util.*;

public class Abilities {

  //Method to initiate a movement depending on different conditions
  public static void move(ArrayList<Animals> river, int i) {
    Animals natureOfAnimal = river.get(i);

    //Checking the type of the next cell in the arraylist

    if (i < river.size()) {
      if (natureOfAnimal != null) {
        if ((river.get(i) != river.get(i + 1)) && river.get(i + 1) == null) {
          river.set(i, null);
          river.set(i + 1, natureOfAnimal);
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
  public static void eat(ArrayList<Animals> river, int i) {
    Animals natureOfAnimal = river.get(i);
    

    if (natureOfAnimal.getClass().equals(Bear.class)) {
      river.set(i, null);
      river.set(i + 1, natureOfAnimal);
    } else if (river.get(i).getClass().equals(Fish.class) && river.get(i + 1).getClass().equals(Fish.class)) {
      newAnimalJoins(river, natureOfAnimal);
    } else {
      river.set(i, null);
    }
  }

  //This method will add a new animal to the river
  public static void newAnimalJoins(
    ArrayList<Animals> river,
    Animals animalType
  ) {
    //This variable is for finding the first occurences of null
    int index = 0;

    

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
        animalType.getClass().equals(Bear.class) ? new Bear() : new Fish()
      );
    } else {
      river.set(
        index,
        animalType.getClass().equals(Bear.class) ? new Bear() : new Fish()
      );
    }
  }

  //This method will not change anything in the arraylist
  public static void sleep() {}
}
