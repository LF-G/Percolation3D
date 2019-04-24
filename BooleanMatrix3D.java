/*////////////////////////////////////////////////////////////////
//
// Autor: Luiz Fernando Galati                                                                                               
//                                                                                                                              
///////////////////////////////////////////////////////////////*/


public class BooleanMatrix3D {
    
    /* Lê um número inteiro N e em seguida N matrizes booleanas
    de tamanho NxN, que representam um sistema cúbico NxNxN.
    Retorna o sistema cúbico lido.                             */
     
    public static boolean[][][] readBoolean3D () {
        int N, i, j, k;
        N = StdIn.readInt ();
        boolean[][][] a = new boolean[N][N][N];
        
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                for (k = 0; k < N; k++) {
                    a[i][j][k] = StdIn.readBoolean();
                }
            }
        }
        return a;
    }
    
    
    /* Recebe o tamanho N do sistema de cubos unitários e um número
    real p. Retorna um vetor open de matrizes que representa o sistema.
    A cada um dos cubos unitários é atribuído true com probabilidade p.
    Neste caso, consideramos o cubo aberto. Caso contrário
    (open[i][j][k] == false), consideramos o cubo fechado.           */
    
    public static boolean[][][] random (int N, double p) {
        int i, j, k;
        boolean[][][] open;
        
        open = new boolean[N][N][N];
        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                for (k = 0; k < N; k++)
                    open[i][j][k] = StdRandom.bernoulli (p);
        return open;
    }
    
    
    /* Método teste para a classe.                                */
    
    public static void main (String args[]) {
        int N;
        double p;
        boolean[][][] sistema;
        
        N = Integer.parseInt (args[0]);
        p = Double.parseDouble (args[1]);   
        sistema = random (N, p);
        if (Percolation3D.percola (sistema))
            StdOut.printf ("Sistema percola.\n");
        else
            StdOut.printf ("Sistema não percola.\n");
    }
        
}
   
