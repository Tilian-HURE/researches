import permutations_louis
from itertools import permutations


# Tests
## perms = permutations("STYLOGRAPHIC")
perms = permutations_louis.permutations(list("STYLOGRAPHIC"), 0, 100)
print(perms, "\nfor size of", len(perms))
