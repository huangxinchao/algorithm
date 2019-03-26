"""
快速排序

递归公式：quick_sort(s,e) = partition->m  qucik_sort(s,m-1) + quick_sort(m+1,e)
终止条件：s>=e
"""
from typing import List


def quickSort(_arr:List[int]):
    _quickSortBetween(_arr,0,len(_arr)-1)

def _quickSortBetween(_arr:List[int], _low:int, _high:int):
    if _low >= _high:
        return
    pivot = _partition(_arr,_low,_high)
    _quickSortBetween(_arr,_low,pivot-1)
    _quickSortBetween(_arr,pivot+1,_high)

def _partition(_arr:List[int], _low:int, _high:int) -> int:
    j = _low
    pivot = _arr[_low]
    for i in range(_low+1,_high+1):
        if _arr[i]<=pivot:
            j += 1
            _arr[i],_arr[j] = _arr[j],_arr[i]
    _arr[_low],_arr[j] = _arr[j],_arr[_low]
    return j
if __name__ == '__main__':
    arr = [3,4,2,1,6]
    quickSort(arr)
    print(arr)