package Environment;

import Environment.Animals.Abilities;
import Environment.Animals.Animals;
import Environment.Animals.Bear;
import Environment.Animals.Fish;

import java.util.*;

public class River {

  public static void main(String[] args) {
    //Technique that will be used to randomly fill the river
    Animals[] animals = new Animals[3];
    animals[0] = new Bear();
    animals[1] = new Fish();
    animals[2] = null;

    //The river
    ArrayList<Animals> river = new ArrayList<Animals>(10);
    System.out.println(river.size());

    //Filling the river
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 1; j++) {
        int generator = (int) Math.floor(Math.random() * 3);
        System.out.println(generator);
        river.add(animals[generator]);
      }
    }
    System.out.println(river.toString());
    //Random Movement of the animal and running the  program in terms of a timer
    int timer = 10;
    String stateOfAnimals;
    for (int i = 0; timer != 0; timer--) {
      int randomMovement = (int) Math.floor(Math.random() * 2);
      if (randomMovement == 0) {
        stateOfAnimals = "Moving";
        System.out.println("Moving");
      } else {
        stateOfAnimals = "Sleeping";
        System.out.println("Sleeping");
      }

      for (int j = 0; j < river.size(); j++) {
        //Choosing a random action
        if (river.get(j) != null && j + 1 < river.size()) {
          if (stateOfAnimals.equals("Moving")) {
            Abilities.move(river, j);
          } else {
            Abilities.sleep();
          }
        } else {
          continue;
        }
        System.out.println(river.toString());
      }
      System.out.println(river.toString());
      System.out.println(timer);
    }
  }
}
