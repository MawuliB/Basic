
import java.util.*;

public class Algorithm {

	public static int linearSearch(int[] array, int numsize, int key) {
		int i = 0;

		for (i = 0; i < numsize; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] array, int numsize, int key) {
		int mid = 0;
		int low = 0;
		int high = numsize - 1;

		while (high >= low) {
			mid = (high + low) / 2;
			if (array[mid] < key) {
				low = mid + 1;
			} else if (array[mid] > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void selection(int[] array, int numsize) {
		int i = 0;
		int j = 0;
		int indexSmallest = 0;
		int temp = 0; // temp available for swap

		for (i = 0; i < numsize - 1; ++i) {
			// finding index of smallest remaining element
			indexSmallest = i;
			for (j = i + 1; j < numsize; ++j) {
				if (array[j] < array[indexSmallest]) {
					indexSmallest = j;
				}
			}
			// swapping
			temp = array[i];
			array[i] = array[indexSmallest];
			array[indexSmallest] = temp;
		}
	}

	public static void insertion(int[] array, int numsize) {
		int i = 0;
		int j = 0;
		int temp = 0; // temp available for swap

		for (i = 0; i < numsize; ++i) {
			j = i;
			while (j > 0 && array[j] < array[j - 1]) {
				temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				--j;
			}
		}
	}

	public static int partition(int[] numbers, int lowIndex, int highIndex) {
		int midpoint = lowIndex + (highIndex - lowIndex) / 2;
		int pivot = numbers[midpoint];

		boolean done = false;
		while (!done) {
			while (numbers[lowIndex] < pivot) {
				lowIndex++;
			}

			while (pivot < numbers[highIndex]) {
				highIndex--;
			}

			if (lowIndex >= highIndex) {
				done = true;
			} else {
				int temp = numbers[lowIndex];
				numbers[lowIndex] = numbers[highIndex];
				numbers[highIndex] = temp;

				lowIndex++;
				highIndex--;
			}
		}
		return highIndex;
	}

	public static void quick(int[] numbers, int lowIndex, int highIndex) {
		if (lowIndex >= highIndex) {
			return;
		}

		int lowEndIndex = partition(numbers, lowIndex, highIndex);

		quick(numbers, lowIndex, lowEndIndex);
		quick(numbers, lowEndIndex + 1, highIndex);
	}

	/* Java program for Merge Sort */

	/*
	 * Merges two subarrays of arr[]. First subarray is arr[l..m] Second subarray is
	 * arr[m+1..r]
	 */
	public static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	/*
	 * Main function that sorts arr[l..r] using merge()
	 */
	public static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	// A utility function to get maximum value in arr[]
	public static int getMax(int[] arr, int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	/*
	 * A function to do counting sort of arr[] according to the digit represented by
	 * exp.
	 */
	public static void countSort(int[] arr, int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		/*
		 * Change count[i] so that count[i] now contains actual position of this digit
		 * in output[]
		 */
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		/*
		 * Copy the output array to arr[], so that arr[] now contains sorted numbers
		 * according to current digit
		 */
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	/*
	 * The main function to that sorts arr[] of size n using Radix Sort
	 */
	public static void radixsort(int[] arr, int n) {
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		/*
		 * Do counting sort for every digit. Note that instead of passing digit number,
		 * exp is passed. exp is 10^i where i is current digit number
		 */
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int ndata;
		int key;
		int numberSize;
		String ANSI_RESET = "\u001B[0m";
		String ANSI_YELLOW = "\u001B[33m";

		System.out.println(ANSI_YELLOW + "\t\tSEARCH AND SORT\n\n" + ANSI_RESET);

		System.out.print("Enter The Number Of Items In The List \n >> ");

		ndata = input.nextInt();

		int[] data = new int[ndata];
		for (int i = 0; i < ndata; i++) {
			System.out.print("Enter Number For Index " + i + ": ");
			data[i] = input.nextInt();
		}

		while (true) {
			try {
				System.out.print("\nEnter 1 to search or 2 to sort or 0 to quit \n >> ");
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.print("Enter the Search Key: ");
					key = input.nextInt();
					numberSize = data.length;
					System.out.println(
							"\nEnter the type of search you want to use\n 1 for linear search and \n 2 for binary search \n >> ");
					int type = input.nextInt();
					if (type == 1) {
						int result = linearSearch(data, numberSize, key);
						if (result == -1) {
							System.out.println("\nThe Searched key was not found :(");
						} else {
							System.out.println("\nThe Search key was found at index " + result + " :) \n\n");
						}
					} else if (type == 2) {
						int result = binarySearch(data, numberSize, key);
						if (result == -1) {
							System.out.println("\nThe Searched key was not found :(");
						} else {
							System.out.println("\nThe Search key was found at index " + result + " :) \n\n");
						}
					} else {
						System.out.println("Wrong Input. Try Again!");
					}
				} else if (choice == 2) {
					System.out.println(
							"Enter the type of sort you want to use\n 1 for Selection Sort \n 2 for Insertion Sort \n 3 for Quick Sort \n 4 for Merge Sort \n 5 for Radix Sort \n >> ");
					int type = input.nextInt();
					int nSize = data.length;
					if (type == 1) {
						selection(data, nSize);
					} else if (type == 2) {
						insertion(data, nSize);
					} else if (type == 3) {
						quick(data, 0, (nSize - 1));
					} else if (type == 4) {
						mergeSort(data, 0, (nSize - 1));
					} else if (type == 5) {
						radixsort(data, nSize);
					}
					System.out.println("Sorted list: " + Arrays.toString(data));
				} else if (choice == 0) {
					break;
				} else {
					System.out.println("Wrong Input. Try Again!");
				}
			} catch (InputMismatchException ex) {
				input.next();
				System.out.println("Wrong Input. Try Again!");
			}

		}

	}
}