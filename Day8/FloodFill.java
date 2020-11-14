package day8;

/**
 * https://leetcode.com/problems/flood-fill/
 * @author amjain
 *
 */
public class FloodFill {

	public int[][] floodArray(int i,int j,int[][] image,int newColor,int currColor){
		if((i<image.length && j<image[0].length) && (i>=0 && j>=0)){
			if(image[i][j] != currColor) return image;
			if(image[i][j] == newColor) return image;
			image[i][j] = newColor;                
			image = floodArray(i+1,j,image,newColor,currColor);
			image = floodArray(i-1,j,image,newColor,currColor);
			image = floodArray(i,j+1,image,newColor,currColor);
			image = floodArray(i,j-1,image,newColor,currColor);
		}
		return image;

	}
	    
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		//x,y ==> starting positions
		//four directions : (x+1,y) (x-1,y) (x,y+1)(x,y-1)
		
		int currColor = image[sr][sc];
		image = floodArray(sr,sc,image,newColor,currColor);
		return image;
	}
	
	public static void main(String[] args) {
		FloodFill obj = new FloodFill();
		int[][] image = {{0,0,0},{0,0,0}};
		
		image = obj.floodFill(image, 0, 0, 2);
		
		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[0].length;j++) {
				System.out.print(image[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
