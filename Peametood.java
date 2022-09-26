import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Peametood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int SudokuNR = 0;
        while (SudokuNR < 1 || SudokuNR > 5) {
            try {
                System.out.println("Sisestage arv (1-5):");
                SudokuNR = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {
                //e.printStackTrace();
                continue;
            }
        }
        Sudoku sudoku = new Sudoku(failistLugemine("Sudokud.txt",SudokuNR-1));
        SudokuLahendaja sudokulahendaja = new SudokuLahendaja(sudoku);
        System.out.println(sudoku);
        sudokulahendaja.lahenda();
        System.out.println(sudoku);
    }
    private static int[][] failistLugemine(String fail, int SudokuNR){
        int[][] sudoku = new int[9][9];
        try {
            List<String> read = Files.readAllLines(Path.of(fail), StandardCharsets.UTF_8);
            String sudokuString = read.get(SudokuNR);
            int sudokuIndeks = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(String.valueOf(sudokuString.charAt(sudokuIndeks)));
                    sudokuIndeks++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sudoku;

    }
}
