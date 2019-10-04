# John Miner

#Question 1:
def modulus_product(base, exponent, divisor):
    # converting to binary
    binary_number = bin(exponent)
    new_value = []
    ans = 1
    for index in range(len(binary_number) - 1):
        if (index == 0):
            new_value.append(1)
        elif index == 1:
            new_value.append(base % divisor)
        else:
            new_v = (new_value[index - 1] * new_value[index - 1]) % divisor
            new_value.append(new_v)
    remainders = []
    length = len(binary_number)
    for i in range(length - 2):
        if binary_number[length - i - 1] == '1':
            remainders.append(new_value[i + 1])
    for i in remainders:
        ans = ans * i;

#    print(ans % divisor)
#modulus_product(3, 644, 645)

# Question 2
def isPrime(L):
    val = []
    for i in range(len(L)):
        if L[i] == 2:
            val.append(L[i])
        elif ((2**(L[i] - 1)) % L[i]) == 1:
            val.append(L[i])
    return val

#print(isPrime([2, 5, 8, 10, 13]))