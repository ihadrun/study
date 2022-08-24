package test;

class Main
{
    // Function to count the total number of strictly increasing subarrays in an array
    public static int getCount(int[] arr)
    {
        // stores the count of strictly increasing subarrays
        int count = 0;
 
        // consider all subarrays `arr[i, j]` starting from index `i`
        // and ending at index `j`
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                // if the previous element is not less than the current element,
                // then subarray `arr[i, j]` is not strictly increasing
                if (arr[i] == arr[j])
                {
                    // don't consider index from `j+1` onwards
                	 ++count;
                }
                else {break;}
 
                // if subarray `arr[i, j]` is strictly increasing,
                // increment the total count
               
            }
        }
 
        // return the count of strictly increasing subarrays
        return count;
    }
 
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int[] arr = { 6, 6, 2, 1, 1 };
 
        System.out.print("The total number of strictly increasing subarrays is " 
                                + (arr.length+getCount(arr)));
        
    }
}