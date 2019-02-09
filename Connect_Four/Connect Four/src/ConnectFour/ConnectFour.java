package ConnectFour;
import java.util.Scanner;

public class ConnectFour {

    private int size;
    private char game_type;

    public int getterSize(){
        return size;
    }

    public char getterGame(){
        return game_type;
    }

    /**
     * The function to start the game. The game type is selected here.
     */
    public void startingToGame()throws Exception{
        int status;
        int sizeOfBoard;

        System.out.println("Please you enter size of the board to will be created.");
        System.out.println("Hint: Size can be an even number from 4 to 20.");
        Scanner input=new Scanner(System.in);
        do {
            status = 0;
            sizeOfBoard=input.nextInt();
            if(sizeOfBoard<4 || sizeOfBoard>20 || sizeOfBoard%2==1){
                status=1;
                System.out.println("The board size can be an even number from 4 to 20.");
            }
        }while(status==1);
        size=sizeOfBoard;
    }

    /**
     * 	Is the game against the computer or against an user?
     */
    public void typeOfGame(){
        char type;
        int status;

        System.out.println("Which game type will you play?");
        System.out.println("Press C to play against a computer.");
        System.out.println("Press P to play against a player2.");
        Scanner input=new Scanner(System.in);

        do {
            status = 0;
            type = input.next().charAt(0);
            if ((type != 'C' && type != 'c') && (type != 'P' && type != 'p')) {
                status = 1;
                System.out.println("Game type can be C or P");
            }
        } while (status == 1);
        game_type=type;
    }

    public static void main(String args[]){
        ConnectFour game=new ConnectFour();
        int status;
        do {
            status=0;
            try {
                game.startingToGame();
                game.typeOfGame();
                char type = game.getterGame();
                int size = game.getterSize();
                if (type == 'C' || type == 'c') {
                    ConnectFourGame game1 = new ConnectFour_AI(size, type);
                    game1.playGame();
                } else {
                    ConnectFourGame game1 = new ConnectFour_User(size, type);
                    game1.playGame();
                }
            } catch (Exception e) {
                System.out.println("Board size can be a number");
                status=1;
            }
        }while(status==1);
    }
}
