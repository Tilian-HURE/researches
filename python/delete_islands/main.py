"""
Replaces every not on the edge cluster (islands) of 1 by 0.

Input:
[1,0,0,1,0,0]
[0,1,1,0,1,1]
[1,0,0,1,0,1]
[1,1,0,0,0,0]
[0,1,0,0,1,1]

Output:
[1,0,0,1,0,0]
[0,0,0,0,1,1]
[1,0,0,0,0,1]
[1,1,0,0,0,0]
[0,1,0,0,1,1]
"""


from delete_islands2_tilian import to_one_class_matrix, del_islands_dos
from test_matrix import *
from typing import List # typed lists
import time, os


def tests():
    print("6*6 matrix:", check(output1, del_islands_dos(input1)))
    print("2nd 6*6 matrix:", check(output2, del_islands_dos(input2)))
    print("20*20 matrix:", check(output3, del_islands_dos(input3)))
    print("10*10 matrix:", check(output4, del_islands_dos(input4)))
    print("100*100 matrix:", check(output5, del_islands_dos(input5)))
  
    ## startingTime = time.time(); n = 1000
    ## for i in range(n): check(output5, del_islands_dos(input5))
    ## print("Taken time to solve", n, "100*100 matrix:", time.time()-startingTime)


def check(expected:List[List[int]], checked:List[List[int]])->str:
    return ["Not OK", "OK"][int(expected == checked)]


# Run tests
tests()

# Write gotten output6 from input6 in a .py file
output6_file = os.open("output6_matrix.py", os.O_WRONLY|os.O_CREAT|os.O_TRUNC)
os.write(output6_file, str.encode(str(del_islands_dos(input6)).replace(" ", "")))
print("output6_matrix.py file written!")
os.close(output6_file)
