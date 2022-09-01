/**
 A mian class of simple tictac game for 2 players mode
 @version 1.0
 @author Jihun Choi
 */
import java.util.Scanner;

public class tictac {

    public static void main(String[] args) {
        intro();
        String[][] newBox = boxGenerator();
        boxShower(newBox);

        System.out.println("player1 starts first\n");
        int player = 1;
        int winnerStatus= 2;
        boolean [] locationChecker = {false, false, false, false, false, false, false, false, false};

        while(winnerStatus ==2)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player " + player + "'s turn");
            System.out.print("Please choose where you want to place your symbol 1 ~ 9 : ");

            int location = sc.nextInt();

            while(locationChecker[location-1]==true)
            {
                System.out.println();
                System.out.print("Please choose open location to place your symbol 1 ~ 9 : ");
                location = sc.nextInt();
            }

            placeSymbol(newBox, player, locationChecker, location);

            boxShower(newBox);

            if (tieCheck(locationChecker)) break;

            //winner checker

            winnerStatus = winnerChecker(newBox, false, false);
            //0 -> winner1 is true
            //1 -> winner2 is winner
            //2 -> no winner

            if(winnerStatus==0)
                System.out.println("Player1 won!");
            else if(winnerStatus==1)
                System.out.println("Player2 won!");


            if(player ==1)
                player = 2;
            else
                player = 1;
        }




    }


    //method to check tie
    private static boolean tieCheck(boolean[] locationChecker) {
        if(locationChecker[0] == true && locationChecker[1] == true && locationChecker[2] == true && locationChecker[3] == true && locationChecker[4] == true &&
                locationChecker[5] == true && locationChecker[6] == true && locationChecker[7] == true && locationChecker[8] == true)
        {
            System.out.println("tie!");
            return true;
        }
        return false;
    }

    //method to place symbol
    private static void placeSymbol(String[][] newBox, int player, boolean[] locationChecker, int location) {
        if (location == 1 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[0][0] = "X";
            else
                newBox[0][0] = "O";
            locationChecker[0] = true;
        }
        else if (location == 2 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[0][1] = "X";
            else
                newBox[0][1] = "O";
            locationChecker[1] = true;
        }
        else if (location == 3 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[0][2] = "X";
            else
                newBox[0][2] = "O";
            locationChecker[2] = true;
        }
        else if (location == 4 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[1][0] = "X";
            else
                newBox[1][0] = "O";
            locationChecker[3] = true;
        }
        else if (location == 5 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[1][1] = "X";
            else
                newBox[1][1] = "O";
            locationChecker[4] = true;
        }
        else if (location == 6 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[1][2] = "X";
            else
                newBox[1][2] = "O";
            locationChecker[5] = true;

        }
        else if (location == 7 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[2][0] = "X";
            else
                newBox[2][0] = "O";
            locationChecker[6] = true;

        }
        else if (location == 8 && locationChecker[location -1] ==false)
        {
            if (player == 1)
                newBox[2][1] = "X";
            else
                newBox[2][1] = "O";
            locationChecker[7] = true;
        }
        else if (location == 9 && locationChecker[location -1] ==false)
        {
            if(player ==1)
                newBox[2][2] = "X";
            else
                newBox[2][2] = "O";
            locationChecker[8] = true;
        }
    }

    //method to figure out the winner
    private static int winnerChecker(String[][] newBox, boolean winner1, boolean winner2)
    {

        int set1;
        if(newBox[0][0]=="X" && newBox[0][1] == "X" && newBox[0][2] == "X")
        {
            winner1 = true;
        }
        else if(newBox[1][0]=="X" && newBox[1][1] == "X" && newBox[1][2] == "X")
        {
            winner1 = true;
        }
        else if(newBox[2][0]=="X" && newBox[2][1] == "X" && newBox[2][2] == "X")
        {
            winner1 = true;
        }
        else if(newBox[0][0]=="X" && newBox[1][0] == "X" && newBox[2][0] == "X")
        {
            winner1 = true;
        }
        else if(newBox[0][1]=="X" && newBox[1][1] == "X" && newBox[2][1] == "X")
        {
            winner1 = true;
        }
        else if(newBox[0][2]=="X" && newBox[1][2] == "X" && newBox[2][2] == "X")
        {
            winner1 = true;
        }
        else if(newBox[0][0]=="X" && newBox[1][1] == "X" && newBox[2][2] == "X")
        {
            winner1 = true;
        }
        else if(newBox[2][0]=="X" && newBox[1][1] == "X" && newBox[0][2] == "X")
        {
            winner1 = true;
        }


        if(newBox[0][0]=="O" && newBox[0][1] == "O" && newBox[0][2] == "O")
        {
            winner2 = true;
        }
        else if(newBox[1][0]=="O" && newBox[1][1] == "O" && newBox[1][2] == "O")
        {
            winner2 = true;
        }
        else if(newBox[2][0]=="O" && newBox[2][1] == "O" && newBox[2][2] == "O")
        {
            winner2 = true;
        }
        else if(newBox[0][0]=="O" && newBox[1][0] == "O" && newBox[2][0] == "O")
        {
            winner2 = true;
        }
        else if(newBox[0][1]=="O" && newBox[1][1] == "O" && newBox[2][1] == "O")
        {
            winner2 = true;
        }
        else if(newBox[0][2]=="O" && newBox[1][2] == "O" && newBox[2][2] == "O")
        {
            winner2 = true;
        }
        else if(newBox[0][0]=="O" && newBox[1][1] == "O" && newBox[2][2] == "O")
        {
            winner2 = true;
        }
        else if(newBox[2][0]=="O" && newBox[1][1] == "O" && newBox[0][2] == "O")
        {
            winner2 = true;
        }


        //0 -> winner1 is true
        //1 -> winner2 is winner
        //2 -> no winner
       if(winner1 ==true)
           set1 = 0;
       else if(winner2 ==true)
           set1 = 1;
       else
           set1 = 2;

        return set1;

    }


    //method to show what's inside the box
    private static void boxShower(String[][] newBOox) {
        System.out.println("current box's look: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(newBOox[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //method to generate new empty 3 x 3 matrix
    private static String[][] boxGenerator() {
        String [][] box = { {"1","2","3"},{"4","5","6"}, {"7","8","9"} };
        System.out.println();
        return box;
    }

    //method to get user names and show the symbol they will use
    private static void intro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is 2 player tic-tac game");
        System.out.print("Please enter User1 name: ");
        String name1  = sc.nextLine();
        System.out.print("Please enter User2 name: ");
        String name2 = sc.nextLine();
        System.out.println("-----------------------------------------------------");
        System.out.println("Player 1: " + name1 + " using X symbol");
        System.out.println("Player 2: " + name2 + " using O symbol");
    }



}
