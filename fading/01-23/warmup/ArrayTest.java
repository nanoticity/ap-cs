public class ArrayTest {
	private int[] nums;
	
	public ArrayTest() {
	  nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
		  nums[i] = (int) (Math.random()  * (99 - 1) + 1);
		}
	}
	
	public String toString() {
  	String s = "";
  	for (int i = 0; i < nums.length; i++) {
      s += nums[i];
      if (i < nums.length - 1) {
        s += " ";
      }
		}
		return s;
	}
	
	public void sort() {
		int outerIndex, innerIndex, swapTemp;
		boolean swapped;
		for (outerIndex = 0; outerIndex < nums.length - 1; outerIndex++) {
			swapped = false;

			for (innerIndex = 0; innerIndex < nums.length - outerIndex - 1; innerIndex++) {

				if (nums[innerIndex] > nums[innerIndex + 1]) {
					swapTemp = nums[innerIndex];
					nums[innerIndex] = nums[innerIndex + 1];
					nums[innerIndex + 1] = swapTemp;
					swapped = true;
				}

			}

			if (!swapped)
				break;
		}
	}
}