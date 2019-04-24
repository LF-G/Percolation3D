/*//////////////////////////////////////////////////////////////////
//
// Autor: Luiz Fernando Galati                                                    
//                                                               
//////////////////////////////////////////////////////////////////*/


public class PercPlot3D {

    /* Recebe um número inteiro N, que representa o tamanho de um
    sistema cúbico, um número inteiro M, que representa o número de
    testes que serão feitos para estimar probabilidades, e quatro
    números reais: x0, y0, x1 e y1. Desenha na tela um gráfico que
    especifica como a probabilidade de percolação do sistema varia 
    com o aumento da probabilidade de um cubo unitário estar aberto
    (vacancy probability).                                        */

    public static void curva (int N, int M, double x0, double y0, double x1, double y1) {
        double gap, err, xm, ym, fxm;
        
        gap = .01;
        err = .0025;        
        xm = (x0 + x1) / 2;
        ym = (y0 + y1) / 2; 
        fxm = Estimate3D.eval (N, xm, M);
        
        if (x1 - x0 < gap || Math.abs (ym - fxm) < err) {
            StdDraw.line (x0, y0, x1, y1);
            return;
        }
        curva (N, M, x0, y0, xm, fxm);
        StdDraw.filledCircle (xm, fxm, .005);
        curva (N, M, xm, fxm, x1, y1);
    }
    

    /* Método teste para a classe.                                */
    
    public static void main (String[] args) {
        int N, M; 
        
        N = Integer.parseInt (args[0]);
        M = Integer.parseInt (args[1]);
        StdDraw.setXscale (-0.01, 1.01);
        StdDraw.setYscale (-0.01, 1.01);
        PercPlot3D.curva (N, M, 0.0, 0.0, 1.0, 1.0);
    }
}
