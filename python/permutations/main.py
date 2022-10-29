import permutations_louis
from itertools import permutations


## perms = permutations("LAURENT DEMAY")
perms = permutations_louis.permutations(list("LAURENT DEMAY"), 0, 100)
print(*perms)
print(len(perms))
