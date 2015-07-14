# About Kryten
Simple game engine writen in Java using [OpenGL](https://www.opengl.org/), [LWJGL](http://www.lwjgl.org/), [Slick2D](http://slick.ninjacave.com/).

For running an example you need to set path to native libraries to VM Arguments. (In eclipse you can set it Project > Propertities > Run/Debug Settings > Create or edit launch configuration)

- On Linux: -Djava.library.path=lib/native/linux
- On Mac: -Djava.library.path=lib/native/macosx
- On Windows: -Djava.library.path=lib/native/windows

# Structure
  - Engine 
  Static class used to initialize OpenGL and Display (Window of aplication). Also contains gameLoop which is doing these steps:

  1. Get user input
  2. Upadte the game
  3. Render game

