"""
归并排序
递归公式：merge_sort(s,e) = merge_sort(s,m) + merge_sort(m,e) -> merge()    , m = (s+e)/2
终止条件：s>=e

时间复杂度：O(nlogn)
空间复杂度：O(n)
"""

from typing import List

def mergeSort(_arr:List[int]):
    _mergeSortBetween(_arr,0,len(_arr)-1)

def _mergeSortBetween(_arr:List[int],_start:int,_end:int):
    if(_start>=_end):
        return
    mid = (_start+_end)//2
    _mergeSortBetween(_arr,_start,mid)
    _mergeSortBetween(_arr,mid+1,_end)
    _merge(_arr,_start,mid,_end)

def _merge(_arr,_low,_mid,_high):
    i = _low
    j = _mid+1
    tmpList = []
    while(i<= _mid and j<=_high):
        if _arr[i]<_arr[j]:
            tmpList.append(_arr[i])
            i += 1
        else:
            tmpList.append(_arr[j])
            j += 1
    startPosition = i if i <= _mid else j
    endPosition = _mid if i <= _mid else _high
    tmpList.extend(_arr[startPosition:endPosition+1])
    _arr[_low:_high+1] = tmpList

if __name__ == '__main__':
    arr = [4,2,1,3]
    mergeSort(arr)
    print(arr)