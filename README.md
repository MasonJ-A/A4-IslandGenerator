# a4-urbanism-MasonJ-A

## How to run the project
mvn install
java -jar generator/generator.jar -k irregular -h 500 -w 500 -p 1000 -s 20 -o img/test.mesh
java -jar island/island.jar -o img/test2.mesh -i img/test.mesh
java -jar visualizer/visualizer.jar -i img/test2.mesh -o img/test3.svg
 

## Backlog
Called after java -jar island/island.jar:
  Shapes:
    input `-s` as a command line argument followed by `circle`, `ellipse`, `star`, or `random` to select your island shape. The default shape is `circle`
  
  Mode:
    input `-m` as a command line argument followed by `basic` or `lagoon`. The default mode is `basic`, basic builds to the rest of the modifiers
  
  Biomes/Whittaker Diagrams:
    input `-temperature` to select average temperature type followed `cold`, `mild`, or `hot` afterwards. The default is `mild`
    input `-precipitation` to select average precipitation type followed by `dry`, `temperate`, or `tropical`. the default is `temperate`

  Altitude:
    input `-altitude` sets the type of altitude the user wants (for example `canyon`, `volcano`, `arctic`, `random`)

  Rivers:
    input `-numOfRiver`s sets the number of rivers

  Lakes:
    input `-numOfLakes` sets the number of lakes

  Aquifers:
    input `-numOfAquifer` sets the number of aquifers
  
  Beaches:
    input `-beachWidth` and enter a integer to represent the width that is larger than or equal to `0`. the default is `0`

Called after java -jar pathfinder/pathfinder.jar:
  City Size:
    input `-size` and enter and enter a city size: `'small'`, `'medium'`, or `'large'`, the default is `'small'`.
    
  City Number:
    input `-cityNum` and enter a integer to represent the number of cities that is larger than or equal to `0`. the default is `5`


