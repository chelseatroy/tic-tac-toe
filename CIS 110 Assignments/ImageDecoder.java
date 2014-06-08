import javax.imageio.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;


public class ImageDecoder {
	public static void main(String args [])throws IOException, FileNotFoundException{
		printStatement();
		BufferedImage image = getImageFile();
		
		//paramaters to pass to getRGB
		int startX = 0;
		int startY = 0;
		int w = image.getWidth(); //the width of the BufferedImage;
		int h = image.getHeight(); //the height of the BufferedImage;
		int[] rgbArray = null;
		int offset = 0;
		int scansize = image.getWidth(); //the width of the BufferedImage;
		int[] pixels = image.getRGB(startX, startY, w, h, rgbArray, offset, scansize);
		
		String secretMessage = returnSecretMethod(pixels, w, h);
		createOutput(secretMessage);
	}
	
	public static void printStatement()throws IOException, FileNotFoundException{ 
		System.out.println("This program reads in a png image file");
		System.out.println("and extracts a hidden message from it encoded");
		System.out.println("in the image's lower-order bits.  It then");
		System.out.println("writes that message to a file.");
	}
	
	public static BufferedImage getImageFile()throws IOException, FileNotFoundException{
		Scanner s = new Scanner(System.in);
		//prompt for file input
		System.out.print("Enter image filename: ");
		File file = new File(s.next());
		//checks to make sure file exists
		while (!file.exists() || !file.canRead()){
			System.out.print("Invalid filename.  Enter image filename: ");
			file = new File(s.next());
		}
		
		//converts image into a bit file
		BufferedImage img = ImageIO.read(file);
		
		return img;
	}	

	public static int stealTheLastNumber(int x)throws IOException, FileNotFoundException{
		int integer = Math.abs(x % 2);
		return integer;				
	}
	
	
	public static char returnCharacter(int[] pixels)throws IOException, FileNotFoundException{
		char sum = 0;
		for (int i = 0; i < 8; i++){
			int bit = stealTheLastNumber(pixels[i]);
			int number = (bit * ((int)Math.pow(2, i)));
			sum += (bit * ((int)Math.pow(2,i)));
		}
		
		return sum;
	}
		
	public static String returnSecretMethod(int[] pixels, int width, int height)throws IOException, FileNotFoundException{
	int numberOfEightBitArrays = ((width * height)/ 8);
	String secretMessage = "";
			for (int i = 0; i < numberOfEightBitArrays; i++){
				int[] nextEight = new int[8];
				for (int j = 0; j < 8; j++){
					nextEight[j] = pixels[j + (8 * i)];
				}
				char character = returnCharacter(nextEight);
				secretMessage += character;
			}
	return secretMessage;
}  
	public static void createOutput(String secretMessage)throws IOException, FileNotFoundException{
	//prompt for file output
		Scanner s = new Scanner(System.in);
		System.out.print("Enter output image filename: ");
		String output = s.next();
		File file = new File(output);
		file.createNewFile();
		while (!file.exists() || !file.canWrite()){
			System.out.print("Invalid filename.  Enter output filename:");
			output = s.next();
			file = new File(output);
		}
		
		PrintStream answer = new PrintStream(file);
		answer.println(secretMessage);
	}
}