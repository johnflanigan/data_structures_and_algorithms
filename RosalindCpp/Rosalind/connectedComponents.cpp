//
//  connectedComponents.cpp
//  Rosalind
//
//  Created by John Flanigan on 9/1/16.
//  Copyright © 2016 rosalind. All rights reserved.
//

#include "connectedComponents.hpp"
#include <map>
#include <vector>
#include <queue>
#include <fstream>
#include <iostream>

class Node {
public:
    std::vector<int> adjacencyVector;
    bool visted = false;
};

void explore(std::map<int, Node>&, int);

void connectedComponents() {
    
    int numberOfVertices, numberOfEdges, to, from;
    
    std::ifstream file;
    file.open ("/Users/johnflanigan/Developer/Rosalind/Rosalind/rosalind_cc.txt");
    
    file >> numberOfVertices >> numberOfEdges;
    
    std::map<int, Node> verticesMap;
    
    for (int i = 0; i < numberOfEdges; i++) {
        file >> to >> from;
        to--;
        from--;
        verticesMap[to].adjacencyVector.push_back(from);
        verticesMap[from].adjacencyVector.push_back(to);
    }
    
    std::queue<int> queue;
    
    int componentsCounter = 0;
    
    for (int i = 0; i < numberOfVertices; i++) {
        if (verticesMap[i].visted == false) {
            explore(verticesMap, i);
            componentsCounter++;
        }
    }
    
    std::cout << componentsCounter << std::endl;
}

void explore(std::map<int, Node>& graph, int vertex) {
    graph[vertex].visted = true;
    int index;
    while (!graph[vertex].adjacencyVector.empty()) {
        index = graph[vertex].adjacencyVector.back();
        graph[vertex].adjacencyVector.pop_back();
        if (graph[index].visted == false) {
            explore(graph, index);
        }
    }
}