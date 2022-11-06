from typing import Dict, Tuple # typed objects


def get_gcd_step(a:int, b:int)->Dict[str, int]:
    """
    Calculates and formats the n-th step in determining the Greatest Common Divisor between two integers.
    :return: a dict of the values composing the n-th step for a = b*k + r with the given values for a and b
    """
    return {"a":a, "b":b, "k":a//b, "r":a%b}


def gcd(a:int, b:int)->int:
    """
    Calculates the Greatest Common Divisor between two integers.
    :param a: first integer
    :param b: second integer
    :return: the GCD between the given integers
    """
    a, b = max(a, b), min(a, b)
    ## print(get_gcd_step(a, b)) # trace
    r = a % b
    if r == 0:
        return b
    else:
        return gcd(b, r)


def get_bezout(a:int, b:int, r:int)->Dict[str, int]:
    """
    Formats the given values following Bézout's theorem.
    :return: a dict of the values for r = a*u + b*v with the given values for a, b and r
    """
    return {"r":r, "a":a, "u":1, "b":b, "v":-get_gcd_step(a, b)["k"]}


def extended_euclidean(a:int, b:int)->Tuple[int, int]:
    """
    Applies the extended Euclidean algorithm for two integers following Bézout's theorem.
    :return: u and v for r = a*u + b*v with the given values for a and b (r being their GCD)
    """
    if a % b == 0:
        raise Exception("The extended Euclidean algorithm can't be applied if a % b == 0.")

    # Apply the Euclidean algorithm step by step
    gcdSteps = [get_gcd_step(a, b)]
    while gcdSteps[-1]["r"] != gcd(a, b):
        gcdSteps.append(get_gcd_step(gcdSteps[-1]["b"], gcdSteps[-1]["r"]))

    # Apply and solve Bézout's theorem to find u and v by re-ascending the Euclidean algorithm steps
    bezout = get_bezout(gcdSteps[-1]["a"], gcdSteps[-1]["b"], gcdSteps[-1]["r"])
    for gcdStep in gcdSteps[-2::-1]:
        nextBezoutStep = get_bezout(gcdStep["a"], gcdStep["b"], gcdStep["r"])
        if nextBezoutStep["r"] == bezout["a"]: # develop a
            bezout["a"] = nextBezoutStep["a"]
            bezout["u"] = nextBezoutStep["u"] * bezout["u"]
            bezout["v"] = bezout["v"] + nextBezoutStep["v"]*bezout["u"]
        if nextBezoutStep["r"] == bezout["b"]: # develop b
            bezout["b"] = nextBezoutStep["a"]
            bezout["v"] = nextBezoutStep["u"] * bezout["v"]
            bezout["u"] = bezout["u"] + nextBezoutStep["v"]*bezout["v"]

    return bezout["u"] if a == bezout["a"] else bezout["v"], bezout["v"] if b == bezout["b"] else bezout["u"]