import sys

def add(num1, num2) :
    return (float(num1) + float(num2)) ;

def main():
    # print command line arguments
    print add(sys.argv[1], sys.argv[2]) 
            
if __name__ == "__main__":
    main()
