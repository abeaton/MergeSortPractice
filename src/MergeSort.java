import java.lang.reflect.Array;
import java.lang.reflect.MalformedParametersException;

public class MergeSort {
    public static <T extends Comparable> T[] Sort(Class<T> theClass, T[] toSort)
    {
        return null;
    }

    /**
     * Takes in two sorted arrays that implement comparable and returns the two arrays merged together in sorted order
     * @param theClass => utilized to be able to return an array of the generic type matching the left and right input
     * @param left => the left hand array (should be sorted)
     * @param right => the right hand array (should be sorted)
     * @param <T> => the generic type (
     * @return the left and right array merged in sorted order
     * @throws MalformedParametersException
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

    public static <T extends Comparable> void ThrowIfUnsorted(T[] theArray) throws MalformedParametersException
    {
        for(int i = 0; i < theArray.length - 1; i++){
            if(theArray[i].compareTo(theArray[i+1]) > 0){
                throw new MalformedParametersException();
            }
        }
    }
}
