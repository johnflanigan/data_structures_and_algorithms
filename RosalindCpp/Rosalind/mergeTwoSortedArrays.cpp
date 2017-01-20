//
//  mergeTwoSortedArrays.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/31/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "mergeTwoSortedArrays.hpp"
#include <fstream>
#include <vector>
#include <iostream>

void mergeTwoSortedArrays() {
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_mer.txt");
    
    int size1;
    file >> size1;
    std::vector<int> vector1(size1);
    for (int i = 0; i < size1; i++) {
        file >> vector1[i];
    }
    
    int size2;
    file >> size2;
    std::vector<int> vector2(size2);
    for (int i = 0; i < size2; i++) {
        file >> vector2[i];
    }
    
    int mergedSize = size1 + size2;
    std::vector<int> mergedVector(mergedSize);
    int i = 0, j = 0, k = 0;
    while ( i < size1 && j < size2) {
        if (vector1[i] < vector2[j]) {
            mergedVector[k] = vector1[i];
            i++;
        } else {
            mergedVector[k] = vector2[j];
            j++;
        }
        k++;
    }
    
    for (;i < size1; i++) {
        mergedVector[k] = vector1[i];
        k++;
    }
    
    for (; j < size2; j++) {
        mergedVector[k] = vector1[j];
        k++;
    }
    
    for (k = 0; k < mergedSize; k++) {
        std::cout << mergedVector[k] << " ";
    }
    std::cout << std::endl;
}
