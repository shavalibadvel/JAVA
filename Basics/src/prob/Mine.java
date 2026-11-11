package prob;

public class Mine {
    static void main() {
        int n = 5;
        int size = 2 * n - 1;
        int mid = n - 1;
        int[][] arr = new int[size][size];
        int val = 1;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (Math.abs(i - mid) + Math.abs(j - mid) <= mid && (i + j) % 2 == mid % 2) {
                    arr[i][j] = val++;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] != 0) {
                    System.out.printf("%2d ", arr[i][j]);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        //
//        int[] nums={1,0,0,2,1,0,1,0,2,2,0,1,1};
//        int low=0,high=nums.length-1,mid=0;
//        while(mid<=high){
//            if(nums[mid]==0){
//                int temp=nums[low];
//                nums[low]=nums[mid];
//                nums[mid]=temp;
//                mid++;
//                low++;
//            }
//            else if(nums[mid]==1)mid++;
//            else {
//                int temp=nums[high];
//                nums[high]=nums[mid];
//                nums[mid]=temp;
//                high--;
//            }
//        }

//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
//
//        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int n=4;
//        for(int i=0;i<arr.length;i++){
//            for(int j=i;j<arr[i].length;j++){
//               int temp=arr[i][j];
//               arr[i][j]=arr[j][i];
//               arr[j][i]=temp;
//            }
//        }
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[i].length/2;j++){
//                int temp= arr[i][j];
//                arr[i][j]=arr[i][n-j-1];
//                arr[i][n-j-1]=temp;
//            }
//        }
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[i].length;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        int n=4;
//        int size=n*2-1;
//        for(int i=0;i<size;i++) {
//            for(int j=0;j<size;j++) {
//                int mod=Math.min(Math.min(size-i-1,i),Math.min(size-j-1,j));
//                System.out.print(n-mod+" ");
//            }
//            System.out.println();
//        }
    }
}
