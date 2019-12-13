import sys

def si(principal, interest, term):
    interest = interest/100.0
    return principal * interest * term

def main():
    # print command line arguments
    print si(float(sys.argv[1]), float(sys.argv[2]), float(sys.argv[3])) 
            
if __name__ == "__main__":
    main()
