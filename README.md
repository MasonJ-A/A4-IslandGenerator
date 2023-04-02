# Assignment A2: Mesh Generator

  - Pedro Henrique Azevedo [azevedp@mcmaster.ca]
  - Muhammad Umar Khan [khanm417@mcmaster.ca]
  - Omar El Aref [elarefo@mcmaster.ca]
  - Mason Azzopardi [azzoparm@mcmaster.ca]

## How to run the product

_This section needs to be edited to reflect how the user can interact with thefeature released in your project_

### Installation instructions

This product is handled by Maven, as a multi-module project. We assume here that you have cloned the project in a directory named `A2`

To install the different tooling on your computer, simply run:

```
mosser@azrael A2 % mvn install
```

After installation, you'll find an application named `generator.jar` in the `generator` directory, and a file named `visualizer.jar` in the `visualizer` one. 

### Generator

To run the generator, go to the `generator` directory, and use `java -jar` to run the product. The product takes one single argument (so far), the name of the file where the generated mesh will be stored as binary.

```
mosser@azrael A2 % cd generator 
mosser@azrael generator % java -jar generator.jar sample.mesh
mosser@azrael generator % ls -lh sample.mesh
-rw-r--r--  1 mosser  staff    29K 29 Jan 10:52 sample.mesh
mosser@azrael generator % 
```

### Visualizer

To visualize an existing mesh, go the the `visualizer` directory, and use `java -jar` to run the product. The product take two arguments (so far): the file containing the mesh, and the name of the file to store the visualization (as an SVG image).

```
mosser@azrael A2 % cd visualizer 
mosser@azrael visualizer % java -jar visualizer.jar ../generator/sample.mesh sample.svg

... (lots of debug information printed to stdout) ...

mosser@azrael visualizer % ls -lh sample.svg
-rw-r--r--  1 mosser  staff    56K 29 Jan 10:53 sample.svg
mosser@azrael visualizer %
```
To viualize the SVG file:

  - Open it with a web browser
  - Convert it into something else with tool slike `rsvg-convert`

## How to contribute to the project

When you develop features and enrich the product, remember that you have first to `package` (as in `mvn package`) it so that the `jar` file is re-generated by maven.

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
  

### Definition of Done

Add conditions for the feature have been met.

### Product Backlog

| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F01 | Generate missing segments in DotGen |   Omar   | 02/05/2023 |  02/07/2023   |   D    |
| F02 | Get average colour | Pedro  | 02/05/2023 | 02/07/2023  | D |
| F03 | Apply average colour to segment | Pedro  | 02/05/2023 | 02/07/2023  | D | 
| F04 | Edit GraphicRenderer to draw out segments | Everyone  | 02/05/2023 | 02/07/2023  | D  |
| F05 | Mesh ADT: Precision model | Omar and Umar | 02/19/2023 | 02/20/2023 | D |
| F06 | Mesh ADT: Polygon implementation | Omar | 02/19/2023 | 02/20/2023 | D |
| F07 | Mesh ADT: Allow only new vertices, segments and polygons | Omar | 02/19/2023 | 02/22/2023 | D |
| F08 | Producing full meshes | Omar and Umar | 02/20/2023 | 02/22/2023 | D |
| F09 | Add alpha value to colours to support transparency | Mason | 02/15/2023|02/21/2023 | D |
| F10 | Add thickness information/properties to vertices, segments and polygons | Mason | 02/15/2023|02/21/2023 |D |
| F11 | Visualization mode, debugging | Umar | 02/21/2023 | 02/22/2023 | D |
| F12 | Creating a new class and cleaning F06, F07, F08 to reduce technical debt | Pedro | 02/22/2023 | 02/23/2023 | D |
| F13 | Randomize generation of centroids | Mason | 02/24/2023 | 02/24/2023 | D |
| F14 | Voronoi diagrams | Mason and Pedro | 02/24/2023 | 02/24/2023 | D |
| F15 | Lloyd Relaxation | Mason and Pedro | 02/25/2023  | 02/27/2023  | D |
| F16 | Cropping Mesh | Pedro | 02/25/2023 | 02/25/2023 | D |
| F17 | Delaunay Triangulation | Mason | 02/27/2023 | 02/27/2023 | D |
| F18 | Convex Hull | Mason | 02/27/2023 | 02/27/2023 | D |
| F19 | Command line arguments | Pedro | 02/27/2023 | 02/27/2023 | D |

### A3 Product Backlog

| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F20 | Create Tile Types | Pedro | 03/08/2023 |  03/10/2023   | D |
| F21 | Assign Tile Types/Colors | Pedro | 03/08/2023 | 03/11/2023 | D |
| F22 | Fill polygons with the appropriate colour based on type | Mason and Pedro | 03/08/2023 |  03/11/2023 | D |
| F23 | MVP Nieghbors | Pedro | 03/11/2023 | 03/13/2023 | D |
| F24 | MVP/Step 1 | Pedro, Mason, Umar and Omar | 03/13/2023 | 03/14/2023 | D |
| F25 | Nieghbors | Mason and Pedro | 03/14/2023 | 03/17/2023 | D |
| F26 | Shapes | Pedro | 03/15/2023 | 03/25/2023 | D |
| F27 | Elevation | Omar | 03/15/2023 | 03/23/2023 | D |
| F28 | Lakes | Umar | 03/25/2023 | 03/26/2023 | D |
| F29 | Rivers | Omar and Umar | 03/23/2023 | 03/26/2023 | D |
| F30 | River Flow | Omar | 03/25/2023 | 03/26/2023 | D |
| F31 | Aquifiers | Omar | 03/23/2023 | 03/24/2023 | D |
| F32 | Soil Absorption | Mason | 03/25/2023 | 04/01/2023 | D |
| F33 | Biomes | Mason | 03/20/2023 | 04/01/2023 | D |
| F34 | Whittaker Diagrams | Mason | 03/21/2023 | 03/23/2023  | D |
| F35 | Reproducability | Pedro | 03/22/2023 | 03/25/2023 | D |


