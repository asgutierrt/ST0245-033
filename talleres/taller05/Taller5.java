
package prueba;

import java.util.Arrays;

public class Taller5 {
    
    public static void insertion(int [] a){
        for (int i = 1; i < a.length; i++) {
            int auxiliar = a[i];
            int j = i-1;
            while(a[i]<a[j]){
                int temporal = a[j];
                a[j] =auxiliar;
                a[i] = temporal;
                i--;
                j--;
                if(j==-1)break;
                if(i==-1)break;
            }
            
        }
    }
            
}
