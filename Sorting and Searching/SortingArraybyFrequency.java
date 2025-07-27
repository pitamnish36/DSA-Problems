/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SortingArraybyFrequency {
	public static void main (String[] args) {
		//code here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
		    int n=sc.nextInt();
		    int []arr=new int[n];
		    HashMap<Integer,Integer> map=new HashMap();
		    for(int j=0;j<n;j++){
		        arr[j]=sc.nextInt();
		        if(!map.containsKey(arr[j])){
		            map.put(arr[j],1);
		        }
		        else{
		            map.put(arr[j],map.get(arr[j])+1);
		        }
		    }
		    mergeSort(arr,0,arr.length-1,map);
		    for(int num:arr){
		        System.out.printf("%d ",num);
		    }
		    System.out.print("\n");
		}
		
	}
	public static void mergeSort(int[] arr,int left,int right,HashMap<Integer,Integer> map){
	    if(left>=right){
	        return;
	    }
	    int mid=left+(right-left)/2;
	    mergeSort(arr,left,mid,map);
	    mergeSort(arr,mid+1,right,map);
	    merge(arr,left,mid,right,map);
	}
	public static void merge(int[] arr,int left,int mid,int right,HashMap<Integer,Integer> map){
	    int i=left;
	    int j=mid+1;
	    ArrayList<Integer> temp=new ArrayList<Integer>();
	    while(i<=mid && j<=right){
	        int icnt=map.get(arr[i]);
	        int jcnt=map.get(arr[j]);
	        if(icnt>jcnt){
	            temp.add(arr[i]);
	            i++;
	        }
	        else if(jcnt>icnt){
	            temp.add(arr[j]);
	            j++;
	        }
	        else{
	            if(arr[i]<arr[j]){
	                temp.add(arr[i]);
	                i++;
	            }
	            else{
	                temp.add(arr[j]);
	                j++;
	            }
	        }
	    }
	    while(i<=mid){
	        temp.add(arr[i]);
	        i++;
	    }
	    while(j<=right){
	        temp.add(arr[j]);
	        j++;
	    }
	    for(int k=left;k<=right;k++){
	        arr[k]=temp.get(k-left);
	    }
	}
}
