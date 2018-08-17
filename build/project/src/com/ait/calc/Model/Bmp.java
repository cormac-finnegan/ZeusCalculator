package com.ait.calc.Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.image.DataBufferByte;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bmp {
	private static File bmpFile = new File("/test/bmp24Bit3.bmp"); 	//pointing to c:\test\monoBmp1.bmp
	private static BufferedImage bmpBufferedImage;
	private static final int N = 8;
	private static final int M = 20;								//total file pixel 160 * 160, so 20*20 blocks, each block 8*8 pixels, each pixel RGB 3 color in Byte [-128, 127]
	
	private static byte[] pixels;									//original pixels in R G B orders
	private static int[][][][] red 		= new int[M][M][N][N]; 		//original RGB array
	private static int[][][][] green 	= new int[M][M][N][N];
	private static int[][][][] blue 	= new int[M][M][N][N];	
	private static int[][][][] redD		= new int[M][M][N][N];		//decompressed RGB array
	private static int[][][][] greenD 	= new int[M][M][N][N];
	private static int[][][][] blueD 	= new int[M][M][N][N];	

	
	
	public static String start(){
		//if(bmpFile != null){System.out.println("not null file" + bmpFile.getAbsolutePath() + bmpFile.isFile());}
		try{
			bmpBufferedImage =  ImageIO.read(bmpFile);
		}catch(Exception e){
			System.out.println("NO FILE loaded !!!");
		}
		
		//https://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image
		//alpha for transparent, if it has alpha channel, need extra [Alpha, red, green, blue]
		if(bmpBufferedImage.getAlphaRaster() != null){
			System.out.println("image has alpha channel !!!");
		};
		
		//print width and height
		System.out.println(" height and width " + bmpBufferedImage.getHeight() + " width " +bmpBufferedImage.getWidth());
		
		pixels = ((DataBufferByte) bmpBufferedImage.getRaster().getDataBuffer()).getData();
		
		convertToRGBArray();
		convertToCompressedAndDecompressedArray();
		
		convertCompressedArrayToBMPFile();
		
		showImage();
		showDecompressedImage();
		
		//-----
		for(int i=0; i<20; i++){ 
		System.out.println("Enter row and column [0-19] to view original pixel value, and decompressed value: ");
		System.out.println("Enter row number: ");
		Scanner in = new Scanner(System.in);
		int row = 0;
		do {
	        while (!in.hasNextInt()){
	        	in.next();
	        } 
	        row = in.nextInt();
	    } while (row<0 || row>19);
		System.out.println("Enter column number: ");
		int column = 0;
		do {
	        while (!in.hasNextInt()){
	        	in.next();
	        } 
	        column = in.nextInt();
	    } while (column<0 || column>19);
		
		System.out.println("Value for Red of original BMP file");
		printArray(red[row][column]);		
		System.out.println("Value for Red of decompressed BMP file");
		printArray(redD[row][column]);
		System.out.println("Value for Green of original BMP file");
		printArray(green[row][column]);
		System.out.println("Value for Green of decompressed BMP file");
		printArray(greenD[row][column]);
		System.out.println("Value for Blue of original BMP file");
		printArray(blue[row][column]);
		System.out.println("Value for Blue of decompressed BMP file");
		printArray(blueD[row][column]);
		
		}
		//-----
		return null;
	}

	// show image from RGB pixels
	public static void showImage(){
		
		JFrame frame = new JFrame("BMP file");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		Dimension d = new Dimension(160,160);
		frame.getContentPane().setPreferredSize(d);
		
		BufferedImage img = new BufferedImage(M*8,M*8,BufferedImage.TYPE_INT_RGB);
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				for(int k=0; k<N; k++){
					for(int m=0; m<N; m++){
						//int rgb = 0Xff00ff;
						int rgb = 256*256*(red[i][j][k][m])+256*(green[i][j][k][m])+blue[i][j][k][m];
						img.setRGB(j*8+m,i*8+k,rgb);
				
						
					}
				}
			}
			
		}


		frame.getContentPane().add(new JLabel(new ImageIcon(img)));
		//frame.getContentPane().add(new JLabel(new ImageIcon(img2)));
		//frame.getContentPane().add(new JLabel(new ImageIcon(img3)));
		frame.pack();
		frame.setVisible(true);		
		
	}
	// show image from RGB pixels
		public static void showDecompressedImage(){
			
			JFrame frame = new JFrame("BMP file");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(new FlowLayout());
			Dimension d = new Dimension(160,160);
			frame.getContentPane().setPreferredSize(d);
			
			BufferedImage img = new BufferedImage(M*8,M*8,BufferedImage.TYPE_INT_RGB);
			for(int i=0; i<M; i++){
				for(int j=0; j<M; j++){
					for(int k=0; k<N; k++){
						for(int m=0; m<N; m++){
							//int rgb = 0Xff00ff;
							int rgb = 256*256*(redD[i][j][k][m])+256*(greenD[i][j][k][m])+blueD[i][j][k][m];
							img.setRGB(j*8+m,i*8+k,rgb);
					
							
						}
					}
				}
				
			}


			frame.getContentPane().add(new JLabel(new ImageIcon(img)));
			//frame.getContentPane().add(new JLabel(new ImageIcon(img2)));
			//frame.getContentPane().add(new JLabel(new ImageIcon(img3)));
			frame.pack();
			frame.setVisible(true);		
			
		}
	
	// from byte[RGB] to 3 arrays for RGB 
	public static void convertToRGBArray(){

		for(int i=0; i<20; i++){
			for(int j=0; j<20; j++){
				for(int k=0; k<8; k++){
					for(int m=0; m<8; m++){
						int index = (8*i+k)*480+24*j+m*3;
						blue[i][j][k][m] = (int)pixels[index];
						green[i][j][k][m] = (int)pixels[index+1];
						red[i][j][k][m] = (int)pixels[index+2];
					}
				}
			}
		}			
	}
	
	// compress each 8*8 array, and decompress them, 
	public static void convertToCompressedAndDecompressedArray(){
		System.out.println("Enter Quantization Level [1-99]: ");
		Scanner in = new Scanner(System.in);
		int qLevel = 0;
		do {
	        while (!in.hasNextInt()){
	        	in.next();
	        } 
	        qLevel = in.nextInt();
	    } while (qLevel<1 || qLevel>99);
		
		
		for(int i=0; i<20; i++){
			for(int j=0; j<20; j++){
				DctAndIdct.dct(red[i][j], qLevel);
				copyArray(DctAndIdct.Idct() , redD[i][j]);
				
				DctAndIdct.dct(green[i][j], qLevel);
				copyArray(DctAndIdct.Idct() , greenD[i][j]);
				
				DctAndIdct.dct(blue[i][j], qLevel);
				copyArray(DctAndIdct.Idct() , blueD[i][j]);				
			}
		}
		System.out.println("All pixel blocks have been compressed and decompressed. ");
		
	}
	
	//copy content from one array to another
	public static void copyArray(int[][] src, int[][] des){
		for(int i=0; i<src.length; i++){
			for(int j=0; j<src[i].length; j++){
				des[i][j] = src[i][j];
			}
		}
	}
	
	//print int array[][]
		public static void printArray(int[][] intArray){
			System.out.print("  --------------------------------------------------");
			for(int i=0; i<intArray.length; i++){			
				System.out.println();
				for(int j=0; j<intArray[i].length; j++){
					if(j==0 ){
						System.out.print(" | ");
					}
					System.out.print( String.format(" %4d ", intArray[i][j]) );
					if(j==intArray[i].length-1){
						System.out.print(" | ");
					}
				}
			}
			System.out.println();
			System.out.println("  --------------------------------------------------");
			System.out.println();
		}
		
	//convert RGB to bmp file
	public static void convertCompressedArrayToBMPFile(){
		
	}

}
