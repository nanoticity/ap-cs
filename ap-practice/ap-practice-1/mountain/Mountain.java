public class Mountain
{
	/** @param array an array of positive integer values
	* @param stop the last index to check
	* Precondition: 0 <= stop < array.length
	* @return true if for each j such that 0 <= j < stop, array[j] < array[j + 1] ;
	* false otherwise
	*/
	public static boolean isIncreasing(int[] array, int stop)
	{
		for(int i=0; i < stop; i++)
		{
			if( array[i] > array[i+1] )
				return false;
		}
		return true;	
	}
	


	/** @param array an array of positive integer values
	* @param start the first index to check
	*Precondition: 0 <= start < array.length - 1
	*@return true if for each j such that start <= j < array.length - 1,
	*array[j] > array[j + 1];
	*false otherwise
	*/
	public static boolean isDecreasing(int[] array, int start)
	{
		for(int i=start; i < array.length-1; i++)
		{
			if( array[i] < array[i+1] )
				return false;
		}
		return true;	


	}
	


	/** @param array an array of positive integer values
	*Precondition: array.length > 0
	* @return the index of the first peak (local maximum) in the array, if it exists;
	*-1 otherwise
	*/
	public static int getPeakIndex(int[] array)
	{ 
		/* to be implemented in part (a) */
        for (int index = 1; index < array.length - 1; index++) {
            if ((array[index - 1] < array[index]) && (array[index + 1] < array[index])) {
                return index;
            }
        }
        return -1;
	}
	
	
	/** @param array an array of positive integer values
	*Precondition: array.length > 0
	* @return true if array contains values ordered as a mountain;
	*false otherwise
	*/
	public static boolean isMountain(int[] array)
	{
		/* to be implemented in part (b) */
		int peak = getPeakIndex(array);
		if (peak == -1 || peak == 0 || peak == array.length - 1) {
			return false;
		}

		for (int i = 1; i <= peak; i++) {
			if (array[i - 1] >= array[i]) {
				return false;
			}
		}

		for (int i = peak + 1; i < array.length; i++) {
			if (array[i - 1] <= array[i]) {
				return false;
			}
		}

		return true;
	}
	
	// There may be instance variables, constructors, and methods that are not shown.
}
