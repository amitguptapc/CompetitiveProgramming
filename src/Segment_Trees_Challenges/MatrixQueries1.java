import java.util.Scanner;

public class MatrixQueries1 {
    private static int r;

    private static Matrix query(int s, int e, int qs, int qe, Matrix[] tree, int idx) {
        if (qs > e || s > qe)
            return new Matrix(1, 0, 0, 1);
        if (s >= qs && e <= qe)
            return tree[idx];
        int m = (s + e) / 2;
        Matrix l = query(s, m, qs, qe, tree, 2 * idx);
        Matrix r = query(m + 1, e, qs, qe, tree, 2 * idx + 1);
        return l.multiply(r);
    }

    private static void build(Matrix[] a, int s, int e, Matrix[] tree, int idx) {
        if (s == e) {
            tree[idx] = a[s];
            return;
        }
        int m = (s + e) / 2;
        build(a, s, m, tree, 2 * idx);
        build(a, m + 1, e, tree, 2 * idx + 1);
        tree[idx] = tree[2 * idx].multiply(tree[2 * idx + 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();
        Matrix[] a = new Matrix[n];
        for (int i = 0; i < n; i++)
            a[i] = new Matrix(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        Matrix[] tree = new Matrix[4 * n + 1];
        build(a, 0, n - 1, tree, 1);
        while (q-- > 0) {
            query(0, n - 1, sc.nextInt() - 1, sc.nextInt() - 1, tree, 1).printMatrix();
            System.out.println();
        }
    }

    static class Matrix {
        int a, b, c, d;

        Matrix(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        Matrix multiply(Matrix p) {
            int w = (((this.a * p.a) % r) + ((this.b * p.c) % r)) % r;
            int x = (((this.a * p.b) % r) + ((this.b * p.d) % r)) % r;
            int y = (((this.c * p.a) % r) + ((this.d * p.c) % r)) % r;
            int z = (((this.c * p.b) % r) + ((this.d * p.d) % r)) % r;
            return new Matrix(w, x, y, z);
        }

        void printMatrix() {
            System.out.println(this.a + " " + this.b + "\n" + this.c + " " + this.d);
        }
    }
}