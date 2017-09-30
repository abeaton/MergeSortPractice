import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.MalformedParametersException;

public class MergeSortTest {

    @Test(expected = MalformedParametersException.class)
    public void test_sort_null() {
        MergeSort.Sort(Integer.class, null);
    }

    @Test
    public void test_sort_empty() {
        Integer[] empty = {};
        Integer[] sorted = MergeSort.Sort(Integer.class, empty);

        Assert.assertArrayEquals(empty, sorted);
    }

    @Test
    public void test_sort_single(){
        Integer[] toSort = { 5 };
        Integer[] sorted = MergeSort.Sort(Integer.class, toSort);

        Assert.assertArrayEquals(toSort, sorted);
    }

    @Test
    public void test_sort_two(){
        Integer[] toSort = { 5, 3 };
        Integer[] sorted = MergeSort.Sort(Integer.class, toSort);

        Integer[] expected = { 3, 5 };
        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    public void test_sort_three(){
        Integer[] toSort = { 5, 1, 3 };
        Integer[] sorted = MergeSort.Sort(Integer.class, toSort);

        Integer[] expected = { 1, 3, 5 };
        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    public void test_sort_even_length(){
        Integer[] toSort = { 4, 3, 19, 2, 14, 10, 18, 8, 6, 13 };
        Integer[] sorted = MergeSort.Sort(Integer.class, toSort);

        Integer[] expected = { 2, 3, 4, 6, 8, 10, 13, 14, 18, 19};
        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    public void test_sort_odd_length(){
        Integer[] toSort = { 15, 9, 4, 7, 5, 13, 18, 1, 6, 3, 2 };
        Integer[] sorted = MergeSort.Sort(Integer.class, toSort);

        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 9, 13, 15, 18};
        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    public void test_sort_duplicates() {
        Integer[] toSort = {2, 4, 3, 1, 4, 5, 2, 1, 3, 6};
        Integer[] sorted = MergeSort.Sort(Integer.class, toSort);

        Integer[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6};
        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    public void test_sort_string(){
        String[] toSort = { "d", "B", "q", "z", "A", "g", "r", "h", "a" };
        String[] sorted = MergeSort.Sort(String.class, toSort);

        String[] expected = { "A", "B", "a", "d", "g", "h", "q", "r", "z" };
        Assert.assertArrayEquals(expected, sorted);
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