import java.lang.reflect.Array;
import java.lang.reflect.MalformedParametersException;

public class MergeSort {
    /**
     * Implementation of Merge Sort algorithm
     * @param theClass => utilized to be able to return an array of the generic type matching the toSort input
     * @param toSort => the array of type comparable to sort using merge sort
     * @param <T> => Comparable
     * @return => a sorted array using merge sort
     * @throws MalformedParametersException => if the toSort input is null
     */
    public static <T extends Comparable> T[] Sort(Class<T> theClass, T[] toSort) throws MalformedParametersException {
        if (toSort == null) {
            throw new MalformedParametersException();
        }

        if (toSort.length == 0 || toSort.length == 1) {
            return toSort;
        }

        int leftSplitLength = toSort.length / 2;
        int rightSplitLength = toSort.length - leftSplitLength;
        T[] left = (T[]) Array.newInstance(theClass, leftSplitLength);
        T[] right = (T[]) Array.newInstance(theClass, rightSplitLength);
        System.arraycopy(toSort, 0, left, 0, leftSplitLength);
        System.arraycopy(toSort, leftSplitLength, right, 0, rightSplitLength);

        T[] leftSorted = MergeSort.Sort(theClass, left);
        T[] rightSorted = MergeSort.Sort(theClass, right);
        return Merge(theClass, leftSorted, rightSorted);
    }

    /**
     * Takes in two sorted arrays that implement comparable and returns the two arrays merged together in sorted order
     * @param theClass => utilized to be able to return an array of the generic type matching the left and right input
     * @param left => the left hand array (should be sorted)
     * @param right => the right hand array (should be sorted)
     * @param <T> => the generic type (
     * @return the left and right array merged in sorted order
     * @throws MalformedParametersException => if the left or right input is null
     */
    public static <T extends Comparable> T[] Merge(Class<T> theClass, T[] left, T[] right) throws MalformedParametersException
    {
        if(left == null || right == null){
            throw new MalformedParametersException();
        }

        ThrowIfUnsorted(left);
        ThrowIfUnsorted(right);

        int totalLength = left.length + right.length;
        int leftIndex = 0;
        int rightIndex = 0;

        T[] newArray = (T[]) Array.newInstance(theClass, totalLength);

        while(leftIndex + rightIndex < totalLength
                && leftIndex != left.length
                && rightIndex != right.length){

            T leftValue = left[leftIndex];
            T rightValue = right[rightIndex];
            if(leftValue.compareTo(rightValue) <= 0){
                newArray[leftIndex + rightIndex] = leftValue;
                leftIndex++;
            } else {
                newArray[leftIndex + rightIndex] = rightValue;
                rightIndex++;
            }
        }

        while(leftIndex < left.length){
            newArray[leftIndex + right.length] = left[leftIndex];
            leftIndex++;
        }

        while(rightIndex < right.length){
            newArray[left.length + rightIndex] = right[rightIndex];
            rightIndex++;
        }

        return newArray;
    }

    /**
     * Throws if the array provided as input is unsorted
     * @param theArray => The array we are ensuring is sorted
     * @param <T> => Comparable
     * @throws MalformedParametersException
     */
    public static <T extends Comparable> void ThrowIfUnsorted(T[] theArray) throws MalformedParametersException
    {
        for(int i = 0; i < theArray.length - 1; i++){
            if(theArray[i].compareTo(theArray[i+1]) > 0){
                throw new MalformedParametersException();
            }
        }
    }
}
