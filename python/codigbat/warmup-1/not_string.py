def not_string(str):
  if (len(str) < 3):
    return ("not " + str) 
  if(str[0:3] == "not"):
    return str
  return ("not " + str) 
