import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = "_________";
        boolean isValid = false;

        char[][] grid = new char[5][9];
        int pos = 0;
        int posX = 0;
        int posY = 0;
        boolean isFinished = false;
        boolean isXWins = false;
        boolean isOWins = false;
        int turn = 1;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || i == 4) {
                    grid[i][j] = '-';
                } else {
                    if (j % 2 == 0) {
                        if (j == 0 || j == grid[i].length - 1){
                            grid[i][j] = '|';
                        } else {
                            grid[i][j] = s1.charAt(pos);
                            pos++;
                        }
                    } else {
                        grid[i][j] = ' ';
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        while (!isFinished){
            switch (turn) {
                case 0:
                    do {
                        System.out.print("Enter the coordinates: ");
                        String coordX = scanner.next();
                        String coordY = scanner.next();
                        if ((coordX.charAt(0) >= 49 && coordX.charAt(0) <= 51) && (coordY.charAt(0) >= 49 && coordY.charAt(0) <= 51)) {
                            if (coordX.length() > 1) {
                                System.out.println("Coordinates should be from 1 to 3!");
                                isValid = false;
                            }
                            posX = coordX.charAt(0);
                            posY = coordY.charAt(0);
                            if (grid[posX -48][(posY -48)*2] == '_'){
                                grid[posX - 48][(posY - 48) * 2] = 'O';
                                isValid = true;
                                turn = 1;
                            } else {
                                System.out.println("This cell is occupied! Choose another one!");
                                isValid = false;
                            }
                        } else if ((coordX.charAt(0) == 48 || (coordX.charAt(0) > 51 && coordX.charAt(0) < 58)) || (coordY.charAt(0) == 48 || (coordY.charAt(0) > 51 && coordY.charAt(0) < 58))) {
                            System.out.println("Coordinates should be from 1 to 3!");
                            isValid = false;
                        } else {
                            System.out.println("You should enter numbers!");
                            isValid = false;
                        }
                    } while (!isValid);
                    break;
                case 1:
                    do {
                        System.out.print("Enter the coordinates: ");
                        String coordX = scanner.next();
                        String coordY = scanner.next();
                        if ((coordX.charAt(0) >= 49 && coordX.charAt(0) <= 51) && (coordY.charAt(0) >= 49 && coordY.charAt(0) <= 51)) {
                            if (coordX.length() > 1) {
                                System.out.println("Coordinates should be from 1 to 3!");
                                isValid = false;
                            }
                            posX = coordX.charAt(0);
                            posY = coordY.charAt(0);
                            if (grid[posX -48][(posY -48)*2] == '_'){
                                grid[posX - 48][(posY - 48) * 2] = 'X';
                                isValid = true;
                                turn = 0;
                            } else {
                                System.out.println("This cell is occupied! Choose another one!");
                                isValid = false;
                            }
                        } else if ((coordX.charAt(0) == 48 || (coordX.charAt(0) > 51 && coordX.charAt(0) < 58)) || (coordY.charAt(0) == 48 || (coordY.charAt(0) > 51 && coordY.charAt(0) < 58))) {
                            System.out.println("Coordinates should be from 1 to 3!");
                            isValid = false;
                        } else {
                            System.out.println("You should enter numbers!");
                            isValid = false;
                        }
                    } while (!isValid);
                    break;
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == '_') {
                    isFinished = false;
                }
            }

            if ((grid[1][2] + grid[1][4] + grid[1][6]) == 264) {
                isXWins = true;
                isFinished = true;
            } else if ((grid[2][2] + grid[2][4] + grid[2][6]) == 264) {
                isXWins = true;
                isFinished = true;
            } else if ((grid[3][2] + grid[3][4] + grid[3][6]) == 264) {
                isXWins = true;
                isFinished = true;
            } else if ((grid[1][2] + grid[2][2] + grid[3][2]) == 264) {
                isXWins = true;
                isFinished = true;
            } else if ((grid[1][4] + grid[2][4] + grid[3][4]) == 264) {
                isXWins = true;
                isFinished = true;
            } else if ((grid[1][6] + grid[2][6] + grid[3][6]) == 264) {
                isXWins = true;
                isFinished = true;
            } else if ((grid[1][2] + grid[2][4] + grid[3][6]) == 264) {
                isXWins = true;
                isFinished = true;
            } else if ((grid[3][2] + grid[2][4] + grid[1][6]) == 264) {
                isXWins = true;
                isFinished = true;
            }

            if ((grid[1][2] + grid[1][4] + grid[1][6]) == 237) {
                isOWins = true;
                isFinished = true;
            } else if ((grid[2][2] + grid[2][4] + grid[2][6]) == 237) {
                isOWins = true;
                isFinished = true;
            } else if ((grid[3][2] + grid[3][4] + grid[3][6]) == 237) {
                isOWins = true;
                isFinished = true;
            } else if ((grid[1][2] + grid[2][2] + grid[3][2]) == 237) {
                isOWins = true;
                isFinished = true;
            } else if ((grid[1][4] + grid[2][4] + grid[3][4]) == 237) {
                isOWins = true;
                isFinished = true;
            } else if ((grid[1][6] + grid[2][6] + grid[3][6]) == 237) {
                isOWins = true;
                isFinished = true;
            } else if ((grid[1][2] + grid[2][4] + grid[3][6]) == 237) {
                isOWins = true;
                isFinished = true;
            } else if ((grid[3][2] + grid[2][4] + grid[1][6]) == 237) {
                isOWins = true;
                isFinished = true;
            }
        }

        if (isXWins) {
            System.out.println("X wins");
        } else if (isOWins) {
            System.out.println("O wins");
        } else {
            System.out.println("Draw");
        }
    }
}
