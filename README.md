# 436hw3

## Question 1

c1 = p1 is in critical section
c0 = p0 is in critical section
t1 = p1 wants to enter to critical section
t0 = p0 wants to enter to critical section

* I used this site: http://spinroot.com/spin/Man/ltl.html for ltl syntax and used spin -f '{ltl code}' to convert them to never claims in promela.
* I have five claims. I tested them one by one by setting never claim: never_0, never_1, never_2, never_3 and never_4.

a) Model is in question 1 folder dtp.pml file. G -(c1^c0)

b) For P0 G(t0 -> Fc0)
   For P1 G(t1 -> Fc1)

c) For P0 G (Fc0)
   For P1 G (Fc1)


