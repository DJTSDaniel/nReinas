public class CTest {

    public static void main(String[] args) {
        int piezas = 3;
        int f = 0;
        int c = 0;
        int v = 1;

        if(piezas > 0 && f >= 0 && c >= 0){
            nReinas nR = new nReinas(piezas);
            nTorres nT = new nTorres(piezas);
            nAlfiles nA = new nAlfiles(piezas);
            nCaballos nC = new nCaballos(piezas);

            //nR.printMatriz();
            //nR.insertarInTo(0, 4, v);
            
            /*
            if(nR.validarPosicion(0, 0) == true){
                System.out.println("No se puede insertar en esta posicion");
            }else{
                System.out.println("Se puede insertar en esta posicion");
            }
            */

            //nReinas
            System.out.println("----Reinas----");
            nR.colocarReina(f, c);
            System.out.println("El numero de soluciones de Reinas fue: " + nR.returnSoluciones());
            //Fin nReinas

            //nTorres
            System.out.println("----Torres----");
            nT.colocarPieza(f, c);
            System.out.println("El numero de soluciones de Torres fue: " + nT.returnSoluciones());
            //Fin nTorres

            //nAlfiles
            System.out.println("----Alfiles----");
            nA.colocarAlfil(f, c);
            System.out.println("El numero de soluciones de Alfiles fue: " + nA.returnSoluciones());
            //fin nAlfiles

            //nCaballos
            System.out.println("----Caballos----");
            nC.colocarCaballo(f, c);
            System.out.println("El numero de soluciones de caballos fue: " + nC.returnSoluciones());
            System.out.println("----Fin Caballos----");
            //Fin nCaballos

            System.out.println("------------------------------------------------------------------");
            System.out.println("Resumen ");
            System.out.println("------------------------------------------------------------------");
            System.out.println("El numero de soluciones de Reinas fue: " + nR.returnSoluciones());
            System.out.println("El numero de soluciones de Torres fue: " + nT.returnSoluciones());
            System.out.println("El numero de soluciones de Alfiles fue: " + nA.returnSoluciones());
            System.out.println("El numero de soluciones de caballos fue: " + nC.returnSoluciones());

            } // fin if validacion numero de Piezas
            else
            {
                System.out.println("Error: Hay datos no validos.");
                System.out.println("Verifica: Reinas > 0, el valor de posicion fila y columna tienen que ser >= 0");
                
            }//Fin Else de Validar numero de Piezas

            /*
             * Comentarios:
             * Desde mi punto de vista la complejidad tempoaral del programa tendria que ser
             * N cuadrada ya que se usan dos ciclos for anidados tanto para imporimir como para 
             * ir moviendonos en la matriz
             */

    }
}