from math import exp, pow
from numpy import arange


def integRec(m:float, a:float, b:float, rectangles:int)->float:
  area = 0
  step = pow(1,rectangles)
  for i in arange(a, b, step):
    area += step * m*exp(-m*i)
  return area