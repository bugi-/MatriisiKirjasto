import numpy as np

import matplotlib.pyplot as plt

naive = [ 0, 8, 15, 45, 99, 193, 329, 518, 775, 1416, 1753, 3813, 3311, 6036, 8942, 11027 ]
transposed = [ 0, 10, 10, 25, 51, 94, 154, 241, 352, 504, 696, 931, 1182, 1495, 1854, 2530 ]

matrixSizes = [i * 10 for i in range(16)]
plt.plot(matrixSizes, naive, 'r', label = 'Ilman transpoosia')
plt.plot(matrixSizes, transposed, 'b', label = 'Transpoosin avulla')
plt.legend(loc='upper left')
plt.xlabel('Matriisien sivun pituus')
plt.ylabel('Tuhannen operaation suoritusaika (ms)')
plt.show()
