import permutations_louis, permutations_tilian
from itertools import permutations

# print("louis(1) tilian(2)")
# qui = input()
qui = "1"

# -------------------------------------------------------

if qui == "1":
    perms = permutations("LAURENT DEMAY")
    perms = permutations_louis.permutations(list("LAURENT DEMAY"),0,100)
    print(*perms)
    print(len(perms))

# -------------------------------------------------------

elif qui == "2":
    print("--- TEST ---")
    liste = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    for i in permutations_tilian.permutations(list("AAAAAAAAAAAAAAA"),6):
        print(i)

else:
    print("tnul")