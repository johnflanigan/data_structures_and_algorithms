//
//  binarySearch.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/29/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "binarySearch.hpp"
#include <iostream>
#include <fstream>

void binarySearch() {
    
    int size1, size2;
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_bins.txt");
    file >> size1 >> size2;
    
    int sortedArray[size1], keyArray[size2];
    for (int i = 0; i < size1; i++) {
        file >> sortedArray[i];
    }
    for (int k = 0; k < size2; k++) {
        file >> keyArray[k];
    }
    
    file.close();
    
    int toPrint;
    for (int k = 0; k < size2; k++) {
        toPrint = search(&sortedArray[0], keyArray[k], 0, size1);
        if (toPrint != -1) {
            toPrint++;
        }
        std::cout << toPrint << " ";
    }
    std::cout << std::endl;
}

int search(int *array, int key, int left, int right) {
    int value, mid;
    mid = (left + right) / 2;
    
    if (array[mid] == key) {
        return mid;
    } else if (right < left) {
        return -1;
    } else if (key > array[mid]) {
        value = search(array, key, mid+1, right);
    } else {
        value = search(array, key, left, mid-1);
    }
    
    return value;
}