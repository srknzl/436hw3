# 436hw3

## Question 1

c1 = p1 is in critical section
c0 = p0 is in critical section
t1 = p1 wants to enter to critical section
t0 = p0 wants to enter to critical section

* I used this site: http://spinroot.com/spin/Man/ltl.html for ltl syntax and used spin -f '{ltl code}' to convert them to never claims in promela.
* I have five claims. I tested them one by one by setting never claim: never_0, never_1, never_2, never_3 and never_4.
* I have done my verifications with only selecting safety radio button from the verification tab, since we are checking other properties explicitly.

a) Model is in question 1 folder dtp.pml file. never_0 G -(c1^c0)  --- no errors

b) never_1 For P0 G(t0 -> Fc0) -- no errors
   never_2 For P1 G(t1 -> Fc1) -- no errors

c) never_3 For P0 G (Fc0) -- no errors
   never_4 For P1 G (Fc1) -- no errors

## Question 2

a) I have added a png image after drawing it with this tool in the internet. http://madebyevan.com/fsm/

b) M,state means for every execution path starting from that state ltl rule should hold.

i) -p -> r    -- if p false, r is true
ii) Ft        -- eventually t becomes true
iii) Fq       -- eventually q becomes true
iv)  G(r v q) -- Always r or q is true.

For s0:

i) Holds because there is no state both p and r are false. i) only becomes false when both p,r are false.

ii) False, because if we loop on s0 forever t will not be true eventually. s0->s0->s0->...

iii) False. Similar to ii), we can loop on s0, thus making q false forever. 

iv) True. The ltl formula r v q is true for all states. Thus G(r v q) will be true for all paths.

For s2:

i) True. Holds because there is no state both p and r are false. i) only becomes false when both p,r are false.

ii) True. Starting from we can only go to s1 and s2 alternating. Like this: s2->s1->s2->s1.... Therefore t becomes true eventually as we have to go to s1. 

iii) True. Starting from we can only go to s1 and s2 alternating. Like this: s2->s1->s2->s1.... Therefore q becomes true eventually as we have to go to s2. 

iv) True. The ltl formula r v q is true for all states. Thus G(r v q) will be true for all paths.

