import math


def permutations(liste, tp):
    """
    :liste: liste à permutater
    :tp: taille des permutations (taille de liste donnée par défaut)
    """

    np = math.factorial(len(liste)) // math.factorial(len(liste) - tp)
    combs = [[] for i in range(np)]

    """combs = [[liste[(i + j)%len(liste)] for j in range(tp)] for i in range(np)]  
    temp = 1
    for i in range(tp):
      for j in range(np):
        combs[j].append(liste[(temp//(i+1))%len(liste)])
        temp += 1"""

    print("Nombre de possibilités :", np)  ###

    decalage = 0
    icomb = 0
    for k in range(np // len(liste)):
        for i in range(len(liste)):  # sous-parties
            ##print("pl :", i)
            combs[icomb].append(liste[i])
            for j in range(tp - 1):  # lettres
                combs[icomb].append(liste[((i + (j + 1) + k * (j + 1)) % len(liste))])  ###???¿¿¿
                ##print("lt :", (i + (j+1) + decalage)%len(liste))
            icomb += 1
        decalage += 1

    return combs