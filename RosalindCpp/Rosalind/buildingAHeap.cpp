//
//  buildingAHeap.cpp
//  Rosalind
//
//  Created by John Flanigan on 9/1/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "buildingAHeap.hpp"
#include <fstream>
#include <vector>
#include <iostream>

void maxHeapify(std::vector<int>&, int);

void buildingAHeap() {
    int size;
    
    std::ifstream file;
    //file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/test.txt");
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_hea.txt");
    
    file >> size;
    
    std::vector<int> heap(size+1);
    
    for (int i = 1; i <= size; i++) {
        file >> heap[i];
    }
    
    for (int i = heap.size(); i >= 2; i--) {
        maxHeapify(heap, i);
    }
    
    for (int i = 1; i <= size  ; i++) {
        std::cout << heap[i] << " ";
    }
    
    std::cout << std::endl;
    
}

void maxHeapify(std::vector<int> & heap, int index) {
    int parent = index/2;
    
    if (heap[parent] < heap[index]) {
        iter_swap(heap.begin() + index, heap.begin() + parent);
        if (2*index <= heap.size()) {
            maxHeapify(heap, 2*index);
        }
        if (2*index + 1 <= heap.size()) {
            maxHeapify(heap, 2*index+1);

        }
    }
    
    //if (largest != index && largest != 0 && index != 0) {
      //  iter_swap(heap.begin() + index, heap.begin() + largest);
        //maxHeapify(heap, largest);
    //}
}
/*
void maxHeapify(std::vector<int> & array, int index) {
    int left = 2 * index;
    int right = 2 * index + 1;
    int largest = index;
    
    if (left <= array.size() && array[left] > array[largest]) {
        largest = left;
    }
    if (right <= array.size() && array[right] > array[largest]) {
        largest = right;
    }
        
    if (largest != index) {
        iter_swap(array.begin() + index, array.begin() + largest);
        //int temp;
        //temp = array[index];
        //array[index] = array[largest];
        //array[largest] = temp;
        maxHeapify(array, largest);
    }
}*/