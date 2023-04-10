file=$1
rac=${file:0:-2};


as $file -o $rac.o
ld $rac.o -o $rac

./$rac
