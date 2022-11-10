import math
import numpy


def f(x:float, m:float)->float:
    """
    Exponential law density function.
    :param x: input value
    :param m: average value
    :return: 0 if x < 0, else f(x) for given m
    """
    if (m >= 0):
        return m*math.exp(-m*x)
    else:
        return 0


def approximate_integral_of_f(m:float, a:float, b:float, delta:float)->float:
    """
    :param m: parameter of f
    :param a: born -
    :param b: born +
    :param delta: step of precision
    :return: approximate result of integral of f(x) on interval [a;b] for given m
    """
    return sum(delta*f(x, m) for x in numpy.arange(a, b, delta))