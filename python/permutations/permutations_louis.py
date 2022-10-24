# 🥖🥖🥖
import time
from typing import List # typed lists


def permutations(liste:list, taille:int = 0, tempsLimite:int = 60) -> List[list]:
    """
    Donne les permutations (qui peuvent être tronquées) d'une liste.
    Part d'une lettre (2 pour raison technique) et ajoute la prochaine dans toutes les combinaisons possibles.
    :param list liste: Liste d'objets dont on cherche les permutations
    :param int taille: Taille des permutations en nombre d'éléments
    :param int tempsLimite: Secondes au bout desquelles la recherche de permutations s'arrête (60 par défaut)
    :return: Liste triée des permutations possibles
    """

    """Valide ou corrige les paramètres"""
    #Supprime les doubles de la liste
    listeSansDouble = []
    for element in liste:
        if element not in listeSansDouble:
            listeSansDouble.append(element)
    liste = listeSansDouble

    tailleListe = len(liste)
    if taille <= 0 or taille > tailleListe: taille = tailleListe
    if tempsLimite <= 0: tempsLimite = 60;
    #Traite le cas particuliers ou la liste a ou aura moins de 2 éléments
    if tailleListe < 2 or taille < 2: return liste


    """Corps de l'algorithme"""
    permutations = []
    #Les deux premières sont un cas particulier
    permutations.append(liste[:2:1])  #[A,B]
    permutations.append(liste[1::-1])  #[B,A]
    liste.pop(0) ; liste.pop(0)  #-[A]-[B]

    debutChronometre = time.time()
    tempsEcoule = lambda: time.time() - debutChronometre
    for lettreAInserer in liste:  #Chaque lettre
        permutationsApres = []
        for branche in permutations:  #Chaque permutation précédente
            for indiceInsertion in range(len(branche) + 1):  #Chaque indice
                brancheCache = branche[:]
                brancheCache.insert(indiceInsertion, lettreAInserer)
                permutationsApres.append(brancheCache)
            if (tempsEcoule() > tempsLimite): print("Temps limite atteind");return permutations
        permutations = permutationsApres[:]


    """Rectifications finales"""
    #Tronquage et unification
    if (taille < tailleListe) and (tempsEcoule() < tempsLimite):
        #Solution très peu efficace de tronquage
        for i, branches in enumerate(permutations):
            permutations[i] = branches[:taille]
            if (tempsEcoule() > tempsLimite): print("Temps limite atteind");return permutations

        #Unification
        tableauSansDouble = []
        for branches in permutations:
            if (tempsEcoule() > tempsLimite): print("Temps limite atteind");return permutations
            if branches not in tableauSansDouble:
                tableauSansDouble.append(branches)
        permutations = tableauSansDouble

    return permutations