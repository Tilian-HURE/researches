class One:
    """
    One objects can be visited together by propagation, they consitute clusters in a matrix.
    :param: visited: if the One has been visited or not
    :param: adjUp: other class One object situated above in a matrix
    :param: adjRight: other class One object situated at right in a matrix
    :param: adjDown: other class One object situated bellow in a matrix
    :param: adjLeft: other class One object situated at left in a matrix
    """

    def __init__(self):
        self.visited = False
        self.adjUp = None
        self.adjRight = None
        self.adjDown = None
        self.adjLeft = None

    def set_adj_up(self, adjUp):
        self.adjUp = adjUp

    def set_adj_right(self, adjRight):
        self.adjRight = adjRight

    def set_adj_down(self, adjDown):
        self.adjDown = adjDown

    def set_adj_left(self, adjLeft):
        self.adjLeft = adjLeft

    def propagate(self):
        if not self.visited:
            self.visited = True
            if self.adjUp: # Up
                self.adjUp.propagate()
            if self.adjRight: # Right
                self.adjRight.propagate()
            if self.adjDown: # Down
                self.adjDown.propagate()
            if self.adjLeft: # Left
                self.adjLeft.propagate()


def to_one_class_matrix(matrix):
    """
    Converts given simple binary matrix to a 0 and class One objects matrix with all adjacencies.
    :param: matrix: simple binary matrix to convert
    :return: 0 and class One objects matrix
    """
    # Creates a matrix of class One objects
    oneMatrix = [[One() if element == 1 else 0 for element in row] for row in matrix]

    # Sets adjacencies
    for ix, row in enumerate(oneMatrix):
        for iy, element in enumerate(row):
            if element != 0:
                if ix > 0 and oneMatrix[ix-1][iy] != 0: # Up
                    element.set_adj_up(oneMatrix[ix-1][iy])
                if iy < len(row)-1 and oneMatrix[ix][iy+1] != 0: # Right
                    element.set_adj_right(oneMatrix[ix][iy+1])
                if ix < len(oneMatrix)-1 and oneMatrix[ix+1][iy] != 0: # Down
                    element.set_adj_down(oneMatrix[ix+1][iy])
                if iy > 0 and oneMatrix[ix][iy-1] != 0: # Left
                    element.set_adj_left(oneMatrix[ix][iy-1])

    return oneMatrix


def del_islands_dos(matrix):
    """
    Removes clusters of 1 that aren't on the given matrix borders.
    :param: matrix: simple binary matrix to edit
    :return: edited matrix
    """
    # Converts simple binary matrix to 0 and class One objects
    oneMatrix = to_one_class_matrix(matrix)

    # Propagates/visits every border class One objects clusters
    for element in oneMatrix[0]: # Top borders
        if element != 0:
            element.propagate()
    for row in oneMatrix[1:-1]: # Side borders
        for element in (row[0], row[-1]):
            if element != 0:
                element.propagate()
    for element in oneMatrix[-1]: # Bottom borders
        if element != 0:
            element.propagate()

    # Returns new simple binary matrix with only border 1 clusters
    return [[1 if element != 0 and element.visited else 0 for element in row] for row in oneMatrix]
