import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        char player = 'X';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameover){
            printBoard(board);
            System.out.print(" Player " + player + " Enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' '){
                board[row][col] = player;
                gameover = haveWon(board, player);
                if(gameover){
                    System.out.print(" ");
                }
                else {
                    if(player == 'X'){
                        player = 'O';
                    }else {
                        player = 'X';
                    }
                }
            }
            else {
                System.out.println("Not a Valid Move. Try Again ! ");
            }
        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {

        //checking for the row

        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                System.out.print(" ");
                System.out.println("Player " + player + " has won the game ");
                System.out.print(" ");
                return true;
            }
        }

        //checking for the columns

        for (int col = 0; col < board[1].length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                System.out.print(" ");
                System.out.println("Player " + player + " has won the game ");
                System.out.print(" ");

                return true;
            }
        }

        // Checking for the diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            System.out.print(" ");
            System.out.println("Player " + player + " has won the game ");
            System.out.print(" ");

            return true;
        }

        if (board[0][2]  == player && board[1][1] == player && board[2][0] == player){
            System.out.print(" ");
            System.out.println("Player " + player + " has won the game ");
            System.out.print(" ");
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] +" | ");
            }
            System.out.println();
        }

    }
}