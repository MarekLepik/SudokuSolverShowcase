import java.util.Arrays;

public class Sudoku {
    private int[][] sudoku;
    private int[] tühjadArvud;

    public Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
        tühjadArvud = looTühjadArvud();
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public int[] getTühjadArvud() {
        return tühjadArvud;
    }

    public void setSudoku(int i) {
        int j = i % 9;
        i = i / 9;

        if (sudoku[i][j] >= 9) {
            sudoku[i][j] = 0;
        }
        else {
            sudoku[i][j]++;
        }
    }

    public int[] looTühjadArvud() {
        int tühjadKokku = 0;
        int[] tühjadeIndeksid = new int[81];

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == 0) {
                    tühjadeIndeksid[tühjadKokku++] = i * 9 + j;
                }
            }
        }

        return Arrays.copyOfRange(tühjadeIndeksid, 0, tühjadKokku);
    }

    public int[] rida(int mitmes) {
        int[] isoleeritud = new int[9];
        int j = 0;
        if (mitmes == 0 || mitmes == 1 ||mitmes == 2){
            for (int i = 0; i < 3;i++) {
                if(mitmes == 0){
                    for (int k = 0; k < 3; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
                else if(mitmes ==1){
                    for (int k = 3; k < 6; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
                else if(mitmes==2){
                    for (int k = 6; k < 9; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
            }
            return isoleeritud;
        }
        if (mitmes == 3 || mitmes == 4 || mitmes == 5){
            for (int i = 3; i < 6;i++) {
                if(mitmes == 3){
                    for (int k = 0; k < 3; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
                else if(mitmes ==4){
                    for (int k = 3; k < 6; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
                else if(mitmes == 5){
                    for (int k = 6; k < 9; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
            }
            return isoleeritud;
        }
        if (mitmes == 6 || mitmes == 7 ||mitmes == 8){
            for (int i = 6; i < 9;i++) {
                if(mitmes == 6){
                    for (int k = 0; k < 3; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
                else if(mitmes ==7){
                    for (int k = 3; k < 6; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
                else if(mitmes==8){
                    for (int k = 6; k < 9; k++) {
                        isoleeritud[j]=sudoku[i][k];
                        j+= 1;
                    }
                }
            }
            return isoleeritud;
        }
        return null;
    }

    public int[] veerg(int mitmes) {
        int[] isoleeritud = new int[9];
        int j = 0;
        if (mitmes == 0 || mitmes == 1 || mitmes == 2) {
            for (int i = 0; i < 7; i+=3) {
                if (mitmes == 0) {
                    for (int k = 0; k < 7; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                } else if (mitmes == 1) {
                    for (int k = 1; k < 8; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                } else if (mitmes == 2) {
                    for (int k = 2; k < 9; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                }
            }
            return isoleeritud;
        }
        if (mitmes == 3 || mitmes == 4 || mitmes == 5) {
            for (int i = 1; i < 8; i+=3) {
                if (mitmes == 3) {
                    for (int k = 0; k < 7; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                } else if (mitmes == 4) {
                    for (int k = 1; k < 8; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                } else if (mitmes == 5) {
                    for (int k = 2; k < 9; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                }
            }
            return isoleeritud;
        }
        if (mitmes == 6 || mitmes == 7 || mitmes == 8) {
            for (int i = 2; i < 9; i+=3) {
                if (mitmes == 6) {
                    for (int k = 0; k < 7; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                } else if (mitmes == 7) {
                    for (int k = 1; k < 8; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                } else if (mitmes == 8) {
                    for (int k = 2; k < 9; k+=3) {
                        isoleeritud[j] = sudoku[i][k];
                        j += 1;
                    }
                }
            }
            return isoleeritud;
        }
        return null;
    }
    public int[] kolmXkolm(int mitmes){
        int[] isoleeritud = new int[9];
        int j = 0;
        for (int k = 0; k < 9; k++) {
            isoleeritud[j]=sudoku[mitmes][k];
            j+= 1;
        }
        return isoleeritud;
    }

    @Override
    public String toString() {
        StringBuilder SudokuString=new StringBuilder();
        SudokuString.append("\t\t\t==========Sudoku=========\n");
        for (int i = 0; i < 9; i++) {
            if(i%3==0 &&i!=0){
                SudokuString.append("------------------------------------------------------");
                SudokuString.append("\n");
            }
            int[] AjutineRida = rida(i);
            for (int j = 0; j < AjutineRida.length; j++) {
                if(j%3==0 && j!=0){
                    SudokuString.append("\t|");
                }
                SudokuString.append("\t");
                SudokuString.append(AjutineRida[j]);

            }
            SudokuString.append("\n");
        }
        SudokuString.append("\t\t\t=========================");
        return SudokuString.toString();
    }
}
