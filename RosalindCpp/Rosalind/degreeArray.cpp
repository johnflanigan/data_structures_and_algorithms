//
//  degreeArray.cpp
//  Rosalind
//
//  Created by John Flanigan on 8/30/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "degreeArray.hpp"
#include <fstream>
#include <vector>
#include <map>
#include <iostream>

void degreeArray() {
    
    int from;
    int to;
    int numberOfVertices;
    int numberOfEdges;
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_deg.txt");
    
    file >> numberOfVertices >> numberOfEdges;
    std::vector<int> defaultVector(0);
    std::map<int, std::vector<int> > mapOfVectors;

    
    // Need to perform action in loop twice because edges are in pairs
    for (int i = 0; i < numberOfEdges; i++) {
        file >> from;
        file >> to;
        
        if (std::find(mapOfVectors[from].begin(), mapOfVectors[from].end(), to) == mapOfVectors[from].end()) {
            mapOfVectors[from].push_back(to);
            mapOfVectors[to].push_back(from);
        }
    }
    
    file.close();
    
    for (int i = 1; i <= numberOfVertices; i++) {
        std::cout << mapOfVectors[i].size() << " ";
    }
    std::cout << std::endl;
    
}