# COMP2042_CW_angjiahau , Software Maintenance Coursework

### Classification and sorting for Images and Classes
Started off by re-aligning the background terrain of the frogger game. After that, i've created extra resources folders and sorted image sprites accordingly.
**(E.g, obstacles, platforms, misc, end...)** Besides resource folders, I've also created packages and sorted the classes accordingly.
**(E.g, Platforms, Controllers, Display)**  This clarifies the purpose of each element within the project.

### URL Pathing
Reduced the frequency of fixed url pathing by constructing a String **"RESOURCE_PATH" = "file:src/main/resources/"**. This concept is then extended to the other classes which
have file url path involvements. For example, obstacle will be extended to **"OBSTACLE_RESOURCE_PATH = "RESOURCE_PATH + "obstacle/ ""**.

### Creation of Level.java and Music.java 
MyStage.java originally only had one method which was to play music and to extend World.
Hence. i've broken down **MyStage.java** into **Level.java** and **Music.java**. After that, i added extra sound files into the Music.java file for when frogger character
is squashed, makes a move, or has drowned.
Within Level class, i've added all the methods and main elements that a level should have, **(E.g, 5 Ends, frogger character, timer, etc)**. 

### Multiple Levels, Info Screen, Starting Screen and HighScores
As mentioned earlier, i made a main Level.java class which holds methods and fields to be inherited by other level classes. Instead of having the y-coordinate values to be hardcoded,
i've split the window screen into 10 seperate rows and made an enumeration within Level.java which holds the y-coordinate values for each row.
Hence, when creating objects within levels, the enumeration values for each row can be called by **Rows.ROWX.getValue()**. 

Then, i made an info screen and starting screen.

After that, I made a HighScore class **(HighScore.java)** which creates, reads, writes and store high score files within the resources folder. The controller is called in Level.java. 
I then created 10 different Level classes **(Level1.java -> Level10.java)** which extends **Level.java** . 

### Animation Timeline and Image Hash Maps
Within Turtle.java, WetTurtle.java and Animal.java, there were many images which were called depending on situations **(E.g death animations)**. Hence, i've decided to store the
images within a hash map.
After that, I created animation timelines for wet turtle, turtle, water death and car death, rather than using the previous method which sets image based on **(now)/VALUE**. 

### Player Controls
Have reduced the player controls in Animal.java by calling the statement **setOnKeyReleased(getOnKeyPressed())**, and making adjustments for
the methods in lambda function setOnKeyPressed within the Animal.java constructor.

### Image Addition and Reduction
In the original file, there were unneccesary images such as "froggerUp", "froggerDown", "TruckLeft" , "TruckRight" etc. 
By using setRotate(x) method, i have managed to reduce the amount of images used. Hence making space for me to add new images such as Race Cars.

### LevelGenerator and Factory Design Pattern
Created LevelGenerator.java to generate Level1->Level10.java, which adheres the Factory Design Pattern.

### Platform and SinkingPlatform class
Have created Platform and SinkingPlatform classes for Log, Turtle and Wet Turtle. Increases maintaibility as future engineers will be able to easily add 
new platform and sinking platform characters.

### collisionCheck() 
Have made a collisionCheck() method in Animal.java which handles all sorts of collisions. Within this method, have changed the code such that frogger **FOLLOWS** the speed
of platforms. Originally, the moving speed of frogger upon hopping on a platform was hardcoded. Now, the speed for platforms can properly be a variable.

### Methods in Animal.java
Within animal.java there were many elements which i sorted by putting them into respective methods , such as checkCarDeath(), deathReset(), checkOutOfBounds() etc. 
This increases maintainbility and reduces the breeding ground for software bugs.
I've also added methods which allowed water level to be a variable within each level.

