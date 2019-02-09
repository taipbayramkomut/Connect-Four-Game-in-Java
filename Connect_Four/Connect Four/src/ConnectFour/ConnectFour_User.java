package ConnectFour;

public class ConnectFour_User extends ConnectFourGame {

    public ConnectFour_User(){

    }

    public ConnectFour_User(int size,char type){
        super(size,type);
    }

    public void playGame(){
        playWithUser();
    }

    /**
     * It performs commands to play against the user
     */
    public void playWithUser(){
        int count=0;
        char gamer;
        Character input;
        int  row=0;
        int[] column={0};
        int status;
        int condition=0;
        int returnValue;
        do{
            do{
                status=0;
                System.out.print("Player" + (count%2)+1 + "= ");
                input=getInputs();
                if(legalPosition(input)==0){
                    status=1;
                    System.out.println("This column is full or invalid.");
                }
            }while(status==1);
            if(count%2==0)	gamer='X';		/* USER1	*/
            else			gamer='O';		/* USER2	*/
            column[0]=input-'a';
            row=assignToBoard(column,gamer);
            returnValue=gameStatus(row,column,gamer);
            if(returnValue==1 || returnValue==2)	condition=1;
            if(condition==0)	displayBoard();
            if(condition==1 && returnValue==1){
                if(count%2==0)
                    System.out.println("The player1 won the game." );
                else
                    System.out.println("The player2 won the game.");
            }
            else if(condition==1 && returnValue==2){
                System.out.println("The game ended in a draw.");
            }
            count++;
        }while(condition==0);
        displayBoard();
    }

}
