from math import exp, pow
from numpy import arange


# C'est l'exo 5.5 page 3*4 # (Pour Titi💓
#   Genre Thierry,
#   je me rends compte que ce que t'as écrit porte à confusion et vu que t'as signé le fichier à mon nom c'est chelou.
#   La bise.
# )
def integRec(m:float, a:float, b:float, rectangles:int)->float:
  area = 0
  step = pow(1,rectangles)
  for i in arange(a, b, step):
    area += step * m*exp(-m*i)
  return area