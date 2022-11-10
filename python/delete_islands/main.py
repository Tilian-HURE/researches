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


import delete_islands2_tilian as resource
import test_matrix as tm
from typing import List # typed lists
import os


def tests():
    print("6*6 matrix:", check(tm.output1, resource.del_islands_dos(tm.input1)))
    print("2nd 6*6 matrix:", check(tm.output2, resource.del_islands_dos(tm.input2)))
    print("20*20 matrix:", check(tm.output3, resource.del_islands_dos(tm.input3)))
    print("10*10 matrix:", check(tm.output4, resource.del_islands_dos(tm.input4)))
    print("100*100 matrix:", check(tm.output5, resource.del_islands_dos(tm.input5)))


def check(expected:List[List[int]], checked:List[List[int]])->str:
    return ["Not OK", "OK"][int(expected == checked)]


# Run tests
tests()

# Write gotten output6 from input6 in a .py file
output6_file = os.open("output6_matrix.py", os.O_WRONLY|os.O_CREAT|os.O_TRUNC)
os.write(output6_file, str.encode(str(resource.del_islands_dos(tm.input6)).replace(" ", "")))
print("output6_matrix.py file written!")
os.close(output6_file)
