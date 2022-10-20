"""
Replaces every not on the edge cluster (islands) of 1s to 0s 
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
import time


def main():  
  print(test(output1, del_islands_dos(input1)))
  print(test(output2, del_islands_dos(input2)))
  print(test(output3, del_islands_dos(input3)))
  print(test(output4, del_islands_dos(input4)))
  print(test(output5, del_islands_dos(input5)))
  ## startTime = time.time()
  ## for i in range(1000): test(output5, del_islands_dos(input5))
  ## print(time.time() - startTime)


def test(expected, toCheck):
  return expected == toCheck


# Run main
main()
