import java.util.Arrays;
public class Merge{
    public static void mergesort(int[] data){
      data = mergesort1(data);
    }
    private static int[] mergesort1(int[] ary){
        if(ary.length==1)return ary;
        int[] ary1 = new int[ary.length/2];
        int[] ary2 = new int[ary.length-ary.length/2];
        for(int i = 0; i<ary1.length ; i++)ary1[i]=ary[i];
        for(int i = 0 ; i<ary2.length ; i++)ary2[i]=ary[i+ary1.length];
        return merge(ary1,ary2);
    }
    private static int[] merge(int[] ary1, int[] ary2){
        int[] aryA = mergesort1(ary1);
        int[] aryB = mergesort1(ary2);
        int[] aryC = new int[aryA.length+aryB.length];
        int iA=0;
        int iB=0;
        int iC=0;
        while(iC<aryC.length){
          if(iA<aryA.length&&iB<aryB.length){
            if(aryA[iA]<=aryB[iB]){
                aryC[iC]=aryA[iA];
                iA++;
                iC++;}
            else{
                aryC[iC]=aryB[iB];
                iB++;
                iC++;}}
            else if(iA<aryA.length){
              aryC[iC]=aryA[iA];
              iA++;
              iC++;
            }
            else if(iB<aryB.length){
              aryC[iC]=aryB[iB];
              iB++;
              iC++;}
        }
        return aryC;
        }
     public static void main(String []args){
        int[] test = new int[]{69,7,3,4,6,7,9,2,4,6,8,3,4,75,3,65,84,652};
        System.out.println("Here's the Initial Array \n"+ Arrays.toString(test));
        mergesort(test);
        System.out.println("Here's the Sorted Array \n"+ Arrays.toString(mergesort1(test)));
     }
}
