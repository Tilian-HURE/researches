import math
import numpy


def integRec(m:float, a:float, b:float, rectangles:int)->float:
  area = 0
  step = math.pow(1, rectangles)
  for i in numpy.arange(a, b, step):
    area += step * m*math.exp(-m*i)
  return area