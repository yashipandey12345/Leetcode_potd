class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int titu[]= new int[arr.length];
       for(int i=0;i<arr.length;i++){
        titu[i]=arr[i];
       }
       Arrays.sort(titu);
       HashMap<Integer,Integer>hm= new HashMap<>();
       int count=1;
       for(int i=0;i<titu.length;i++){
        if(!hm.containsKey(titu[i])){
            hm.put(titu[i],count);
            count++;
        }
       }

       int[] rank= new int[arr.length];
       int index=0;
       for (int i = 0; i < arr.length; i++) {
            rank[i] = hm.get(arr[i]);
        }

        return rank;
    }
}
