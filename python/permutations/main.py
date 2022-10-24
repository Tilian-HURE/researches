import permutations_louis
from itertools import permutations


## perms = permutations("LAURENT DEMAY")
perms = permutations_louis.permutations(list("L"), 0, 100)
print(*perms)
print(len(perms))