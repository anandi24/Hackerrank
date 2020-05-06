#!/bin/python3

import math
import os
import random
import re
import sys
import bisect

def createRank(score):
  score.sort(reverse = True)
  rank = []
  i=1
  repCount = 1
  for ea in score:
    rank.append(i)
    if(score.count(ea)>1 and repCount!=score.count(ea)):
      i = i
      repCount = repCount + 1
    else:
      repCount = 1
      i=i+1
  return rank


def rankAlice(rank, score, alice):
  aliceRanks = []
  for ea in alice:
    if ea not in score:
      score.append(ea)
      rank = createRank(score)
    aliceRanks.append(rank[score.index(ea)])
  #print("Alice ranks", aliceRanks)
  return aliceRanks

# Complete the climbingLeaderboard function below.
def climbingLeaderboards(score, alice):
    aliceranks = []
    scores = list(set(score))
    scores.sort(reverse= True)
    #print(scores)
    for ea in alice:
        #print(ea, "ea")
        lastrank = False
        if ea in scores:
            rank = scores.index(ea)+1
        else:
            l = min(scores, key=lambda x:abs(x-ea))
            #print(l, "l")
            rank = scores.index(l) +1
            if(ea<l):
                lastrank = True
        if lastrank:
            rank = rank  + 1
        aliceranks.append(rank)
    return aliceranks

def climbingLeaderboard(scores, alice):
    res = []
    s = sorted(list(set(scores)))
    l = len(s)
    for v in alice:
         res.append(l - bisect.bisect_right(s, v) +1)
             
    return res

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
