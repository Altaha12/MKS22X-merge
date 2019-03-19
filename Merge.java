import java.util.Arrays;
public class Merge{
    public static int[] mergesort(int[] ary){
        if(ary.length==1)return ary;
        int[] ary1 = new int[ary.length/2];
        int[] ary2 = new int[ary.length-ary.length/2];
        for(int i = 0; i<ary1.length ; i++)ary1[i]=ary[i];
        for(int i = 0 ; i<ary2.length ; i++)ary2[i]=ary[i+ary1.length];
        return merge(ary1,ary2);
    }
    public static int[] merge(int[] ary1, int[] ary2){
        int[] aryA = mergesort(ary1);
        int[] aryB = mergesort(ary2);
        int[] aryC = new int[aryA.length+aryB.length];
        int iA=0;
        int iB=0;
        int iC=0;
        while(iA<aryA.length && iB<aryB.length){
            if(aryA[iA]<=aryB[iB]){
                aryC[iC]=aryA[iA];
                iA++;
                iC++;}
            else{
                aryC[iC]=aryB[iB];
                iB++;
                iC++;}
            }
        return aryC;
        }
     public static void main(String []args){
        int[] test = new int[]{69,7,3,4,6,7,9,2,4,6,8,3,4,75,3,65,84,652};
        int[] sorted = mergesort(test);
        System.out.println("Here's the Initial Array \n"+ Arrays.toString(test));
        System.out.println("Here's the Sorted Array \n"+ Arrays.toString(sorted));
     }
}
