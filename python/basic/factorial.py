import sys

def factorialr (num) :
    num = int(num)
    if (num <= 1):
        return 1
    return num * factorialr(num-1)

def factorial(num) :
    if (num <= 1):
        return num
    factv = 1
    for i in range(num):
        factv = factv * (i+1)
    return factv

def main():
    # print command line arguments
    print factorialr(int(sys.argv[1]))

    print factorial(int(sys.argv[1]))
            
if __name__ == "__main__":
    main()
