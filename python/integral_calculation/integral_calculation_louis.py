from math import exp, log, pow
from numpy import arange


# C'est l'exo 5.5 page 3*4 (Pour Titi💓)
def integRec(m, a, b, rectangles):
  area = 0
  step = pow(1,rectangles)
  for i in arange(a, b, step):
    area += step * m*exp(-m*i)
  return area


print("\033[94mintegRec :\033[92m", integRec(log(2)/200, 0, 300,  1000),  '\033[0m') # Censé être ~0.3535
