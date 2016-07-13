package imageProcessing;

public class Filters {
/* convolute
 * lowpass
 * edgedetection
 */
	/**
	 * Extracts the contours (detects edges) in gray-level values. Any image connected to the input Image Dst must be the same image type connected to Image Src. The image type connected to the input Image Mask must be an 8-bit image. The connected source image must have been created with a border capable of supporting the size of the processing matrix. For example, a 3 × 3 matrix has a minimum border size of 1. The border size of the destination image is not important.
	 * 
	 * @param dest is a reference to the destination image.
	 * @param source is a reference to the source image.
	 * @param method specifies the type of edge-detection filter to use. The default is EDGE_DIFFERENCE. 
	 * 		The following filters are valid:
	 * 		EDGE_DIFFERENCE: Processing with a 2 × 2 matrix
			EDGE_GRADIENT: Processing with a 2 × 2 matrix
			EDGE_PREWITT: Processing with a 3 × 3 matrix
			EDGE_ROBERTS: Processing with a 2 × 2 matrix
			EDGE_SIGMA: Processing with a 3 × 3 matrix
			EDGE_SOBEL: Processing with a 3 × 3 matrix
	 * @param mask is an 8-bit image that specifies the region of the small image that will be copied. Only pixels in the Image Src (Small) image that correspond to a non-zero pixel in the mask image are copied.
	 * 		All other pixels keep their original values. The entire image is processed if Image Mask is not connected.
	 */
	public static void imaqEdgeFilter(NIVision.Image dest,
            NIVision.Image source,
            NIVision.OutlineMethod method,
            NIVision.Image mask) {
		
	}
	
	/**
	 * Calculates the inter-pixel variation between the pixel being processed and those pixels surrounding it. If the pixel being processed has a variation greater than a specified percentage, it is set to the average pixel value as calculated from the neighboring pixels.
	 * 
	 * @param dest is a reference to the destination image.
	 * @param source is a reference to the source image.
	 * @param width is the size of the horizontal matrix axis. The default is 3.
	 * @param height is the size of the vertical matrix axis. The default is 3.
	 * @param tolerance is the maximum variation allowed. The default is 40%.]
	 * @param mask is an 8-bit image that specifies the region of the small image that will be copied. 
	 * Only pixels in the Image Src (Small) image that correspond to a non-zero pixel in the mask image are copied. 
	 * All other pixels keep their original values. 
	 * The entire image is processed if Image Mask is not connected.
	 */	
	public static void imaqLowPass(NIVision.Image dest,
            NIVision.Image source,
            int width,
            int height,
            float tolerance,
            NIVision.Image mask)
}
