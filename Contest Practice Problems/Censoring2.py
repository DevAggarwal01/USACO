import sys
sys.stdin = open("censor.in", "r")
sys.stdout = open("censor.out", "w")

S, T = map(str, (input(),input()))
o = ""

for i in range(len(S)):
	o += S[i]
	if len(o) >= len(T):
		if o[-len(T):] == T:
			o = o[:-len(T)]

print(o)