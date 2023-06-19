public class teste {
    public static void main(String[] args) {
        int[] v = {1,4,0,4,2};
        int[] v2 = new int[v.length];
        int cont = 0;

        for(int i = 0; i <v.length; i++){
            if(v[i]!=0){
            v2[cont] = v[i];
            cont++;
            }
        }

        for(int i = 0; i<v2.length;i++){
            System.out.print(v2[i]+",");
        }
    }
}
