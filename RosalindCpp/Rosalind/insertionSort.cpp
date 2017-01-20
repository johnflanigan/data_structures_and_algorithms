//
//  insertionSort.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/30/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "insertionSort.hpp"
#include <fstream>
#include <iostream>
#include <vector>

void insertionSort() {
    
    int size;
    int i;
    int k;
    int numberOfSwaps = 0;
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_ins.txt");
    file >> size;
    
    std::vector<int> array(size);
    for (i = 0; i < size; i++) {
        file >> array[i];
    }
    
    for (i = 0; i < size; i++) {
        k = i;
        while (k > 0 && array[k] < array[k-1]) {
            iter_swap(array.begin() + k, array.begin() + k - 1);
            numberOfSwaps++;
            k--;
        }
    }
    
    std::cout << numberOfSwaps << std::endl;
    
}