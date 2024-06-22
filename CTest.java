public class CTest {
    public static void main(String args[]){
        int reinas = 4;
        int f = 0;
        int c = 0;
        int v = 1;

        if(reinas > 0 && f >= 0 && c >= 0){
        nReinas nR = new nReinas(reinas);
        
        nR.printMatriz();
        //nR.insertarInTo(0, 4, v);
        
        /*
        if(nR.validarPosicion(0, 0) == true){
            System.out.println("No se puede insertar en esta posicion");
        }else{
            System.out.println("Se puede insertar en esta posicion");
        }
        */

        nR.colocarReina(f, c);
        System.out.println("El numero de soluciones fue: " + nR.returnSoluciones());
        } // fin if validacion 
        else
        {
            System.out.println("Error: Hay datos no validos.");
            System.out.println("Verifica: Reinas > 0, el valor de posicion fila y columna tienen que ser >= 0");
        }

    }
}
