from common_divisor_tilian import *


def tests(a, b):
    print("\nTest with a =", a, "and b =", str(b)+":")
    vgcd = gcd(a, b)
    print("a ^ b =", vgcd)
    u, v = extended_euclidean(a, b)
    print(vgcd, "=", str(a)+"*"+str(u), "+", str(b)+"*"+str(v))


# Run tests with given values
tests(270, 192)
tests(117, 25)