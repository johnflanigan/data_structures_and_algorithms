//
//  doubleDegreeArray.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/30/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "doubleDegreeArray.hpp"
#include <fstream>
#include <vector>
#include <map>
#include <iostream>

void doubleDegreeArray() {
    
    int from;
    int to;
    int numberOfVertices;
    int numberOfEdges;
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_ddeg.txt");
    
    file >> numberOfVertices >> numberOfEdges;
    std::vector<int> defaultVector(0);
    std::map<int, std::vector<int> > mapOfVectors;
    
    for (int i = 0; i < numberOfEdges; i++) {
        file >> from;
        file >> to;
        
        if (std::find(mapOfVectors[from].begin(), mapOfVectors[from].end(), to) == mapOfVectors[from].end()) {
            mapOfVectors[from].push_back(to);
            mapOfVectors[to].push_back(from);
        }
    }
    
    file.close();
    
    std::vector<unsigned long> degreesArray(numberOfVertices + 1, 0);
    for (int i = 1; i <= numberOfVertices; i++) {
        degreesArray[i] = mapOfVectors[i].size();
    }
    
    std::vector<int> adjacentDegreesArray(numberOfVertices+1, 0);
    int current;
    for (int i = 1; i <= numberOfVertices; i++) {
        while(!mapOfVectors[i].empty()) {
            current = mapOfVectors[i].back();
            mapOfVectors[i].pop_back();
            adjacentDegreesArray[i] += degreesArray[current];
        }
    }
    
    
    
    for (int i = 1; i <= numberOfVertices; i++) {
        std::cout << adjacentDegreesArray[i] << " ";
    }
    std::cout << std::endl;
    
}