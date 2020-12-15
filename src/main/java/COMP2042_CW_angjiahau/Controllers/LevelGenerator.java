package COMP2042_CW_angjiahau.Controllers;
import COMP2042_CW_angjiahau.Screens.*;

/**
 * Used to generate Levels
 */
public class LevelGenerator  {
    /**
     * Used as a Level Generator to adhere Factory Design Pattern.
     * @param levelClassName Name of the Level's class to be added.
     * @return A new instance of the level calss.
     */
    public static Level getLevel (String levelClassName){
       switch(levelClassName){
           case "Level1":
               return new Level1();
           case "Level2":
               return new Level2();
           case "Level3":
               return new Level3();
           case "Level4":
               return new Level4();
           case "Level5":
               return new Level5();
           case "Level6":
               return new Level6();
           case "Level7":
               return new Level7();
           case "Level8":
               return new Level8();
           case "Level9":
               return new Level9();
           case "Level10":
               return new Level10();

           default:
               return null;
       }
    }


}
