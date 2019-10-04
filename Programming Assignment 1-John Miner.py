# number 1
s = 1
m = 60 * s
h = 60 * m
d = 24 * h
y = 365 * d

seconds_in_century = y * 100
print("1)", int(seconds_in_century))

# number 2
remainder_with_mod = 5789248 % 6
print("2)", int(remainder_with_mod))

# number 3
x = 5789248
y = 6
remainder_without_mod = x - (y * (x // y))
print("3)", int(remainder_without_mod))

print("4)", {(pow(x, 4) - 2) for x in {1, 3, 5, 7, 11}})

M = [11, -2, 8, 15, 22]
print("5)", {((x**3) - M.index(x)) for x in M})

A = list(range(1, 31))
a = {(x**3)for x in A}
B = list(range(1, 31))
b = {(x * 3)for x in B}
C = a & b
print(C)