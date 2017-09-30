import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.MalformedParametersException;

public class MergeSortTest {

    @Test
    public void test_sort() {
    }

    @Test(expected = MalformedParametersException.class)
    public void test_merge_bothNull() {
        MergeSort.Merge(Integer.class, null, null);
    }

    @Test(expected = MalformedParametersException.class)
    public void test_merge_oneNull() {
        Integer[] right = { 1 };
        MergeSort.Merge(Integer.class, null, right);
    }

    @Test
    public void test_merge_bothEmpty() {
        Integer[] empty = {};
        MergeSort.Merge(Integer.class, empty, empty);
    }

    @Test
    public void test_merge_oneEmpty() {
        Integer[] empty = {};
        Integer[] right = { 1 };
        MergeSort.Merge(Integer.class, empty, right);
    }

    @Test
    public void test_merge_bothLengthOne() {
        Integer[] left = { 6 };
        Integer[] right = { 1 };
        Integer[] merged = MergeSort.Merge(Integer.class, left, right);

        Integer[] expected = {1, 6};
        Assert.assertArrayEquals(expected, merged);
    }

    @Test
    public void test_merge_bothLengthTwo() {
        Integer[] left = {3, 6};
        Integer[] right = {2, 4};
        Integer[] merged = MergeSort.Merge(Integer.class, left, right);

        Integer[] expected = {2, 3, 4, 6};
        Assert.assertArrayEquals(expected, merged);
    }

    @Test
    public void test_merge_bothLength5() {
        Integer[] left = { 2, 3, 5, 9, 15};
        Integer[] right = {4, 6, 10, 11, 19};
        Integer[] merged = MergeSort.Merge(Integer.class, left, right);

        Integer[] expected = {2, 3, 4, 5, 6, 9, 10, 11, 15, 19};
        Assert.assertArrayEquals(expected, merged);
    }

    @Test
    public void test_merge_useString() {
        String[] left = {"a", "j", "z"};
        String[] right = {"c", "h", "q", "r"};
        String[] merged = MergeSort.Merge(String.class, left, right);

        String[] expected = {"a", "c", "h", "j", "q", "r", "z"};
        Assert.assertArrayEquals(expected, merged);
    }

    @Test(expected = MalformedParametersException.class)
    public void test_throwIfUnsorted(){
        Integer[] unsorted = { 2, 5, 6, 9, 8};
        MergeSort.ThrowIfUnsorted(unsorted);
    }

    @Test(expected = MalformedParametersException.class)
    public void test_throwIfUnsorted_merge(){
        Integer[] unsorted = { 2, 5, 6, 9, 8};
        Integer[] empty = {};
        MergeSort.Merge(Integer.class, unsorted, empty);
    }
}