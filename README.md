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

## Backlog

### Definition of Done

Add conditions for the feature have been met.

### Product Backlog

| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F01 | Generate missing segments in DotGen |   Omar   | 02/05/2023 |  02/07/2023   |   D    |
| F02 | Get average colour | Pedro  | 02/05/2023 | 02/07/2023  | D |
| F03 | Apply average colour to segment | Pedro  | 02/05/2023 | 02/07/2023  | D  | 
| F04 | Edit GraphicRenderer to draw out segments | Everyone  | 02/05/2023 | 02/07/2023  | D  |
| F05 | Mesh ADT: Precision model | Omar and Umar | 02/19/2023 | 02/20/2023 | D |
| F06 | Mesh ADT: Polygon implementation | Omar and Pedro | 02/19/2023 | 02/20/2023 | D |
| F07 | Mesh ADT: Allow only new vertices, segments and polygons | Omar and Pedro | 02/19/2023 | 02/23/2023 | D |
| F08 | Producing full meshes | Omar and Umar | 02/20/2023 | 02/22/2023 | D |
| F09 | Add alpha value to colours to support transparency | Mason | 02/15/2023|02/21/2023 | D |
| F10 | Add thickness information/properties to vertices, segments and polygons | Mason | 02/15/2023|02/21/2023 |D |
| F11 | Visualization mode, debugging | Umar | 02/21/2023 | 02/22/2023 | D |
| F12 | Randomize generation of centroids | Mason | 02/24/2023 | 02/24/2023 | D |
| F13 | Veronoi diagrams | Mason | 02/24/2023 | 02/24/2023 | D |
| F14 | Lloyd Relaxation | All |  |  | p |
| F15 | Cropping Mesh | All |  |  | p |
| F16 | Delaunay Triangulation | All |  |  | p |
| F16 | Convex Hull | All |  |  | p |

