/*/////////////////////////////////////////////////////////////////
//
// Autor: Luiz Fernando Galati                                                    
//                                                               
/////////////////////////////////////////////////////////////////*/


public class Estimate3D {

    /* Recebe um inteiro N, que representa o tamanho do sistema
    cúbico, um inteiro M e um real p. Gera M sistemas cúbicos
    aleatórios NxNxN. Em cada um deles, cada cubo unitário tem 
    probabilidade p de estar aberto.
       Devolve a fração dos sistemas que percolam.               */

    public static double eval (int N, double p, int M) {
        int count, k;
        boolean[][][] open;
        
        count = 0;
        for (k = 0; k < M; k++) {
            open = BooleanMatrix3D.random (N, p);
            if (Percolation3D.percola (open))
                count++;
        }
        return (double) count/M;
    }
    

    /* Método teste para a classe.                                */
    
    public static void main (String[] args) {
        int N, M;
        double p, q;       
        
        N = Integer.parseInt (args[0]);
        p = Double.parseDouble (args[1]);
        M = Integer.parseInt (args[2]);
        q = eval (N, p, M);
        StdOut.println (q);
    }
}
