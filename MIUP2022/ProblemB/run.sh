#!/bin/bash

javac ProblemB.java
echo Compiled
cat input.txt | java ProblemB
echo
echo Input 2
echo 
cat input2.txt | java ProblemB