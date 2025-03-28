import java.util.Scanner;
public class TicTacToeGame{
	public static int wincheck(char[][]arr){
		int z = 0;
		// This checks the rows for a win
        //Horizontal Check
        for(int p = 0;p<3;p++){
            if(arr[p][0] == arr[p][1] && arr[p][0] == arr[p][2]){
                if (arr[p][0]=='x'){
                    z = 1;
                }
                if (arr[p][0]=='o'){
                    z = 2;
                }
            }
        }
        //Vertical Check
        for(int g = 0;g<3;g++){
            if(arr[0][g] == arr[1][g] && arr[0][g] == arr[2][g]){
                if (arr[0][g]=='x'){
                    z = 1;
                }
                if (arr[0][g]=='o'){
                    z = 2;
                }
            }
        }
        //DiagCHeck1
        if(arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]){
            if (arr[0][0]=='x'){
                z = 1;
            }
            if (arr[0][0]=='o'){
                z = 2;
            }
            }
        //diagCheck2
        if(arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0]){
            if (arr[0][2]=='x'){
                z = 1;
            }
            if (arr[0][2]=='o'){
                z = 2;
            }
        }
        
        
        return z;
	}
	public static void main(String[] args){
// This in array is drawing up the board lines. In (xstart, ystart, xend, yend) format
// Top-Left corner of app window is (0,0) / Bottom-Right corner of app window is (600, 600)
		int[][]boardLine = {{0,200,600,200},
							{0,400,600,400},
							{200,0,200,600},
							{400,0,400,600}};
// This sets up the array that will be used to set up the X/O grid. They are temporarily filled with hyphens until they are filled with x and o values.
		char [][]arr = new char[3][3];
		for (int i=0;i<arr.length;i++)
			for (int j=0;j<arr[i].length;j++)
				arr[i][j]='-';
String[][] spots = {{"top left", "top middle","top right"},
					{"middle left","the middle","middle right"},
					{"bottom left","bottom middle","bottom right"}};
Scanner read = new Scanner(System.in);
//menu 
System.out.println("Welcome to Tic-Tac-Toe?");
System.out.println("Would you like to play 1-player mode (1) or 2-player mode? (2)");
String kitaPlayers = read.nextLine();
int playrNum = 0;
switch (kitaPlayers){
	case "1":
		playrNum = 1;
	break;

	case "2":
		playrNum = 2;
	break;

	default: 
		System.out.println("There's been an error, please restart the code and be careful to write either 1 or 2");
	break;
}
//THIS PART IS WHERE THE POPUP BEGINS
TicTacToeBoard board = new TicTacToeBoard(620,720);
// This sets up the grid given the lines you provided above in the boardLine array
		board.defineBoard(boardLine);
// This will set your pictures to display for the x and o values. Make sure your names match exactly what you type in the parameters.
		board.setFiles("x.png","o.jpg");
// This sets up the spacing and place values for x and o
		board.setBoard(arr);
int game_continue = 1;
int turn_counter = 0;
int whose_turn = 0;
int mess_up = 0;
String choice1 = "dug";
while (game_continue == 1){
	if (playrNum == 1){

	}
	if (playrNum == 2){
        if (mess_up != 0){
            mess_up=0;
        }
		turn_counter++;
		if(turn_counter%2 == 1){
			whose_turn = 1;
		}
		else{
			whose_turn = 2;
		}
	}
	if(whose_turn == 1){
		System.out.println("Where would Player 1 like to place an X?");
	}
	if(whose_turn == 2){
		System.out.println("Where would Player 2 like to place an O?");
	}
		
		for(int i=0;i<spots.length;i++){
			for(int z=0;z<spots.length;z++){
			System.out.print(spots[i][z]+"\t\t");
			}
			System.out.println("");
		}
		
        while(mess_up==0){
            choice1 = read.nextLine();
            for(int i=0;i<spots.length;i++){
                for(int z=0;z<spots.length;z++){
                    if(choice1.equalsIgnoreCase(spots[i][z])){
                        mess_up++;
                    }
                }
                
            }
            if(mess_up==0){
                System.out.print("Sorry, you've probably made a typo, where would you  like to place your ");
                if(whose_turn == 1){
                    System.out.println("X?");
                }
                if(whose_turn == 2){
                    System.out.println("O?");
                }
            }
            
		
       
        }
		for(int i=0;i<spots.length;i++){
			for(int z=0;z<spots.length;z++){
				if(choice1.equalsIgnoreCase(spots[i][z])){
					if(whose_turn == 1){
					    arr[i][z]='x';
				    }
				if(whose_turn == 2){
					    arr[i][z] = 'o';
				    }
			}
		}
		
	}
	// This will refresh the board so that new elements will display.
	board.repaint();
	if (wincheck(arr)!=0){
		System.out.println("Someone won!");
		game_continue--;
	}
}


// This will refresh the board so that new elements will display.
		board.repaint();

	}
}