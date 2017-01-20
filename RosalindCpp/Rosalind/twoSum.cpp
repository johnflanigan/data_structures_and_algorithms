//
//  twoSum.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/31/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "twoSum.hpp"
#include <fstream>
#include <vector>
#include <iostream>


void twoSum() {
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_2sum.txt");
    
    int numberOfArrays, size;
    file >> numberOfArrays >> size;
    
    for (int i = 0; i < numberOfArrays; i++) {
        std::vector<int> vector(size);
        std::vector<int> sortedVector(size);
        
        for (int j = 0; j < size; j++) {
            file >> vector[j];
        }
        
        //std::copy (vector.begin(), vector.end(), sortedVector.begin());
        //std::sort (sortedVector.begin(), sortedVector.end());
        
        int p, q;
        bool outputFlag = false;
        
        for (p = 0; p < size; p++) {
            for (q = p + 1; q < size; q++) {
                if (vector[p] + vector[q] == 0) {
                    std::cout << p + 1 << " " << q + 1;
                    outputFlag = true;
                    break;
                }
            }
            if (vector[p] + vector[q] == 0) {
                break;
            }
        }
        if (!outputFlag) {
            std::cout << -1;
        }
        std::cout << std::endl;
    }
}

        
        /*
        while (sortedVector[p] + sortedVector[q] != 0 && sortedVector[p] != 0 && sortedVector[q] != 0) {
            if (sortedVector[p] + sortedVector[q] < 0) {
                p++;
            } else {
                q--;
            }
        }
        
        if (sortedVector[p] + sortedVector[q] == 0) {
            std::vector<int>::iterator it1, it2;
            
            it1 = std::find(vector.begin(), vector.end(), sortedVector[p]);
            it2 = std::find(vector.begin(), vector.end(), sortedVector[q]);
            
            long distance1, distance2;
            
            distance1 = std::distance(vector.begin(), it1);
            distance2 = std::distance(vector.begin(), it2);
            
            if (distance1 < size) {
                distance1++;
            }
            if (distance2 < size) {
                distance2++;
            }
            
            if (distance1 < distance2) {
                std::cout << distance1 << " " << distance2;
            } else {
                std::cout << distance2 << " " << distance1;
            }
            
        } else {
            std::cout << -1;
        }
        
        std::cout << std::endl;
    }
}*/