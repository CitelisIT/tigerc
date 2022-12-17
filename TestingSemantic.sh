#!/bin/bash

ArraySemanticPass=($(ls examples/tests/semantic/pass))

clear;
rm -rfd output/dot/semantic/pass;
mkdir -p output/dot/semantic/pass;
rm -rfd output/svg/semantic/pass;
mkdir -p output/svg/semantic/pass;

for TEST in ${ArraySemanticPass[@]}
do
	nameOfTest="${TEST%.*}"
	./tigerc examples/tests/semantic/pass/$TEST --ast output/dot/semantic/pass/$nameOfTest.dot
	dot -Tsvg output/dot/semantic/pass/$nameOfTest.dot -o output/svg/semantic/pass/$nameOfTest.svg
	rm output/dot/semantic/pass/$nameOfTest.dot
done