import javax.imageio.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;

public class ImageEncoder {
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
		
		int[] clearedImage = deleteTheLastNumber(pixels, w, h);
		
		File text = getTextFile();
		
		int[] code = changeTextIntoBinary(w, h, text);
		int [] newPicture = combinePictureAndMessage(code, clearedImage, w, h);
		
		//String secretMessage = returnSecretMethod(newPicture, w, h, code);
		
		//createOutput(secretMessage);
		rgbArray = newPicture;
		image.setRGB(startX, startY, w, h, rgbArray, offset, scansize);
		
		ImageIO.write(image, "png", text);
		BufferedImage norm = new BufferedImage(image.getWidth(), image.getHeight(),
                                       BufferedImage.TYPE_INT_ARGB);
		norm.getGraphics().drawImage(image, 0, 0, null);			
	}
	
	public static void printStatement()throws IOException, FileNotFoundException{ 
		System.out.println("This program reads in a text file and a png image");
		System.out.println("file and outputs a new image that is a cody of the");
		System.out.println("image as a png except with the text encoded in the");
		System.out.println("image's lower-order bits.");
	}
	
	public static File getTextFile()throws IOException, FileNotFoundException{
		Scanner s = new Scanner(System.in);
		//prompt for text file input
		System.out.print("Enter text file: ");
		File text = new File(s.next());
		return text;
	}

//check to make sure that the user hs entered the correct thing
	public static BufferedImage getImageFile()throws IOException, FileNotFoundException{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter image filename: ");
		File file = new File(s.next());
		while (!file.exists() || !file.canRead()){
			System.out.print("Invalid filename.  Enter image filename: ");
			s.next();
		}
		
		//converts image into a bit file
		BufferedImage img = ImageIO.read(file);
		
		return img;
	}	

	public static int[] deleteTheLastNumber(int[] x, int w, int h)throws IOException, FileNotFoundException{
		int[] clearedImage = new int[w * h];
		
		for(int i = 0; i < w * h; i++){
			x[i] = Math.abs(x[i] % 10);
			clearedImage[i] = Math.abs(x[i] * 10);
			//System.out.println(integer);
		}
		
		return clearedImage;				
	}
	
	
	public static char addCharacter(int[] clearedImage, int[] code)throws IOException, FileNotFoundException{
		char sum = 0;
		for (int i = 0; i < 8; i++){
			int[] updated = deleteTheLastNumber(clearedImage[]);
			System.out.println("bit: " + bit);
			int updatedPixel = (clearedPixel + code[i]); 
			System.out.println("number: " + number);
			sum += (bit * ((int)Math.pow(2,i)));
			System.out.println("****" + number);
			System.out.println( (int)sum);
		}
		
		return sum;
	}
	
	public static int[] changeTextIntoBinary(int w, int h, File text)throws IOException, FileNotFoundException{
		String file = "";
		Scanner s = new Scanner(text);
		while (s.hasNextLine()){
			String line = s.nextLine();
			file = file + line + " ";
		}
		
		int[] fileInBinary = new int[file.length()];
		
		for (int i = 0; i < file.length(); i++){
			int characterNumber = (int)file.charAt(i);
			int[] numberInBinary = new int[8];
			numberInBinary = charToBit(characterNumber);
			for (int j = 0; j < 8; j++){
				fileInBinary[(8*j) + i] = numberInBinary[i]; 
			}
		}
		
		return fileInBinary;	
	}
	
	public static int[] charToBit(int x){
		int[] binaryLetter = new int[8];
		int nextDigit = x;
		for (int j = 0; j < 8; j++){
			binaryLetter[j]=(nextDigit % 2);
			nextDigit = (nextDigit / 2);
		}
		return binaryLetter;
	}
	
	public static int[] combinePictureAndMessage(int[] message, int[] picture, int w, int h){
		int[] codedPicture = new int[w*h];
		for (int i = 0; i < w * h; i++){
			codedPicture[i] = message[i] + picture[i];
 		}
		
		return codedPicture;	
	}
			
	public static String returnSecretMethod(int[] clearedImage, int width, int height, int[] code)throws IOException, FileNotFoundException{
		int numberOfEightBitArrays = ((width * height)/ 8);
		String secretMessage = "";
				for (int i = 0; i < numberOfEightBitArrays; i++){
					int[] nextEight = new int[8];
					for (int j = 0; j < 8; j++){
						//nextEight[j] = pixels[j + (8 * i)];
					}
					char character = addCharacter(nextEight, code);
					secretMessage += character;
				}
		System.out.println(secretMessage);
		return secretMessage;
	}  
	
	public static void createOutput(String secretMessage)throws IOException, FileNotFoundException{
	//prompt for file output
		Scanner s = new Scanner(System.in);
		System.out.print("Enter output filename: ");
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