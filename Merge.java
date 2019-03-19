import java.util.Arrays;
public class Merge{
    public static void mergesort(int[] data){
      int[] data21 = mergesort1(data);
      for(int i=0;i<data.length;i++)data[i]=data21[i];
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
     public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        mergesort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
