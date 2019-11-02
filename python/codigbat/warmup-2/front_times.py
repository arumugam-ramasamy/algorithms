def front_times(str, n):
  if (n == 0):
    return ""
  if (len(str) < 3):
    front = str 
  else:
    front = str[0:3] 
  if (n == 1) :
    return front 
  timesfront = "" 
  for i in range(n):
    timesfront = timesfront + front 
  
  return timesfront 
  
