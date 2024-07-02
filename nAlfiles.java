public class nAlfiles {
         //Atributos
    //----------------------------------------------------
    private int tablero[][];
    private int n;
    private int soluciones;
    //Fin atributos
    //----------------------------------------------------

    //Constructor
    //----------------------------------------------------
    public nAlfiles(int alfiles){
        n = alfiles;
        tablero = new int [alfiles][alfiles];
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

    //diAbajo
    //verifica si hay un uno diagonal izquierda hacia abaho
    public boolean diAbajo(int f, int c){ //recibe posicion de la matriz
        for(int i = f+1, j = c-1; i < n && j >= 0; i++, j--){
           if(tablero[i][j] == 1){
                return true;
           }
        }           
        return false;
   }
   // Fin diAbajo

    //diArriba
    //verifica si hay un uno diagonal izquierda hacia abaho
    public boolean diArriba(int f, int c){ //recibe posicion de la matriz
        for(int i = f-1, j = c-1; i >= 0 && j>=0; i--, j--){
           if(tablero[i][j] == 1){
            return true;
           }
        }   
        return false;        
   }
   // Fin diArriba

   //Diagonal Derecha Arriba
   public boolean ddArriba(int f, int c){ //recibe posicion de la matriz
    for(int i = f-1, j = c+1; i >= 0 && j<n; i--, j++){
            if(tablero[i][j] ==1){
                return true;
            }
        }  
        return false;          
    }
    // Fin ddArriba

    //Diagonal derecja abajo
    public boolean ddAbajo(int f, int c){ //recibe posicion de la matriz
        for(int i = f+1, j = c+1; i <n && j<n; i++, j++){
                if(tablero[i][j] == 1){
                    return true;
                }
        }        
        return false;    
    }
        // Fin ddAbajo


    // -----------------Insertar en una posicion-------------------
    public void insertarInTo(int f, int c, int e){
        tablero [f][c] = e;
    }
    //---------------Fin Insertar en una posicion------------------

    // Validar Posicion
    // Valida si en la posicion no hay otra reina que pueda atacar
    //---------------------------------------------------------------
    public boolean validarPosicion(int f, int c){
        if( diAbajo(f, c) == true || diArriba(f, c) == true || ddArriba(f, c) == true || ddAbajo(f, c) == true){
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
    public void colocarAlfil(int f, int pColocada){
        for(int i = f; i < n; i++){
            for (int j = 0 ; j < n ; j++){
                if (validarPosicion(i, j) == false){
                    tablero[i][j] = 1;
                    pColocada++;
                    if(pColocada == n){
                        soluciones++;
                        printMatriz();  
                    }else{
                        colocarAlfil(i +1 , pColocada);
                    }
                    if(tablero [i][j] == 1){
                        tablero [i][j] = 0;
                        pColocada--;
                    }
                }//If Validacion
            }//Fin for j
        }// Fin for 
    }
    //Fin Colocar Alfiles
    //--------------------------------------------------------------


    public int returnSoluciones(){
        return soluciones;
    }
    //Fin metodos
    //----------------------------------------------------
    
}
