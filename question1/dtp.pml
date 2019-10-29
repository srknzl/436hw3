// Serkan Özel // 2015400123 // serkan.ozel@boun.edu.tr
//CMPE436-Assignment 3
bool s = 1;
bool c1 = 0; // Process 1 in cs
bool c0 = 0; // Process 0 in cs
bool t0 = 0; // Process 0 wants to enter cs
bool t1 = 0; // Process 1 wants to ente cs
active [2] proctype P()	{
       byte y=0;
       do ::
        
        /* Non critical section */
        atomic { // These run together without intervention
            y = 1;
            s = _pid;
        }
		if // Set want to get into critical section 
		:: _pid == 0 -> t0 = 1
		:: _pid == 1 -> t1 = 1
		fi
        P[1-_pid]:y == 0 || s != _pid;
		if // Set in cs
		:: _pid == 0 -> c0 = 1
		:: _pid == 1 -> c1 = 1
		fi
		if // Set do not want to enter into cs
		:: _pid == 0 -> t0 = 0
		:: _pid == 1 -> t1 = 0
		fi
        
        /* Critical section */
		if // Set not in critical section 
		:: _pid == 0 -> c0 = 0
		:: _pid == 1 -> c1 = 0
		fi
        
        y = 0;
	od;
}
// Tried to give all ltl rules at once below. 
// Then instead I decided to check all of them seperately by running never claims one by one
// never  {    /* ([] (t0 -> <>c0)) && ([] (t1 -> <>c1)) && ([] !(c1 && c0)) && ([] <> c1) && ([] <> c0) */
// T0_init:
// 	do
// 	:: (! ((c1 && c0)) && (c0) && (c1)) -> goto accept_S81
// 	:: (! ((c1 && c0)) && (c0)) -> goto T1_S81
// 	:: (! ((c1 && c0))) -> goto T0_init
// 	od;
// accept_S81:
// 	do
// 	:: (! ((c1 && c0))) -> goto T0_init
// 	od;
// T1_S81:
// 	do
// 	:: (! ((c1 && c0)) && (c1)) -> goto accept_S81
// 	:: (! ((c1 && c0))) -> goto T1_S81
// 	od;
// }
////////////////////////////////
never  {    /* ([] !(c1 && c0)) Safety G !( c1 ^ c0 ) */
accept_init:
T0_init:
	do
	:: (! ((c1 && c0))) -> goto T0_init
	od;
}
never  {    /* ([] (t0 -> <>c0))        Liveness for P0     G(t0 -> Fc0 )*/
T0_init:
	do
	:: (((! ((t0))) || ((c0)))) -> goto accept_S20
	:: (1) -> goto T0_S27
	od;
accept_S20:
	do
	:: (((! ((t0))) || ((c0)))) -> goto T0_init
	:: (1) -> goto T0_S27
	od;
accept_S27:
	do
	:: ((c0)) -> goto T0_init
	:: (1) -> goto T0_S27
	od;
T0_S27:
	do
	:: ((c0)) -> goto accept_S20
	:: (1) -> goto T0_S27
	:: ((c0)) -> goto accept_S27
	od;
}
never  {    /* ([] (t1 -> <>c1))   Liveness for P1    G(t1 -> Fc1 )*/
T0_init:
	do
	:: (((! ((t1))) || ((c1)))) -> goto accept_S20
	:: (1) -> goto T0_S27
	od;
accept_S20:
	do
	:: (((! ((t1))) || ((c1)))) -> goto T0_init
	:: (1) -> goto T0_S27
	od;
accept_S27:
	do
	:: ((c1)) -> goto T0_init
	:: (1) -> goto T0_S27
	od;
T0_S27:
	do
	:: ((c1)) -> goto accept_S20
	:: (1) -> goto T0_S27
	:: ((c1)) -> goto accept_S27
	od;
}
never  {    /* ([] <> c0) P0 will occupy its critical section infinitely often G(Fc0 )*/
T0_init:
	do
	:: ((c0)) -> goto accept_S9
	:: (1) -> goto T0_init
	od;
accept_S9:
	do
	:: (1) -> goto T0_init
	od;
}

never  {    /* ([] <> c1)  P1 will occupy its critical section infinitely often G(Fc1 )*/
T0_init:
	do
	:: ((c1)) -> goto accept_S9
	:: (1) -> goto T0_init
	od;
accept_S9:
	do
	:: (1) -> goto T0_init
	od;
}
