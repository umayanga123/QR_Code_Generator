# import the necessary packages
from scipy.spatial import distance as dist
import numpy as np
import argparse
import glob
import cv2
from matplotlib import pyplot as plt

img = plt.imread('7.jpg')

plt.hist(img.flatten(), bins=[-.5,.5,1.5], ec="k")
plt.xticks((0,1))
plt.show()
