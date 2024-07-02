public class nCaballos {
    
    //Atributos
    //----------------------------------------------------
    private int tablero[][];
    private int n;
    private int soluciones;
    //Fin atributos
    //----------------------------------------------------

    //Constructor
    //----------------------------------------------------
    public nCaballos(int tam){
        n = tam;
        tablero = new int [tam][tam];
        inicializarMatriz();
        soluciones = 0;
    }
    //Fin constructor
    //----------------------------------------------------


    //Metodos
    //----------------------------------------------------
    
    //----------------Inicializar Matriz------------------
    public void inicializarMatriz(){
        for(int f = 0; f < n; f++){
            for(int c = 0; c < n; c++){
                tablero [f][c] = 0;
            }
        }
    } 
    //---------------- Fin inicializar Matriz-------------

    //------------------- imprimir matriz ----------------
    public void printMatriz(){
        for(int f = 0; f < n; f++){
            for(int c = 0; c < n; c++){
                System.out.print("|" + tablero [f][c]+"|");
            }
            System.out.println("");
        }
        System.out.println("");
    } 
    //---------------- Fin imprimir matriz ---------------

    public boolean validarPArriba(int f, int c){
        if((f -2)>=0 && (c-1) >= 0 && (c+1) < n){
            if(tablero[f -2][c-1] == 1 || tablero[f -2][c+1] == 1){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    public boolean validarPAbajo(int f, int c){
        if((f + 2)< n && (c-1) >= 0 && (c+1) <n){
            if(tablero[f + 2][c-1] == 1 || tablero[f + 2][c+1] == 1){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    public boolean validarPIzquierda(int f, int c){
        if((c -2) >= 0 && (f+1) < n && (f-1) >= 0 ){
            if(tablero[f+1][c-2] == 1 || tablero[f - 1][c -2] == 1){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    public boolean validarPDerecha(int f, int c){
        if((c + 2) < n && (f+1) < n && (f-1) >= 0 ){
            if(tablero[f+1][c+2] == 1 || tablero[f - 1][c+2] == 1){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    public boolean validarPosicion(int f, int c){
        if(validarPAbajo(f, c) == true && validarPArriba(f, c) == true && validarPDerecha(f, c) == true && validarPIzquierda(f, c) == true){
            return true;
        }else{
            return false; 
        }
    }

    public void colocarCaballo(int f, int Rcolocada){
        for(int i = f; i < n; i++){
            for (int j = 0 ; j < n ; j++){
                if (validarPosicion(i, j) == true){
                    tablero[i][j] = 1;
                    Rcolocada++;
                    if(Rcolocada == n){
                        soluciones++;
                        printMatriz();  
                    }else{
                        colocarCaballo(i +1 , Rcolocada);
                    }
                    if(tablero [i][j] == 1){
                        tablero [i][j] = 0;
                        Rcolocada--;
                    }
                }//If Validacion
            }//Fin for j
        }// Fin for 
    }
    //Fin Colocar Reinas
    //--------------------------------------------------------------

    public int returnSoluciones(){
        return soluciones;
    }
    //Fin metodos
    //----------------------------------------------------
}
