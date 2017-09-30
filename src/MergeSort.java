import java.lang.reflect.Array;
import java.lang.reflect.MalformedParametersException;

public class MergeSort {
    public static <T extends Comparable> T[] Sort(Class<T> theClass, T[] toSort){
        return null;
    }

    public static <T extends Comparable> T[] Merge(Class<T> theClass, T[] left, T[] right) throws MalformedParametersException{
        if(left == null || right == null){
            throw new MalformedParametersException();
        }

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
}
