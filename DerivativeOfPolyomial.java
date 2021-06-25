

public class DerivativeOfPolyomial {

    public double[] findDerivative(double C[]) {
    double D[] = new double[C.length-1];
    for(int i = 0; i < C.length-1; i++)
    D[i] = C[i]*(C.length-i-1);
        return D;
    }

}