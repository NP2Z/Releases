#!/bin/bash
g++ pa.cpp -std=c++11 -o pa.out -O2 ;
mkdir pic;
printf "\nplease input the left number : "; read l;
printf "\nplease input the right number : "; read r;
let i=l;
while [ $i -le $r ]
do
	python3 p1.py;
	./pa.out < temp > input;
	python3 p2.py < input;
	mv paqu $i;
	mv $i pic;
	printf "$i is successfully get! \n";
	let i=i+1;
done
