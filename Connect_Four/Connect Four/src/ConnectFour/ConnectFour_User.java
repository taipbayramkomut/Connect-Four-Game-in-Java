package ConnectFour;
import javax.swing.*;

public class ConnectFour_User extends ConnectFourGame {

    public ConnectFour_User(){

    }

    public ConnectFour_User(int size,char type){
        super(size,type);
    }

    public void playGame(JPanel tag,JButton items[]){
        playWithUser(tag,items);
    }

    /**
     * It performs commands to play against the user
     */
    public void playWithUser(JPanel tag,JButton items[]){
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
                String player="Player " + ((count%2)+1) +"'s move";
                input=getInputs(player);
                if(legalPosition(input)==0){
                    status=1;
                    JOptionPane.showMessageDialog(null,"This column is full or invalid.","Warning!",JOptionPane.ERROR_MESSAGE);
                }
            }while(status==1);
            if(count%2==0)	gamer='X';		/* USER1	*/
            else			gamer='O';		/* USER2	*/
            column[0]=input-'a';
            row=assignToBoard(column,gamer);
            assignToGUI(tag,items,row,column[0],gamer);
            returnValue=gameStatus(row,column,gamer);
            if(returnValue==1 || returnValue==2)	condition=1;
            if(condition==0)	; //displayBoard();
            if(condition==1 && returnValue==1){
                if(count%2==0)
                    JOptionPane.showMessageDialog(null,"The player1 won the game.");
                else
                    JOptionPane.showMessageDialog(null,"The player2 won the game.");
            }
            else if(condition==1 && returnValue==2){
                JOptionPane.showMessageDialog(null,"The game ended in a draw.");
            }
            count++;
        }while(condition==0);
//        displayBoard();
    }

}
