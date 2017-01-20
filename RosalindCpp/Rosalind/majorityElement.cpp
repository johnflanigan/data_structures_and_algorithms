//
//  majorityElement.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/30/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "majorityElement.hpp"
#include <fstream>
#include <map>
#include <iostream>

void majorityElement() {
    
    int numberOfArrays;
    int size;
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_maj.txt");
    file >> numberOfArrays >> size;
    
    
    for(int i = 0; i < numberOfArrays; i++) {
        std::map<int, int> count;
        int current;
        int j;
        bool outputFlag = false;
        
        for (j = 0; j < size; j++) {
            file >> current;
            count[current]++;
        }
        
        for (std::map<int,int>::iterator it = count.begin(); it != count.end(); it++) {
            if(it->second > size/2) {
                std::cout << it->first << " ";
                outputFlag = true;
            }
        }
        
        if (!outputFlag) {
            std::cout << -1 << " ";
        }
    }
    std::cout << std::endl;
    
}