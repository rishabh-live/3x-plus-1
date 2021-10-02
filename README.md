# 3x-Plus-1 #


`3x-Plus-1` is an algorithmic encryption scheme that is based on the Collatz Problem.
- - - - 
## Table of Contents
* [Collatz Problem?](#collatz-problem?)
* [How it Works](#how-it-works)
* [Feedback](#feedback)

## Collatz Problem?
>What is the Collatz Problem?

#### *The Collatz Problem or 3x+1 problem refers to the popular conjecture in mathematics that concerns sequences.*
It is defined as follows: 
* Start with any positive integer n. Then each term is obtained from the previous term as follows:
    * If the previous term is even, the next term is one half of the previous term. 
    * If the previous term is odd, the next term is three times the previous term plus one. 
* The conjecture is that no matter what value n that we started with, the sequence will always reach 1. 

## How it Works
>So how does this conjecture relate to this java program?

The problem is used to find the highest number where the 3x+1 calculator can reach and at which points based on the number of characters.
After finding the highest possoble number and coinciding number of steps to reach the number, it can be used in two ways:
* Used as Salt(random char string added to the beginning or end) with sha256
* OR can be used as sha56( sha56(password) + sha56(highestPossible) + sha56(highestPoint))

This package utilizes the second approach.

## Feedback
> If you have any feedback or suggestions, please feel free to reach out!
- - - - 