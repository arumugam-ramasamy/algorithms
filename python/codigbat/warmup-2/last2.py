def last2(str):
  if (len(str) < 3) :
    return 0
  count = 0 
  lst2 = str[len(str)-2:len(str)]
  for i in range(0,len(str)-2,1) :
    if (str[i:i+2] == lst2) :
      count = count +1 
  #count = str.count(str[len(str)-2:len(str)], 0, len(str)-1) 
  return count 
