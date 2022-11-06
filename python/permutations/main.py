import permutations_louis


def tests(value):
    perms = permutations_louis.permutations(list(value), 0, 30)
    print("\nPermutations for \""+value+"\" ("+str(len(perms))+" possibilitie(s)):")
    for possibility in perms:
        print(possibility)


# Run tests for given values
tests("ABC")
tests("AMOGUS")