def f(x, m):
    """
    Exponential law density function.
    :param x: input value
    :param m: average value
    :return: 0 if x < 0, else f(x) for given m
    """
    if (m >= 0) :
        return m*exp(-m*x)
    else:
        return 0


def temp(m, a, b, delta):
    """
    Same function as approximate_integral_of_f() but on many lines.
    """
    sum = 0
    for x in arange(a, b, delta):
        add = delta*f(x, m)
        sum += add
        ## print(x, f(x, m), add, sum, sep=" - ")
    return sum

def approximate_integral_of_f(m, a, b, delta):
    """
    :param m: parameter of f
    :param a: born -
    :param b: born +
    :param delta: step of precision
    :return: approximate result of integral of f(x) on interval [a;b] for given m
    """
    return sum(delta*f(x, m) for x in arange(a, b, delta))


# Tests
print("Test result n°1:", approximate_integral_of_f(log(2)/200, 0, 300, 0.001))
print("Test result 1 - n°1:", 1-approximate_integral_of_f(log(2)/200, 0, 300, 0.001))
print("Test result n°2:", approximate_integral_of_f(1.5, 0, 2, 0.001))
## print("Test result:", temp(log(2)/200, 0, 300, 0.001))
