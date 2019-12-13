import sys

def isPalindrome(str) :
    rev = str[::-1]
    if (rev == str) :
        return True
    return False

def isPalin(str) :
    middle = len(str)/2
    for i in range(middle):
        if (str[i] != str[len(str)-i-1]):
            return False
    return True 

    
def main():
    # print command line arguments
    for arg in sys.argv[1:]:
        print isPalindrome(arg)
        print isPalin(arg)
            
if __name__ == "__main__":
    main()
