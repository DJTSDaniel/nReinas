public class cCaballosm {
        // Atributos
    //----------------------------------------------------
    private int tablero[][];
    private int n;
    private int soluciones;
    // Fin atributos
    //----------------------------------------------------

    // Constructor
    //----------------------------------------------------
    public cCaballosm(int tam) {
        n = tam;
        tablero = new int[tam][tam];
        inicializarMatriz();
        soluciones = 0;
    }
    // Fin constructor
    //----------------------------------------------------

    // Metodos
    //----------------------------------------------------
    
    //---------------- Inicializar Matriz ------------------
    public void inicializarMatriz() {
        for (int f = 0; f < n; f++) {
            for (int c = 0; c < n; c++) {
                tablero[f][c] = 0;
            }
        }
    } 
    //---------------- Fin inicializar Matriz -------------

    //------------------- Imprimir matriz ----------------
    public void printMatriz() {
        for (int f = 0; f < n; f++) {
            for (int c = 0; c < n; c++) {
                System.out.print("|" + tablero[f][c] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    } 
    //---------------- Fin imprimir matriz ---------------

    // Validar movimientos del caballo en las cuatro direcciones
    public boolean validarPArriba(int f, int c) {
        if ((f - 2) >= 0 && (c - 1) >= 0 && (c + 1) < n) {
            return tablero[f - 2][c - 1] == 0 && tablero[f - 2][c + 1] == 0;
        }
        return true;
    }

    public boolean validarPAbajo(int f, int c) {
        if ((f + 2) < n && (c - 1) >= 0 && (c + 1) < n) {
            return tablero[f + 2][c - 1] == 0 && tablero[f + 2][c + 1] == 0;
        }
        return true;
    }

    public boolean validarPIzquierda(int f, int c) {
        if ((c - 2) >= 0 && (f + 1) < n && (f - 1) >= 0) {
            return tablero[f + 1][c - 2] == 0 && tablero[f - 1][c - 2] == 0;
        }
        return true;
    }

    public boolean validarPDerecha(int f, int c) {
        if ((c + 2) < n && (f + 1) < n && (f - 1) >= 0) {
            return tablero[f + 1][c + 2] == 0 && tablero[f - 1][c + 2] == 0;
        }
        return true;
    }

    public boolean validarPosicion(int f, int c) {
        return validarPArriba(f, c) && validarPAbajo(f, c) && validarPIzquierda(f, c) && validarPDerecha(f, c);
    }

    // Colocar caballos en el tablero usando backtracking
    public void colocarCaballo(int f, int Rcolocada) {
        if (Rcolocada == n) {
            soluciones++;
            printMatriz();
            return;
        }

        for (int i = f; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i][j] == 0 && validarPosicion(i, j)) {
                    tablero[i][j] = 1;
                    colocarCaballo(i + 1, Rcolocada + 1);
                    tablero[i][j] = 0;
                }
            }
        }
    }
    // Fin colocar caballos
    //----------------------------------------------------

    public int returnSoluciones() {
        return soluciones;
    }

    // Fin metodos
    //----------------------------------------------------
    
}
