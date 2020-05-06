#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the queensAttack function below.
def queensAttack(n, k, rq, cq, obstacles):
    qvh = (2*n) -2

    if(rq+cq>n+1):
        q1d1 = 2*n - (rq+cq)
    else:
        q1d1 = rq + cq -2 

    q2d2 = n-1 -abs(rq-cq)
    qmoves = qvh+q1d1+q2d2
    return qmoves
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    r_qC_q = input().split()

    r_q = int(r_qC_q[0])

    c_q = int(r_qC_q[1])

    obstacles = []

    for _ in range(k):
        obstacles.append(list(map(int, input().rstrip().split())))

    result = queensAttack(n, k, r_q, c_q, obstacles)

    fptr.write(str(result) + '\n')

    fptr.close()
