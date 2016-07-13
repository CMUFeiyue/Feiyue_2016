package visionUtilities;

public class ImageManagement {

	/**
	 * @param type specifies the image type. 
	 * Choose from the following values:

-Grayscale (U8) (0):	
8 bits per pixel (unsigned, standard monochrome)
-Grayscale (16) (1):	
16 bits per pixel (signed)
-Grayscale (SGL) (2):	
32 bits per pixel (floating point)
-Complex (CSG) (3):
2 × 32 bits per pixel (floating point)
-RGB (U32) (4):	
32 bits per pixel (red, green, blue, alpha)
-HSL (U32) (5):	
32 bits per pixel (hue, saturation, luminance, alpha)
-RGB (U64) (6):
64 bits per pixel (red, green, blue, alpha)
-Grayscale (U16) (7):	
16 bits per pixel (unsigned, standard monochrome)

	 * @param borderSize determines the width, in pixels, of the border to create around an image. 
	 * These pixels are used only for specific VIs. 
	 * Create a border at the beginning of your application if an image is to be processed later 
	 * using functions that require a border (for example, labeling and morphology). 
	 * The default border value is 3. 
	 * With a border of three pixels, you can use kernels up to 7 × 7 with no change. 
	 * If you plan to use kernels larger than 7 × 7 in your process, 
	 * specify a larger border when creating your image.
	 * 
	 * @return the Image reference that is supplied as input 
	 * to all subsequent (downstream) functions used by NI Vision. 
	 * Multiple images can be created in a LabVIEW application.
	 * 
	 */
	public static NIVision.Image imaqCreateImage(NIVision.ImageType type,
            int borderSize) {
		
	}
}
