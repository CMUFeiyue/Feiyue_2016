package imageProcessing;

public class ColorProcessing {
/*
 * color histogram
 * color threshold
 * color equalize
 */
	
	
	/**
	 * Applies a threshold to the three planes of an RGB or HSL 
	 * 		image and places the result into an 8-bit image.
	 * 
	 * @param dest is a reference to the destination image. 
	 * 		If Image Dst is connected, it must be an unsigned 8-bit image.
	 * @param source is the reference to the image to threshold. 
	 * 		The source image is converted to 8 bit and contains the result of the threshold
	 * 		if Image Dst is not connected.
	 * @param replaceValue is the value that the VI uses to fill pixels in the destination image 
	 * 		when the corresponding pixels in the Image Src are found in all three ranges. 
	 * 		The default is 1.
	 * @param mode defines the image color format to use for the operation. 
	 * 		Choose from the following values:

-RGB (0):
(Default) Specifies the color format RGB (red, green, and blue)
-HSL (1):	
Specifies the color format HSI (hue, saturation, and luminance)
-HSV (2):	
Specifies the color format HSV (hue, saturation, and value)
-HSI (3):	
Specifies the color format HSI (hue, saturation, and intensity)

@param plane1Range is a cluster used to determine the thresholding range for the red or hue plane, 
depending on the Color Mode. 
Any pixel values not included in this range are reset to zero in the destination image. 
The pixel values included in this range are altered depending on the status of the Replace input. 
By default, all pixel values are included (0, 255). 
Red or Hue Range includes the following elements:
-Lower value is the minimum pixel value in the red or hue plane that is used for the threshold. 
The default is 0.	
-Upper value is the maximum pixel value in the red or hue plane that is used for the threshold. 
The default is 255.
@param plane2Range is a cluster used to determine the thresholding range for the green or saturation plane, 
depending on the Color Mode. 
Any pixel values not included in this range are reset to zero in the destination image. 
The pixel values included in this range are altered depending on the status of the Replace input. 
By default, all pixel values are included (0, 255). 
Green or Sat Range includes the following elements:
-Lower value is the minimum pixel value in the green or saturation plane that is used for the threshold. 
The default is 0.
-Upper value is the maximum pixel value in the green or saturation plane that is used for the threshold. 
The default is 255.
@param plane3Range is a cluster used to determine the thresholding range 
for the blue, luminance, value, or intensity plane, depending on the Color Mode. 
Any pixel values not included in this range are reset to zero in the destination image. 
The pixel values included in this range are altered depending on the status of the Replace input. 
By default, all pixel values are included (0, 255). 
Blue or Luma or Val or Inten Range includes the following elements:	
-Lower value the minimum pixel value in the blue, luminance, value, or intensity plane that is used for the threshold. 
The default is 0.	
-Upper value the maximum pixel value in the blue, luminance, value, or intensity plane that is used for the threshold. 
The default is 255.
	 */
	public static void imaqColorThreshold(NIVision.Image dest,
            NIVision.Image source,
            int replaceValue,
            NIVision.ColorMode mode,
            NIVision.Range plane1Range,
            NIVision.Range plane2Range,
            NIVision.Range plane3Range) {
		
	}
	
}
