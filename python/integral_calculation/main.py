from math import log
from integral_calculation_louis import integRec
from integral_calculation_tilian import approximate_integral_of_f


# Tests
print("Test result n°1:", approximate_integral_of_f(log(2)/200, 0, 300, 0.001))

print("Test result (1 - n°1):", 1-approximate_integral_of_f(log(2)/200, 0, 300, 0.001))
print("\033[94mintegRec :\033[92m", 1-integRec(log(2)/200, 0, 300,  1000),  '\033[0m') # with colors

print("Test result n°2:", approximate_integral_of_f(1.5, 0, 2, 0.001))