Indigo Renderer has an option to define textures on materials in Indigo Shader Language. The language is a functional programming language and it is not possible to just generate textures up front. Instead in the language the 2 coordinates of the current point are the argument to the 'main' function so the shader has to calculate how the given point should be shown(returning either RGB values for color textures or only a single value for bump map textures). Since the shader language has almost no real debugging possibilities I did some testing of my 'algorithms' in java.

So the point of this program was not to just generate some graphical image as this would be fairly easy in java and swing anyway. Instead I practised creating a function which only receives the 2 coordinates of current pixel and then returns how the given pixel should be colored - basically checking if the pixel belongs to a set while the set can be changed by changing the parameters inside the code.



I also added a previous python project('joonistamine.py') here as it is functionally quite similar. The python project draws all kinds of different predefined fractals and it is even possible to define new kinds of fractals. As a stupid programmer I have not written any documentation and given that I have mostly worked with java after creating this application, I don't even understand all the logic behind the code myself. It's pretty object-oriented, but could be made much better by dividing larger classes into separate files and there are possibly a ton of other improvements.

Added another old python program that draws tracks based on gps data. This was never finished as I started looking into java and I was never really that interested in analysing the data of my exercises. Created this because I had a gps recording device that didn't have any screen so I wanted to calculate my distances and visualise the tracks.