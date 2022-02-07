#!/bin/bash
printf "please input the left of the pics\n";
read l; let i=l;
printf "please input the right of the pics\n"
read r;
mkdir pic;
time while [ $i -le $r ]
do
    time python3 p.py; 
    printf "num $i is successfully get\n";
    mv paqu pa$i;
	mv pa$i pic;
    let i=i+1;
done
