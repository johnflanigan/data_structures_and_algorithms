//
//  fibonacciNumbers.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/29/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include <fstream>
#include "fibonacciNumbers.hpp"

int fibonacciNumbers() {
    
    int value;
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_fibo.txt");
    file >> value;
    file.close();
    
    int solutionArray[value + 1];
    
    solutionArray[0] = 0;
    solutionArray[1] = 1;
    
    for (int i = 2; i <= value; i++) {
        solutionArray[i] = solutionArray[i-1] + solutionArray[i-2];
    }
    
    return solutionArray[value];
}