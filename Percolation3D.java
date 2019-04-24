/*/////////////////////////////////////////////////////////////////
//
// Autor: Luiz Fernando Galati                                                    
//                                                               
/////////////////////////////////////////////////////////////////*/


public class Percolation3D {

    /* Recebe um sistema cúbico open, um sistema cúbico full e os
    inteiros i, j, k que representam um cubo unitário. Utilizando
    busca em profundidade, determina um conjunto de cubos unitários
    abertos e cheios a partir do cubo unitário representado por
    i, j, k, guardando o resultado em full.                      */

    public static void determinaCaminhos (boolean[][][] open, boolean[][][] full, int i, int j, int k) {
        int N;
        
        N = open.length;

        // Casos base da recursão
        if (i < 0 || i >= N)
            return;
        if (j < 0 || j >= N)
            return;
        if (k < 0 || k >= N)
            return;
        if (!open[i][j][k])
            return;
        if (full[i][j][k])
            return;

        full[i][j][k] = true;

        determinaCaminhos (open, full, i+1, j, k);
        determinaCaminhos (open, full, i-1, j, k);
        determinaCaminhos (open, full, i, j-1, k);
        determinaCaminhos (open, full, i, j+1, k);
        determinaCaminhos (open, full, i, j, k+1);
        determinaCaminhos (open, full, i, j, k-1);
    }


    /* Recebe um sistema cúbico open NxNxN com cubos aleatoriamente
    abertos. Devolve um sistema cúbico full NxNxN em que está 
    atribuído o valor true a todos os cubos unitários abertos 
    alcançáveis a partir de ao menos um dos cubos unitários do topo.
    Neste caso, dizemos que o cubo aberto está cheio.             */

    public static boolean[][][] todosCaminhos (boolean[][][] open) {
        int N, j, k;
        N = open.length;
        boolean[][][] full;
        
        full = new boolean[N][N][N];
        for (j = 0; j < N; j++) {
            for (k = 0; k < N; k++)
                determinaCaminhos (open, full, 0, j, k);
        }
        return full;
    }
    
   
    /* Recebe um cubo NxNxN. Devolve true se ele percola e false
    caso contrário.                                                */
    
    public static boolean percola (boolean[][][] open) {
        int N, j, k;                
        boolean[][][] full;
        
        N = open.length;
        full = todosCaminhos (open);
        for (j = 0; j < N; j++) {
            for (k = 0; k < N; k++) {
                if (full[N-1][j][k])
                    return true;
            }
        }
        return false;
    }
    
    
    /* Esta é a função principal do programa pedido. Recebe como
    entradas os valores de N (o tamanho do cubo), e M (o número de
    testes). Calcula a chance de percolação do sistema para vários
    valores de p (vacancy probability) e plota os resultados num
    gráfico.                                                       */
    
    public static void main (String[] args) {
        int N, M;
        
        N = Integer.parseInt (args[0]);
        M = Integer.parseInt (args[1]);
        StdDraw.setXscale (-0.01, 1.01);
        StdDraw.setYscale (-0.01, 1.01);
        PercPlot3D.curva (N, M, 0.0, 0.0, 1.0, 1.0);
    }
}
