package ConnectFour;
import javax.swing.*;

public class ConnectFour extends JFrame {

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

        JOptionPane.showMessageDialog(null,"Please you enter size of the board to will be created.\nHint: Size can be an even number from 4 to 20.");
        do {
            status = 0;
            String size=JOptionPane.showInputDialog("Please enter size of board:");
            sizeOfBoard=Integer.parseInt(size);
            if(sizeOfBoard<4 || sizeOfBoard>20 || sizeOfBoard%2==1){
                status=1;
                JOptionPane.showMessageDialog(null,"The board size can be an even number from 4 to 20.","Invalid size number.",JOptionPane.ERROR_MESSAGE);
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

        do {
            status = 0;
            String typeOption=JOptionPane.showInputDialog("Which game type will you play?\nPress C to play against a computer.\nPress P to play against a player2.");
            type=typeOption.charAt(0);
            if ((type != 'C' && type != 'c') && (type != 'P' && type != 'p')) {
                status = 1;
                JOptionPane.showMessageDialog(null,"Game type can be C or P","Invalid game type",JOptionPane.ERROR_MESSAGE);
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
                    GuiGame guigame = new GuiGame(game1,size);
                } else {
                    ConnectFourGame game1 = new ConnectFour_User(size, type);
                    GuiGame guigame = new GuiGame(game1,size);
                }
            } catch (Exception e) {
                System.out.println("Board size can be a number");
                status=1;
            }
        }while(status==1);
    }
}
