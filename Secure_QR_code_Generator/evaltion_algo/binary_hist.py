from matplotlib import pyplot as plt

img = plt.imread('7.jpg')

plt.hist(img.flatten(), bins=[-.5,.5,1.5], ec="k")
plt.xticks((0,1))
plt.show()
