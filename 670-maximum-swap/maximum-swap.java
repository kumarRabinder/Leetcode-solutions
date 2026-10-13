class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        int[] last = new int[10];

        // Store the last occurrence of each digit

        for (int i = 0; i < arr.length; i++) {

            last[arr[i] - '0'] = i;

        }

        // Find the first position where we can improve the number

        for (int i = 0; i < arr.length; i++) {

            int current = arr[i] - '0';

            // Look for a bigger digit

            for (int d = 9; d > current; d--) {

                if (last[d] > i) {

                    char temp = arr[i];

                    arr[i] = arr[last[d]];

                    arr[last[d]] = temp;

                    return Integer.parseInt(new String(arr));

                }

            }

        }

        return num;
    }
}