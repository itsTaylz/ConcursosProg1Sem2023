#!/bin/bash

javac ProblemA.java
echo Compiled
cat input.txt | java ProblemA
echo
echo Input 2
echo 
cat input2.txt | java ProblemA