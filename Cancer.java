package cancerTS;

import java.util.Arrays;

public class Cancer {
    //Make Public Variables
    public static String grid[][];
    public static int blobSize;
    public static int blobCount;

    public static void main(String[] args) {
        //Create private variables
        int row, col;
        grid = new String[15][15];
        
        //Fill the array
        for(row = 0; row < 15; row++){
            for(col = 0; col < 15; col++){
                grid[row][col] = " ";
            }
        }
        
        //fill 40 random with -, the rest with +
        //use array.fill to fill it all with +
        for(String[] r : grid){
            Arrays.fill(r, "+");
        }
        
        for(int i = 0; i < 70; i++){
            row = (int)(Math.random() * 10 + 4);
            col = (int)(Math.random() * 10 + 4);
            grid[row][col] = "-";
        }
        //Display the current grid
        displayGrid();
        
        blobSize = 0;
        blobCount = 0;
        
        //Pick random place and remove blob
        //remove nothing if no blob is found
        int blobRow = (int)(Math.random() * 10 + 4);
        int blobCol = (int)(Math.random() * 10 + 4);
        floodFill(blobRow, blobCol);
        System.out.println("There were " + blobCount + " Cancerous Cells.");
        //Display new grid
        System.out.println("The new Grid is: ");
        displayGrid();
        
    
    }
    
    public static void floodFill(int row, int col){
        if(grid[row][col].equals("-")) {
            grid[row][col] = " ";
            blobSize++;
            floodFill(row - 1, col - 1);
            floodFill(row - 1, col);
            floodFill(row - 1, col + 1);
            floodFill(row, col - 1);
            floodFill(row, col + 1);
            floodFill(row + 1, col - 1);
            floodFill(row + 1, col);
            floodFill(row + 1, col + 1);
        }
    }
    
    public static void displayGrid() {
        String output = " 123456789012345\n";
        output += "0";
        for(int row = 0; row <= 14; row++){
            if ((row > 0) && (row < 15)){
                output += (row % 15);
            }
            for(int col = 0; col <= 14; col++){
                output += grid[row][col];
            }
            output += "\n";
        }
        System.out.println(output);
    }
    
}
