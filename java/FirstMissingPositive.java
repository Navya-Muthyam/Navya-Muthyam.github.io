import java.util.Scanner;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = firstMissingPositive(nums);
        System.out.println("First missing positive number: " + result);

        scanner.close();
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean one = false;

        // Mark the elements which are out of range and check if 1 exists
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                one = true;
            if (nums[i] < 1 || nums[i] > n)
                nums[i] = 1;
        }
        
        if (!one) return 1;

        // Map the element with index: arr[element-1] = 0 - arr[element-1]
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]); // Making the value positive by abs() so that idx will be a positive one
            nums[idx - 1] = -Math.abs(nums[idx - 1]); // Making the element negative
        }

        // Check which number is not negative (i.e., positive), return its index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        
        return n + 1;
    }
}
