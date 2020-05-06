#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the kaprekarNumbers function below.
def kaprekarNumbers(p, q):
    result = []
    for n in range (p,q+1):
        nsq = n**2
        ndig = len(str(n))
        nsqstr = str(nsq)
        nsqlen = len(nsqstr)
        if(nsqlen>1):
            if(nsqlen%2 == 0):
                l = int(nsqstr[:ndig])
                r = int(nsqstr[ndig:nsqlen])
            else:
                l = int(nsqstr[:(ndig-1)])
                r = int(nsqstr[(ndig-1):nsqlen])
        else:
            l = 0
            r = nsq        
        if(l+r == n):
            result.append(n)
    if(len(result)!=0):
        print(' '.join(map(str, result)) )
    else:
        print("INVALID RANGE")    
if __name__ == '__main__':
    p = int(input())

    q = int(input())

    kaprekarNumbers(p, q)
