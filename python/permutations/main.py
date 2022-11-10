import permutations_louis as resource


def tests(value):
    perms = resource.permutations(list(value), 0, 30)
    print("\nPermutations for \""+value+"\" ("+str(len(perms))+" possibilitie(s)):")
    for possibility in perms:
        print(possibility)


# Run tests for given values
tests("ABC")
tests("AMOGUS")