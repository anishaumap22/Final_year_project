package com.project.algo;
import java.awt.image.BufferedImage;
public class ImageOperations {

public static BufferedImage Threshold(BufferedImage img,int requiredThresholdValue) {

int height = img.getHeight();
int width = img.getWidth();
BufferedImagefinalThresholdImage = new
BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;

int red = 0;
int green = 0;
int blue = 0;
for (int x = 0; x &lt; width; x++) {
// System.out.println(&quot;Row: &quot; + x);

try {
for (int y = 0; y &lt; height; y++) {
int color = img.getRGB(x, y);


red = ImageOperations.getRed(color);
green = ImageOperations.getGreen(color);
blue = ImageOperations.getBlue(color);
// System.out.println(&quot;Threshold : &quot; +
requiredThresholdValue);

if((red+green+green)/3 &lt; (int)

(requiredThresholdValue)) {

finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(0, 0,0));

}
else {

finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(255, 255,255));

}

}
} catch (Exception e) {
e.getMessage();
}
}

return finalThresholdImage;
}
static int mixColor(int red, int green, int blue) {
return red&lt;&lt;16|green&lt;&lt;8|blue;


}
public static int getRed(int color) {
return (color &amp; 0x00ff0000) &gt;&gt; 16;
}
public static int getGreen(int color) {
return (color &amp; 0x0000ff00) &gt;&gt; 8;
}
public static int getBlue(int color) {
return (color &amp; 0x000000ff) &gt;&gt; 0;
}
}