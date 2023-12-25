package dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysManagement {
	
	public static void main(String [] args) {
		int n=657;
		int[] a = {659,448,367,17,736,226,395,690,845,859,499,767,687,441,445,216,671,818,150,116,173,846,338,912,205,929,70,337,337,597,65,342,615,440,418,729,708,330,286,704,401,10,433,63,365,745,391,784,716,431,211,254,39,996,904,526,483,210,263,374,998,777,360,707,447,323,91,382,206,666,201,326,484,990,335,388,468,867,156,315,234,778,75,351,82,519,251,879,212,644,396,926,575,787,148,566,868,761,892,654,613,202,125,870,117,847,950,311,321,479,986,185,56,557,382,983,767,142,153,70,919,230,663,534,931,140,391,768,829,714,59,249,9,657,855,285,404,997,454,120,718,629,554,641,558,527,739,984,20,41,970,369,749,802,294,305,18,258,399,496,899,511,337,128,402,433,850,165,226,457,831,126,378,422,580,107,964,815,260,207,700,608,488,224,389,487,490,525,789,854,373,111,652,542,205,811,497,913,685,510,542,769,265,434,181,104,208,417,507,615,791,303,820,219,74,420,535,316,419,346,587,16,864,917,746,800,881,305,157,161,287,960,857,382,443,171,936,676,934,504,962,950,916,406,94,162,215,453,500,851,521,873,685,353,546,785,381,878,315,410,175,761,937,562,753,41,559,490,146,50,605,251,722,676,493,748,161,477,520,690,603,19,740,538,817,151,977,531,67,662,500,952,502,442,571,4,56,320,3,798,12,427,958,639,186,785,345,978,589,652,949,372,244,580,987,260,881,683,534,380,630,410,92,776,90,682,477,615,974,397,975,296,588,613,313,367,66,29,263,376,107,392,350,914,135,894,680,984,165,902,785,428,670,208,323,757,747,410,527,131,721,46,109,208,468,242,182,697,386,64,80,173,674,79,458,909,765,850,201,213,187,511,346,178,865,210,88,21,746,3,16,463,827,341,76,13,99,553,589,606,483,74,364,393,107,618,58,285,701,6,207,172,397,125,488,543,209,935,324,720,518,587,58,860,132,489,747,983,858,73,749,941,468,612,115,86,220,594,127,145,288,915,89,412,635,114,837,307,701,734,704,567,959,203,419,281,18,762,267,879,352,244,231,958,766,60,676,90,455,501,687,537,948,801,977,206,203,525,135,197,958,489,634,762,126,876,451,559,415,727,748,557,813,489,724,555,647,171,289,733,484,893,954,79,187,185,733,154,567,157,15,277,371,751,258,296,234,845,164,397,98,90,574,57,938,448,497,265,393,458,232,672,601,464,962,328,981,881,726,575,118,492,925,324,108,368,226,418,963,565,149,444,620,154,96,513,350,209,481,803,596,567,522,746,336,128,861,255,688,147,60,117,713,457,736,450,954,252,688,167,386,174,117,220,75,751,403,552,65,76,187,519,926,748,679,429,376,780,693,697,446,461,343,382,831,732,674,246,699,683,998,840,806,559,669,652,874,82,624,820,99,801,550,637,65,544,190,374,802,532,848,905,935,209,919,831,184,909,777,873,449,773,778,756,151,520,757,77,502,177,85,989,325,120,787,790,541};
		int k=18;
		//countSpecials(a,n,k);
		//printArray(removeEvenIntegers(a));
		//reverseArray(a, 0, a.length-1);
//		findMinValue(a);
		//removeZerosToEnd();
		System.out.println("aabaa is " + isPalindrome("aabaa"));
		System.out.println("madam is " + isPalindrome("madam"));
		System.out.println("aaabaa is " + isPalindrome("aaabaa"));
	}
	
	static void countSpecials(int a[], int n, int k){
        
		int f = (int)Math.floor(n/k);
        
        Map<Integer,Integer> countMap = 
            new HashMap<Integer,Integer>();
        
        for (int i=0;i<n;i++) {
            incrementCount(countMap, a[i]);
        }
        
        int matchingItems = 0;
        for(Integer item: countMap.keySet()) {
            if (countMap.get(item).intValue() == f) {
                matchingItems++;
            }
        }
        System.out.print(matchingItems);
    }
    
    
    static void incrementCount(Map<Integer,Integer> countMap, int value) {
        Integer count = countMap.get(value);
        if (count!=null) {
            countMap.put(value, count+1);
        } else {
            countMap.put(value, 1);
        }
        
    }
    
    public static int [] removeEvenIntegers(int [] arr) {
    	List<Integer> intArrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
    	List<Integer> intNewList = intArrList.stream().filter(a -> a % 2 ==0).collect(Collectors.toList());
    	return intNewList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void printArray(int [] arr) {
        //Arrays.stream(arr).forEach(System.out::println);
    	for (int i=0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
    
    public static void reverse(int [] myArray) { 
        Collections.reverse(Arrays.asList(myArray)); 
        printArray(myArray); 
    } 
    
    public static void reverseArray(int [] a) {
    	int[] b = IntStream.rangeClosed(1, a.length).map(i -> a[a.length-i]).toArray();
    	printArray(b);
    }
    
    public static void reverseArray(int [] a, int start, int end) {
    	
    	while(start<end) {
    		int temp = a[start];
    		a[start] = a[end];
    		a[end]   = temp;
    		start++;
    		end--;
    	}
    	
    	printArray(a);
    }

    public static void findMinValue(int [] a) {
    	System.out.println(Arrays.stream(a).min().getAsInt());
    }
    
    public static void findSecondMax(int [] a) {
    	int max = Integer.MIN_VALUE;
    	int secondMax = Integer.MIN_VALUE;
    	
    	for (int i=0; i< a.length; i++) {
    		if (a[i]>max) {
    		  max = a[i];
    		}
    		if (a[i]<max && a[i]>secondMax) {
    			secondMax = a[i];
    		}
    	}
    	System.out.println(max);
    }
    
    public static void removeZerosToEnd() {
    	// one pointer to the array traversal
    	// one pointer to index that has zero
    	int [] a = {8,1,0,2,1,0,3};
    	System.out.println("Before the swap");
    	printArray(a);
    	int indexToZero = 0;
    	for (int indexToArrayPos=0; indexToArrayPos<a.length; indexToArrayPos++) {
    		// If current index points to non-zero
    		// previously noted zero index is zero
    		// always indexToZero <= indexToArrayPos
    		// swap
    		if (a[indexToArrayPos] != 0 && a[indexToZero] == 0) {
    			int temp = a[indexToArrayPos];
    			a[indexToArrayPos] = a[indexToZero];
    			a[indexToZero] = temp;
    		}
    		// if swap happened indexToZero or currently it is not pointing
    		// to zero
    		// increment the index
    		if (a[indexToZero]!=0) {
    			indexToZero++;
    		}
    	}
    	System.out.println("After the swap");
    	printArray(a);
    }
    
    public static int findMissingNumber(int [] a) {
    	// An array with a range of numbers given
    	// find missing number
    	int rangeOfNumbers = a.length + 1;
    	int sum = rangeOfNumbers * (rangeOfNumbers+1)/2;
    	for (int i: a) {
    		sum = sum - i;
    	}
    	return sum;
    }
    
    public static boolean isPalindrome(String a) {
    	if (a == null) {
    		return false;
    	}
 
    	int startIndex = 0;
    	int lastIndex  = a.length() - 1;
    	while (startIndex < lastIndex) {
    		if (a.charAt(startIndex) != a.charAt(lastIndex)) {
    			return false;
    		}
    		startIndex++;
			lastIndex--;
    	}
    	return true;
    }
}













