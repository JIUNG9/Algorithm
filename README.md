# Algorithm


## Approach

### consideration
1. The number of input is 100,000 so n^2 will be 100,000,000,000. it is too slow to run it
2. '0' can be one of the element of array. this mean the array can be ["0","0,"0"]


### Approach

1. Override the Comparator interface which get only first digit of number
1.1 If number is not equal compare the number which means bigger number will be rear side.
1.2 If number is equal make the value with o1, o2. this mean compare String value of o1+o2 and o2+o1
2. If the first digit is "0" this mean all elements are consisted of "0" so just return "0" else return the answer by concatenating from rear side
