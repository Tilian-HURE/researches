from math import exp, log, pow
from numpy import arange


# C'est l'exo 5.5 page 3*4 (Pour Titi💓 (Genre Thierry, je me rends compte que ce que t'as écrit porte à confusion et vu que t'as signé le fichier à mon nom c'est chelou. La bise))
def integRec(m:float, a:float, b:float, rectangles:int)->float:
  area = 0
  step = pow(1,rectangles)
  for i in arange(a, b, step):
    area += step * m*exp(-m*i)
  return area


print("\033[94mintegRec :\033[92m", 1-integRec(log(2)/200, 0, 300,  1000),  '\033[0m') # Censé être ~0.3535