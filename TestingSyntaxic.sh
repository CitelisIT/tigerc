#!/bin/bash

ArraySyntaxicPass=($(ls examples/tests/syntaxic/pass))
ArraySyntaxicFail=($(ls examples/tests/syntaxic/fail))

clear;

declare -a failedTests

echo "Tests that should have passed but didn't:"

for TEST in ${ArraySyntaxicPass[@]}
do
	if ./tigerc examples/tests/syntaxic/pass/$TEST --parse-tree | grep -q "TASK FAILED"
	then
		echo $TEST
		failedTests=(${failedTests[@]} "syntaxic/pass/$TEST")
	fi
done

echo -e "\n"
echo "Tests that should have failed but didn't:"

for TEST in ${ArraySyntaxicFail[@]}
do
	if ./tigerc examples/tests/syntaxic/fail/$TEST --parse-tree | grep -q "TASK SUCCESSFUL"
	then
		echo $TEST
		failedTests=(${failedTests[@]} "syntaxic/fail/$TEST")
	fi
done