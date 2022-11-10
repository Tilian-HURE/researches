import math
import integral_calculation_louis as resource1
import integral_calculation_tilian as resource2


def tests1():
    print("\nTests with integRec function:")
    r1 = resource1.integRec(math.log(2)/200, 0, 300, 1000)
    print("\033[94m"+"Test result n°1:\033[92m", r1, "\033[0m")  # test with colors
    print("Test result of 1 - result of n°1:", 1-r1)
    print("Test result n°2:", resource1.integRec(1.5, 0, 2, 1000))


def tests2():
    print("\nTests with approximate_integral_of_f function:")
    r1 = resource2.approximate_integral_of_f(math.log(2)/200, 0, 300, 0.001)
    print("Test result n°1:", r1)
    print("Test result of 1 - result of n°1:", 1-r1)
    print("Test result n°2:", resource2.approximate_integral_of_f(1.5, 0, 2, 0.001))


# Run tests with integRec and approximate_integral_of_f functions
tests1()
tests2()