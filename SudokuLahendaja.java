import java.util.Arrays;

public class SudokuLahendaja {
    private Sudoku sudoku;

    public SudokuLahendaja(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public boolean kontroll(int[] kontrollitav) {
        Arrays.sort(kontrollitav);
        for (int i = 1; i < kontrollitav.length; i++) {
            if (kontrollitav[i] == kontrollitav[i - 1]) {
                if (kontrollitav[i] == 0) {
                    continue;
                }
                return false;
            }
        }
        return true;

    }

    public boolean kontrolli3x3() {
        for (int i = 0; i < 9; i++) {
            if (!(kontroll(sudoku.kolmXkolm(i)))) {
                return false;
            }
        }

        return true;
    }

    public boolean kontrolliVeerg() {
        for (int i = 0; i < 9; i++) {
            if (!(kontroll(sudoku.veerg(i)))) {
                return false;
            }
        }

        return true;
    }

    public boolean kontrolliRida() {
        for (int i = 0; i < 9; i++) {
            if (!(kontroll(sudoku.rida(i)))) {
                return false;
            }
        }

        return true;
    }

    public boolean kontrolliKõik() {
        for (int i = 0; i < 9; i++) {
            if (!(kontrolliRida() && kontrolliVeerg() && kontrolli3x3())) {
                return false;
            }
        }

        return true;
    }

    public boolean eksisteeribNulle() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getSudoku()[i][j] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public void lahenda() {
        int indeks = 0;

        if (!(kontrolliKõik() && !eksisteeribNulle())) {
            while (!(kontrolliKõik()) || eksisteeribNulle()) {
                int arvuIndeks = sudoku.getTühjadArvud()[indeks];

                if (sudoku.getSudoku()[arvuIndeks / 9][arvuIndeks % 9] == 9) {
                    sudoku.setSudoku(sudoku.getTühjadArvud()[indeks]);
                    indeks--;
                }

                sudoku.setSudoku(sudoku.getTühjadArvud()[indeks]);
                int praeguneArv = sudoku.getSudoku()[arvuIndeks / 9][arvuIndeks % 9];
                if (kontrolliKõik() && eksisteeribNulle()) {
                    indeks++;
                }
                else if (!kontrolliKõik()) {
                    if (praeguneArv >= 9) {
                        sudoku.setSudoku(sudoku.getTühjadArvud()[indeks]);
                        indeks--;
                    }
                }
            }
        }
    }
}
