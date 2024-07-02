public class nTorres {
    //Atributos
    //----------------------------------------------------
    private int tablero[][];
    private int n;
    private int soluciones;
    //Fin atributos
    //----------------------------------------------------

    //Constructor
    //----------------------------------------------------
    public nTorres(int Torres){
        n = Torres;
        tablero = new int [Torres][Torres];
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

    //hDerecha
    //verifica si hay un uno en la fila a la derecha
    //-----------------------------------------------------------------
    public boolean hDerecha(int f, int c){ //recibe posicion de la matriz
         for(int i = c+1; i < n; i++){
            if( tablero[f][i] == 1){
                return true;
            }
         }   
         return false;        
    }
    //-----------------------------------------------------------------
    // Fin hDerecha

    //hIzquierda
    //verifica si hay un uno en la fila a la izquierda
    //-----------------------------------------------------------------
    public boolean hIzquierda(int f, int c){ //recibe posicion de la matriz
        for(int i = c-1; i >= 0; i--){
           if(tablero[f][i] == 1){
            return true;
           }   
        }//fin for 
        return false;          
   }
   //-----------------------------------------------------------------
   // Fin hDerecha

    //vArriba
    //verifica si hay un uno en la columna hacia arriba
    //-----------------------------------------------------------------
    public boolean vArriba(int f, int c){ //recibe posicion de la matriz
        for(int i = f-1; i >= 0; i--){
           if(tablero[i][c] == 1){
            return true;
           }
        }           
        return false;
   }
   //-----------------------------------------------------------------
   // Fin hDerecha

    //vArriba
    //verifica si hay un uno en la columna hacia abajo
    public boolean vAbajo(int f, int c){ //recibe posicion de la matriz
        for(int i = f+1; i < n; i++){
           if (tablero[i][c] == 1){
            return true;
           }
        }           
        return false;
   }
   // Fin hDerecha

   //Validar Posicion de Torre
    public boolean validarPosicion(int f, int c){
        if( hIzquierda(f, c) == true || hDerecha(f, c) == true || vAbajo(f, c) == true || vArriba(f, c) == true){
            return true;
        }else{
            return false; 
        }
    }
    //Fin validar Posicion
    //--------------------------------------------------------------

    //Colocar Reinas
    //Coloca las reinas en el tablero usando "BACKTRAKING"
    //_________________________________________________________________
    public void colocarPieza(int f, int Pcolocada){
        for(int i = f; i < n; i++){
            for (int j = 0 ; j < n ; j++){
                if (validarPosicion(i, j) == false){
                    tablero[i][j] = 1;
                    Pcolocada++;
                    if(Pcolocada == n){
                        soluciones++;
                        printMatriz();  
                    }else{
                        colocarPieza(i +1 , Pcolocada);
                    }
                    if(tablero [i][j] == 1){
                        tablero [i][j] = 0;
                        Pcolocada--;
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
